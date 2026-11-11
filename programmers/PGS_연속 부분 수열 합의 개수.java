import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum = 0;
                int len = 0;
                while(len<i){
                    sum += elements[(j+len) % elements.length];
                    len++;
                }
                set.add(sum);
            }
            
        }
        return set.size();
    }
}