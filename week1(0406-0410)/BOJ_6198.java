import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        int N = scan.nextInt();
        long answer = 0;

        
        for(int i=0; i<N; i++){
            int h = scan.nextInt();

            while(!stk.isEmpty() && stk.peek() <= h){
                stk.pop();
            }
            answer += stk.size();

            stk.push(h);
        }
        System.out.println(answer);
    } // main
}