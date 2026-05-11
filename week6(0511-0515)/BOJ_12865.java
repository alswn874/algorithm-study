package v_dp;

import java.util.*;
import java.io.*;

public class Main_bj_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		int[][] arr = new int[N][2];
		int[] dp = new int[K+1];
		dp[0] = 0;
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int k=K; k>=arr[i][0]; k--) {
				dp[k] = Math.max(dp[k], dp[k-arr[i][0]] + arr[i][1]) ;
			}
			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(dp[K]);
	}
}

/*
4 7
6 13
4 8
3 6
5 12
*/

/*
0	1	2	3	4	5	6	7	- index
0	0	0	0	0	0	0	0	- memo
0	0	0	0	0	0	13	13	- i : 1 / W[1] : 6 / V[1] : 13 / j : 7,6
0	0	0	0	8	8	13	13	- i : 2 / W[2] : 4 / V[2] : 8 / j : 7,6,5,4
0	0	0	0	8	8	13	14	- i : 3 / W[3] : 3 / V[3] : 6 / j : 7,6,5,4,3
0	0	0	0	8	12	13	14	- i : 4 / W[4] : 5 / V[3] : 6 / j : 7,6,5
*/