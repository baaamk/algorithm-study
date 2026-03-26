import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(!dq.isEmpty() && dq.peekLast() == s.charAt(i)){
                dq.pollLast();
            } else {
                dq.add(s.charAt(i));
            }
        }
        
        if(dq.size() != 0){
            return answer;
        }
        
    

        return 1;
    }
}