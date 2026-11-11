import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int answer = 0;

        for(int i=0; i<N; i++){
            if(is_prime(scan.nextInt())){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean is_prime(int n){
        if(n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }
}