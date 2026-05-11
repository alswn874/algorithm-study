package k_graph;

import java.util.*;
import java.io.*;

public class Main_bj_4963_섬의개수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int[] di = {-1, -1, 0, 1, 1, 1, 0, -1}; //상 우상 우 우하 하 좌하 좌 좌상
		int[] dj = {0, 1, 1, 1, 0, -1, -1, -1}; //상 우상 우 우하 하 좌하 좌 좌상
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			
			int W = Integer.parseInt(token.nextToken());
			int H = Integer.parseInt(token.nextToken());
			
			if(W == 0 && H == 0 ) {
				break;
			}
			int[][] map = new int[H][W];
			int answer = 0;
			boolean[][] visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
				} // for j
			} //for i
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 0 || visited[i][j]) continue;
					Queue<int[]> q = new LinkedList<>();
					
					q.offer(new int[] {i,j});
					visited[i][j] = true;
					answer ++ ;
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int idx=0; idx<di.length; idx++) {
							int x = cur[0] + di[idx];
							int y = cur[1] + dj[idx];
							
							if(x < 0 || x >= H || y < 0 || y >= W || map[x][y] == 0 || visited[x][y]) continue;
							q.offer(new int[] {x,y});
							visited[x][y] = true;
						}
					}
				}
			} // for i
			
			sb.append(answer+"\n");
		}
		br.close();
		System.out.println(sb.toString());
		
	}

}
/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

*/