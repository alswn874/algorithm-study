import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        while(!s.equals("1")){
            answer[0] += 1;
            int cnt = 0;
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    cnt++;
                }
            }
            answer[1] += s.length() - cnt;
            s = Integer.toBinaryString(cnt);
            
        } //while
        
        return answer;
        
    }
}