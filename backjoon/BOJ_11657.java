import java.util.*;
import java.io.*;

public class Main {

	static class Edge {
		int u;
		int v;
		int w;
		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[][] edge = new int[M][3];
		long[] dist = new long[N];
		ArrayList<Edge> edges = new ArrayList<>();
		
		Arrays.fill(dist, 987654321);
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken())-1;
			int b = Integer.parseInt(token.nextToken())-1;
			int c = Integer.parseInt(token.nextToken());
			edges.add(new Edge(a,b,c));
		}
		
		dist[0] = 0;
		for(int i=1; i<N; i++) {
			for (Edge e: edges) {
				if(dist[e.u] == 987654321) continue;
				
				if(dist[e.v] > dist[e.u] + e.w) {
					dist[e.v] = dist[e.u] + e.w;
				}
			}
		}
		
		for (Edge e: edges) {
			if(dist[e.u] == 987654321) continue;
			
			if(dist[e.v] > dist[e.u] + e.w) {
				System.out.println(-1);
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N; i++) {
			if(dist[i] == 987654321) sb.append("-1\n");
			else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
