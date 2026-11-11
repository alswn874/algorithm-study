import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left + 1)];
        
        for(long idx=left; idx<=right; idx++){
            long i = idx / n;
            long j = idx % n;
            
            long max = 0;
            if(i < j){
                max = j;
            }
            else{
                max = i;
            }
            answer[(int) (idx-left)] = (int)max +1;
            
        }
        
        return answer;
    }
}