package k_graph;

import java.util.*;
import java.io.*;

public class Main_bj_2468_안전영역 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] maps = new int[N][N];
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		
		int max = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				maps[i][j] = Integer.parseInt(token.nextToken());
				max = Math.max(max, maps[i][j]);
			}
		}
		
		int answer = 0;
		for(int h=1; h<=max; h++) {
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					Queue<int[]> q = new LinkedList<>();
					if(visited[i][j] || (maps[i][j] <= h)) continue;
//					System.out.println("-----------------------");
//					System.out.println("offer: " + i + " " + j);
					q.offer(new int[] {i,j});
//					visited[i][j] = true;
					cnt ++;
					
					while(!q.isEmpty()) {
						int[] pop = q.poll();
						if(visited[pop[0]][pop[1]]) continue;
//						System.out.println("pop: " + pop[0] + " " + pop[1]);
						visited[pop[0]][pop[1]] = true;
						
						for(int idx=0; idx<4; idx++) {
							int x = pop[0]+di[idx];
							int y = pop[1]+dj[idx];
							
							if(x<0 || y<0 || x>=N || y>=N) continue;
							if(visited[x][y] || maps[x][y] <= h) continue;
							
							q.offer(new int[] {x,y});
//							System.out.println("offer: " + x + " " + y);
							
						}
					}
				}
			}
//			System.out.println(h + " : " + cnt);
			answer = Math.max(answer, cnt);
			
			
		} // for h

		
		System.out.println(answer==0? 1 : answer);
	}

}

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7

7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9
 */