import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = make(str1);
        Map<String, Integer> map2 = make(str2);
        int answer = 0;
        int intersection = 0;
        int union = 0;
        //리스트에서 꺼낸 수가 1보다 크면 교집합에서는 최소. 합집합에서는 최대.
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        for(String key : keys){
            int count1 = map1.getOrDefault(key,0);
            int count2 = map2.getOrDefault(key,0);
            
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        if(union == 0 && intersection == 0){
            return 65536;
        }
        if(union == 0){
            return 65536;
        }
        
        answer = (int)((double) intersection/union * 65536);
    
        
        
        //생성한 집합 합집합, 교집합 생성.
        //계산.
        
        return answer;
    }
    
    static Map<String, Integer> make(String str){
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        for(int i = 0; i < str.length() - 1; i++){
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            
            if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z'){
                String input = str.substring(i, i + 2);
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }
        return map;
    }
}