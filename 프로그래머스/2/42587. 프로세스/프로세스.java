import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < priorities.length; i++){
            queue.add(priorities[i]);
        }
        int answer = 1;
        
        while(!queue.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(queue.peek() == priorities[i]){
                    if(i == location){
                        return answer;
                    }
                    queue.poll();
                
                    answer++;
                }
            }
        }
        return answer;
    }
}