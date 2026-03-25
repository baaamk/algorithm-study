import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        int i = 0;
        int nextIndex = 27;
        while(i < msg.length()){
            String w = "";
            int idx = 0;
            int j = i;
            
            while(j < msg.length()){
                String temp = msg.substring(i, j + 1);
                if(map.containsKey(temp)){
                    w = temp;
                    idx = map.get(temp);
                    j++;
                } else {
                    break;
                }
                
            }
            list.add(idx);
            if(j < msg.length()){
                String newWord = msg.substring(i, j+1);
                map.put(newWord, nextIndex++);
            }
            
            i += w.length();
        }
        
        int[] answer = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            answer[k] = list.get(k);
        }
        return answer;
    }
}