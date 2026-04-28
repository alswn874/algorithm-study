
import java.util.*;
import java.io.*;


public class Main {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int T=0;
		while(++T > 0) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(dist[i], 987654321);
			}
			
			for(int i=0; i<N; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
				} // for j
			} // for i
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			dist[0][0] = map[0][0];
			
			pq.offer(new Node(0,0, dist[0][0]));
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(cur.w > dist[cur.x][cur.y]) continue;
				
				for(int d=0; d<4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >=N) continue;
					int nextw = cur.w + map[nx][ny];
					
					if(nextw < dist[nx][ny]) {
						dist[nx][ny] = nextw;
						pq.offer(new Node(nx, ny, nextw));
					}
				}
			}
			
			sb.append("Problem " + T + ": " + dist[N-1][N-1] + "\n");
		} //while
		
		System.out.println(sb.toString());
	}

}
