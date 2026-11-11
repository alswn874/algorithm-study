package q_sort2;

import java.util.*;
import java.io.*;

public class Main_bj_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N];
		Queue<Integer> q = new LinkedList<>();
		int[] depth = new int[N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken())-1;
			int b = Integer.parseInt(token.nextToken())-1;
			graph[a].add(b);
			depth[b] ++;
		}
		
		//
		int cnt = 0;
		while(cnt < N) {
			for(int i=0; i<N; i++) {
				if(depth[i] == 0) {
					q.offer(i);
					depth[i]--;
					cnt++;
				}
			}
			while(!q.isEmpty()) {
				int pop = q.poll();
				System.out.print((pop+1) + " ");
				for(int i=0; i<graph[pop].size(); i++) {
					depth[graph[pop].get(i)] --;
				}
			}
		}
		
		
		
		
		
	}

}

/*
3 2
1 3
2 3
*/

/*
4 2
4 2
3 1

*/
