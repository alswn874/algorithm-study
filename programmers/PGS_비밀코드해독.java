import java.util.*;

class Solution {
    int n;
    int r = 5;
    int[] pick = new int[5];
    int[][] q;
    int[] ans;
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        combination(1,0);
        return answer;
    }
    
    void combination(int start, int depth){

        if (depth == r) {
            // System.out.print(Arrays.toString(pick) + ": ");
            HashSet<Integer> set = new HashSet<>();
            
            for(int i=0; i<pick.length; i++){
                set.add(pick[i]);
            }
            boolean check = true;
            
            for(int i=0; i<q.length; i++){
                int cnt = 0;
                for(int j=0; j<q[i].length; j++){
                    if(set.contains(q[i][j])) cnt ++;
                }
                if(cnt != ans[i]) {
                    // System.out.println(cnt + " != " + ans[i] + " (" + i + ")");
                    check = false;
                    break;
                }
            }
            if(check) {
                
                answer++;
                
            }
            return;
        }
        for(int i=start; i<=n; i++){
            pick[depth] = i;
            combination(i+1, depth +1);
        }
    }
}