import java.util.*;


class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
            
            if(q.contains(cities[i])){
                answer += 1;
                q.remove(cities[i]);
                q.offer(cities[i]);
                continue;
            }
            else {
                answer += 5;
            }
            if(q.size() < cacheSize){
                q.offer(cities[i]);
            }
            else{
                q.poll();
                q.offer(cities[i]);
            }
            
            
        } //for i
        
        return answer;
    }
}