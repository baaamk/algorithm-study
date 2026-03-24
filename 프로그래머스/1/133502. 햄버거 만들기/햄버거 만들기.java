import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;
    
        for(int i = 0; i < ingredient.length; i++){
            deque.add(ingredient[i]);
            
            if(deque.size() >= 4 && ingredient[i] == 1){
                int a = deque.pollLast();
                int b = deque.pollLast();
                int c = deque.pollLast();
                int d = deque.pollLast();
                
                if(a == 1 && b == 3 && c==2 && d==1){
                    answer ++;
                } else {
                    deque.add(d);
                    deque.add(c);
                    deque.add(b);
                    deque.add(a);
                }
            }
            
        }

        return answer;
    }
}