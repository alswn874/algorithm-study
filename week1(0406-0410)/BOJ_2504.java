import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = new String(scan.nextLine());
        Stack<Character> stk = new Stack<>();
        
        int answer = 0;
        int cal = 1;

        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)) {
                case '(' : 
                    stk.push(s.charAt(i));
                    cal *= 2;
                    break;
                case '[' : 
                    stk.push(s.charAt(i));
                    cal *= 3;
                    break;
                 //case 1
                case ')' : 
                    if(stk.isEmpty() || stk.peek() != '('){
                        System.out.println(0);
                        return ;
                    } // if

                    
                    if(s.charAt(i-1) == '('){
                        answer += cal;
                    }
                    stk.pop();
                    cal /= 2;
                    break;
                    
                case ']' :
                    if(stk.isEmpty() || stk.peek() != '['){
                        System.out.println(0);
                        return ;
                    } // if
                    if(s.charAt(i-1) == '['){
                        answer += cal;
                    }
                    stk.pop();
                    cal /= 3;
                    break;
            } //switch
        } //for
        
        scan.close();
        if(stk.isEmpty()){
            System.out.println(answer);
        }
        else {
            System.out.println(0);
        }
        return ;
        

        return;
        
    }
}