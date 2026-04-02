import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        
        
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        for(int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end],0)+1);
            
            while(map.size()==set.size()){
                if(minLength > end - start){
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        
        
        return answer;
    }
}