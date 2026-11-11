import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        
        int answer = 0;
        int[] di = {0,0,1,-1}; // E W S N
        int[] dj = {1,-1,0,0}; // E W S N
        
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;
                if(q.isEmpty()){
                    answer ++;
                    int[] tmp = {i, j};
                    q.offer(tmp);
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        int[] pop = q.poll();
                        for(int idx=0; idx<4; idx++){
                            int ni = pop[0] + di[idx];
                            int nj = pop[1] + dj[idx];
                
                            if(ni >= 0 && ni < N && nj >=0 && nj < N){
                                if(arr[pop[0]] [pop[1]] == arr[ni][nj] && !visited[ni][nj]){
                                    int[] temp = {ni , nj};
                                    q.offer(temp);
                                    visited[ni][nj] = true;
                                } //if check
                            } // if direction
                        }
                    }
                }
            }
        } // for i

        visited = new boolean[N][N];
        q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 'R'){
                    arr[i][j] = 'G';
                }
            }
        }

        int answer2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;
                if(q.isEmpty()){
                    answer2 ++;
                    int[] tmp = {i, j};
                    q.offer(tmp);
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        int[] pop = q.poll();
                        for(int idx=0; idx<4; idx++){
                            int ni = pop[0] + di[idx];
                            int nj = pop[1] + dj[idx];
                
                            if(ni >= 0 && ni < N && nj >=0 && nj < N){
                                if(arr[pop[0]] [pop[1]] == arr[ni][nj] && !visited[ni][nj]){
                                    int[] temp = {ni , nj};
                                    q.offer(temp);
                                    visited[ni][nj] = true;
                                } //if check
                            } // if direction
                        }
                    }
                }
            }
        } // for i

        

        System.out.print(answer + " " + answer2);

        
    } // main
}