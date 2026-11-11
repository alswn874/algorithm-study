import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        int[][] a = {{102, 9999}, {103, 1234}};
        String b = "102#1234#142#103#1234#102#9992";

        int result = solution(a, b);
        System.out.println(result);
    }

    public static int solution(int[][] a, String b){
        HashMap<String, String> map = new HashMap<>();
        int answer = 0;

        for(int i=0; i<a.length; i++){
            map.put(a[i][0]+"", a[i][1]+"");
        }
        
        String[] tokens = b.split("#");

        int i=0;
        while(i<tokens.length){
            if(!map.containsKey(tokens[i])) {
                i ++;
                continue;
            }
            if(i+1 < tokens.length && (tokens[i+1]).equals(map.get(tokens[i]))){ 
                answer ++;
            }
            i+=2;
        }
        
        return answer;
    }
}