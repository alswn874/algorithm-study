import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        boolean[][] brid = new boolean[N][N];
        boolean[] visited = new boolean[N];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            brid[a-1][b-1] = true;
            brid[b-1][a-1] = true;
        }
        for(int i=0; i<N; i++) {
        	visited[i] = false;
        }
        
        dfs(start-1, visited, brid);
        System.out.println();
        
        for(int i=0; i<N; i++) {
        	visited[i] = false;
        }
        
        q.offer(start-1);
        int[] q_answer = new int[N];
        int idx = 0;
        
        while(!q.isEmpty()) {
        	int p = q.poll();
            if(visited[p]) continue;
            System.out.print(p+1 + " ");
        	visited[p] = true;
        	q_answer[idx++] = p+1;
        	for(int i=0; i<N; i++) {
    			if(visited[i]) continue;
    			if(!visited[i] && brid[p][i]) {
    				q.offer(i);
    			}
    		}
        }
        
	}
	
	public static void dfs(int start, boolean[] visited, boolean[][] brid) {
		visited[start] = true;
		System.out.print(start+1 + " ");
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && brid[start][i]) {
				dfs(i, visited, brid);
			}
		}
		return;
	}
}