import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        
        s = s.toLowerCase();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isFirst && ('a' <= c  && c <= 'z')){
                c = Character.toUpperCase(c);
            }
            if (c == ' '){
                isFirst = true;
            }
            else{
                isFirst = false;
            }
            answer += c;
        
        }
        return answer;
    }
}