import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        //모든 숫자의 합/2 가 큐 두개에 각 더했을 때 숫자.
        //어떻게 해도 안된다면 -1
        //빼고 넣고 시행. 어떤기준? 완탐으로 하면 안될거같은데..
        
        Deque<Long> q1 = new ArrayDeque<>();
        Deque<Long> q2 = new ArrayDeque<>();
        long target = 0;
        long q1Num=0;
        long q2Num=0;
        for(int i = 0; i < queue1.length; i++){
            target+= (long) queue1[i] + queue2[i];
            q1Num += (long)queue1[i];
            q2Num += (long)queue2[i];
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
        }
        if(target % 2 ==1){
            return -1;
        }
        target = target/2;
        //절반 숫자 구함.
        //큐당 숫자 구함.
        int t = queue1.length * 4;
        int answer = 0;
        
        while(t-- > 0){
            answer++;
            if(q1Num > q2Num){
                long poped = q1.pop();
                q2.add(poped);
                q1Num -= poped;
                q2Num += poped;
                if(q1Num == q2Num){
                    return answer;
                }
            } else if(q1Num < q2Num) {
                long poped = q2.pop();
                q1.add(poped);
                q2Num -= poped;
                q1Num += poped;
                if(q1Num == q2Num){
                    return answer;
                }
            } else {
                return 0;
            }

        }
        
        
        return -1;
    }
}