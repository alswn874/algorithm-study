import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        Queue<Integer> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        

        int N = Integer.parseInt(br.readLine());
        int last = -1;
        
        for(int i=0; i<N; i++){
            String now = br.readLine();
            if(now.contains("push")){
                int tmp = Integer.parseInt(now.substring(5));
                q.offer(tmp);
                last = tmp;
            }
            else if(now.contains("pop")){
                System.out.println(q.isEmpty()? -1 : q.poll());
            }
            else if(now.contains("size")){
                System.out.println(q.size());
            }
            else if(now.contains("empty")){
                System.out.println(q.isEmpty()? 1 : 0);
            }
            else if(now.contains("front")){
                System.out.println(q.isEmpty()? -1 : q.peek());
            }
            else if(now.contains("back")){
                System.out.println(q.isEmpty()? -1 : last);
            }
        }

        
    }
}