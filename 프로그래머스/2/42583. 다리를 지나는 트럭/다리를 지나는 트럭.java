import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sumWeight = 0;
        int idx = 0;

        Deque<Integer> bridge = new ArrayDeque<>();

        
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        
        
        while(idx < truck_weights.length){
            time++;
            
            sumWeight -= bridge.poll();
            
            if(sumWeight + truck_weights[idx] <= weight){
                bridge.add(truck_weights[idx]);
                sumWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        
        
        return time + bridge_length;
    }
}
