package s_divideconquer;

import java.util.*;
import java.io.*;

public class Main_bj_2630_색종이만들기 {

	static int[][] arr;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		ans = new int[2];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		q.offer(new int[] {0,0,N});
		while(!q.isEmpty()) {
			int[] pop = q.poll();
			if(isSame(pop[0], pop[1], pop[2])) {
				ans[arr[pop[0]] [pop[1]] ]++;
//				System.out.println(Arrays.toString(ans) + ": "+ pop[0] + " " + pop[1] + " " + pop[2]);
			}
			else {
				
				int n = pop[2]/2;
//				System.out.println("=========="+ n);
				q.offer(new int[] {pop[0], pop[1], n});
				q.offer(new int[] {pop[0]+n, pop[1], n});
				q.offer(new int[] {pop[0], pop[1]+n, n});
				q.offer(new int[] {pop[0]+n, pop[1]+n, n});
				
			}
		}
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		
	}
	
	static boolean isSame(int si, int sj, int n) {
		if(n == 1)
			return true;
		
		int check = arr[si][sj];
		for(int i=si; i<si+n; i++) {
			for(int j=sj; j<sj+n; j++) {
				if(arr[i][j] != check) return false;
			}
		}
		return true;
	}

}

/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
 */