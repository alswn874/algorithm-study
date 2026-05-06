package p_backtracking;

import java.util.*;
import java.io.*;

public class Main_bj_2580_스도쿠 {
	
	//gpt 코드 - 이해는 함
	static int N = 9;
	static int[][] map = new int[N][N];
	static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer token = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if(map[i][j] == 0) {
					list.add(new int[] {i,j});
				} // if
			} //for j
		} // for i
		
		dfs(0);
		
		
	} //main
	static void dfs(int idx) {
		if(idx == list.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
			return;
		}
		
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		
		for(int num=1; num <=9; num++) {
			if(isPossible(x, y, num)) {
				map[x][y] = num;
				dfs(idx+1);
				map[x][y] = 0;
			}
		}
	}
	
	static boolean isPossible(int x, int y, int num) {
		for(int i=0; i<N; i++) {
			if(map[x][i] == num) return false;
		}
		
		for(int i=0; i<N; i++) {
			if(map[i][y] == num) return false;
		}
		
		int sx = (x/3) * 3;
		int sy = (y/3) * 3;
		
		for(int i=sx; i< sx + 3; i++) {
			for(int j=sy; j< sy + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		return true;
	}

}

/*
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
*/
