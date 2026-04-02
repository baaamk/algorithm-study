import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //1. 1,2 섞고 정렬
        //2. 정렬 수 모든 값이 K 이상인지 / 이상이라면 리턴
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size() != 1){
            if(pq.peek() >= K){
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            int temp = a + (b * 2);
            pq.add(temp);
            answer++;
        }
        if(pq.poll() < K){
            answer = -1;
        }
        return answer;
    }
}
