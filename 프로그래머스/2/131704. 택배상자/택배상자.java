import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;
        int box = 1;
        
        for(int i = 0; i < order.length; i++){
            int target = order[i];
            
            while (box <= order.length && box < target){
                deque.push(box);
                box++;
            }
            
            if(box == target){
                answer++;
                box++;
            } else if(!deque.isEmpty() && deque.peek() == target){
                deque.pop();
                answer++;
            } else {
                break;
            }
            
        }
        
        
        
        return answer;
    }
}