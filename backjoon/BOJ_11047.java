package r_greedy;

import java.util.*;
import java.io.*;

public class Main_bj_11047_동전0 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		int answer = 0;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(arr[i] > K) continue;
			answer += K / arr[i];
			K %= arr[i];
		}
		
		System.out.println(answer);
	}

}
/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
*/

/*
10 4790
1
5
10
50
100
500
1000
5000
10000
50000
*/