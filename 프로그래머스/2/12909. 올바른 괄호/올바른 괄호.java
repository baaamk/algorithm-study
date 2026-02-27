import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> que = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && que.isEmpty()){
                return false;
            }
            if(s.charAt(i) == '('){
                que.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                que.pop();
            }
        }
        if(que.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}