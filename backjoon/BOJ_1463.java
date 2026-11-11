import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] dp = new int[x+1];

        for(int i=2; i<=x; i++){
            if(i%2==0 && i%3 == 0){
                dp[i] = Math.min(dp[i-1], Math.min(dp[i/2], dp[i/3]))+1;
            }
            else if(i%2==0){
                dp[i] = Math.min(dp[i-1], dp[i/2])+1;
            }
            else if(i%3==0){
                dp[i] = Math.min(dp[i-1], dp[i/3])+1;
            }
            else{
                dp[i] = dp[i-1]+1;
            }
            
        }

        System.out.println(dp[x]);
        
        

        
        
    }
}