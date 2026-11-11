package o_simulation;
import java.util.*;
import java.io.*;

public class Main_bj_16234_인구이동 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int answer = 0;
		int N = Integer.parseInt(token.nextToken());
		int L = Integer.parseInt(token.nextToken());
		int R = Integer.parseInt(token.nextToken());
		
		int[][] arr = new int[N][N];
		boolean moved = false;
		
		int[] di = {0,0,-1,1};
		int[] dj = {1,-1,0,0};
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		while(true) {
			moved = false;
			boolean[][] visited = new boolean[N][N];
			int[][] temp = arr;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					
					ArrayList<int[]> list = new ArrayList<>();
					Queue<int[]> q = new LinkedList<>();
					int sum = 0;
					
					q.offer(new int[] {i,j});
					visited[i][j] = true;
//					System.out.println("offer: " + i + " " + j);
					list.add(new int[] {i,j});
					sum = arr[i][j];
					
					while(!q.isEmpty()) {
						
						int[] pop = q.poll();
//						if(visited[pop[0]][pop[1]]) continue;
//						System.out.println("pop: " + pop[0] + " " + pop[1]);
						for(int idx=0; idx<4; idx++) {
							int x = pop[0] + di[idx];
							int y = pop[1] + dj[idx];
							
							if(x<0 || x >=N || y<0 || y >= N) continue;
							if(visited[x][y]) continue;
							int cal = Math.abs(arr[pop[0]][pop[1]] - arr[x][y]);
							if(cal < L || cal > R) continue;
							
							list.add(new int[] {x,y});
							q.offer(new int[] {x,y});
							visited[x][y] = true;
//							System.out.println("offer: " + x + " " + y + " - because of: " + pop[0] + "," + pop[1]);
							sum += arr[x][y];
//							if(list.size() > 1) {
							moved = true;
//							} // if
						} //for idx
					} //while
					
					if(list.size() > 1 ) {
						int avg = sum / list.size();
						for(int[] change : list) {
							temp[change[0]] [change[1]] = avg;
						}
					}
					
				}
			}
			arr = temp;
			
//			System.out.println(answer + " : " + moved);
			if(moved) {
				answer++;
			}
			else {
				break;
			}
			
			
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
		} //while true
		
		System.out.println(answer);
	} //main

}

/*
2 20 50
50 30
20 40
 */

/*
3 5 10
10 15 20
20 30 25
40 22 10
 */

/*
4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
 */
