import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            String tmp = s.substring(i, s.length());
            tmp+=s.substring(0, i);
            if(correct(tmp)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean correct(String str){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                stk.push(str.charAt(i));
            }
            else{
                if(stk.isEmpty()) return false;
                
                
                if(str.charAt(i) == ')'){
                    if(stk.peek() == '('){
                        char ch = stk.pop();
                    }
                    else{
                        return false;
                    }
                    
                }
                else if(str.charAt(i) == '}'){
                    if(stk.peek() == '{'){
                        char ch = stk.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if(str.charAt(i) == ']'){
                    if(stk.peek() == '['){
                        char ch = stk.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}