import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int N = storage.length;
        int M = storage[0].length();
        
        boolean[][] outline = new boolean[N][M];
        char[][] strg = new char[N][M];
        int[] dirI = {-1,1,0,0}; // UDLR
        int[] dirJ = {0,0,-1,1};
        
        for(int i=0; i<N; i++){
            strg[i] = storage[i].toCharArray();
        }
        for (int i=0; i<N; i++){
            outline[i][0] = true;
            outline[i][M-1] = true;
        }
        for(int j=0; j<M; j++){
            outline[0][j] = true;
            outline[N-1][j] = true;
        }
        
        for(String request : requests){
            
            if(request.length() == 1) { // 지게차
                Queue<char[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[N][M];
                
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(i==0 || i == N-1 || j == 0 || j == M-1) {
                            q.offer(new char[] {(char) i , (char) j, strg[i][j]});
                        } // if outline
                        
                    } //for i
                } // for j
                
                while(!q.isEmpty()){
                    char[] now = q.poll();
                    int i = (int) now[0];
                    int j = (int) now[1];
                    int nowStr = now[2];
                    
                    if(visited[i][j]) continue;
                    
                    visited[i][j] = true;
                    if(nowStr == request.charAt(0)){
                        answer ++;
                        strg[i][j] = '*';
                    } 
                    if(nowStr == '*'){
                        for(int idx=0; idx<4; idx++){
                            int ni = i + dirI[idx];
                            int nj = j + dirJ[idx];
                            if(ni >= N || ni < 0 || nj >= M || nj < 0) continue;
                            q.offer(new char[] {(char) ni, (char) nj, strg[ni][nj]});
                        }
                    } // if strg == x
                    
                }
                
            } // if end
            else{ // 크레인
                
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(strg[i][j] != request.charAt(0)) continue;
                        
                        strg[i][j] = '*';
                        answer ++;
                        } // for j
                    } // for i
                } // else
                
            // System.out.println("\nrequest: " + request);
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(strg[i]));
            // }
        } // request
        return N * M - answer;
    }
}

/* 초기 풀이
 import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int N = storage.length;
        int M = storage[0].length();
        
        boolean[][] outline = new boolean[N][M];
        char[][] strg = new char[N][M];
        int[] dirI = {-1,1,0,0}; // UDLR
        int[] dirJ = {0,0,-1,1};
        
        for(int i=0; i<N; i++){
            strg[i] = storage[i].toCharArray();
        }
        for (int i=0; i<N; i++){
            outline[i][0] = true;
            outline[i][M-1] = true;
        }
        for(int j=0; j<M; j++){
            outline[0][j] = true;
            outline[N-1][j] = true;
        }
        
        for(String request : requests){
            boolean[][] newOutline = new boolean[N][M];
            for(int i=0; i<N; i++){
                newOutline[i] = outline[i].clone();
            }
            
            if(request.length() == 1) { // 지게차
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(strg[i][j] != request.charAt(0)) continue;
                        if(!outline[i][j]) continue;
                        
                        strg[i][j] = 'x';
                        answer ++;
                        for(int dirIdx = 0; dirIdx <4; dirIdx++){
                            int ni = i + dirI[dirIdx];
                            int nj = j + dirJ[dirIdx];
                            
                            if(ni>=N || ni<0 || nj>=M || nj<0) continue;
                            newOutline[ni][nj] = true;
                        }
                        
                    }
                } // for i
                
            } // if end
            else{ // 크레인
                
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(strg[i][j] != request.charAt(0)) continue;
                        
                        strg[i][j] = 'x';
                        answer ++;
                        if(outline[i][j] || newOutline[i][j]){
                            for(int dirIdx = 0; dirIdx <4; dirIdx++){
                            int ni = i + dirI[dirIdx];
                            int nj = j + dirJ[dirIdx];
                            
                            if(ni>=N || ni<0 || nj>=M || nj<0) continue;
                            newOutline[ni][nj] = true;
                        }
                        }
                    }
                } // for i
                
                
            }
            for(int i=0; i<N; i++){
                outline[i] = newOutline[i].clone();
            }
            // System.out.println("\nrequest: " + request);
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(strg[i]));
            // }
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(outline[i]));
            // }
            
        } // request
        return N * M - answer;
    }
}

 */