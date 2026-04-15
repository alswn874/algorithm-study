import java.util.*;


class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<topping.length; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<topping.length; i++){
            int num = map.get(topping[i]);
            if(num > 1){
                map.put(topping[i], num - 1);
            }
            else{
                map.remove(topping[i]);
            }
            
            
            set.add(topping[i]);
            
            if(map.size() == set.size()){
                answer++;
            }
        }
        return answer;
    }
}