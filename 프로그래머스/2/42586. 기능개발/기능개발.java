import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] min = new int[progresses.length];
        
        
        for(int i = 0; i < progresses.length; i++){
            int n = 100 - progresses[i];
            if(n % speeds[i] != 0){
                min[i] = n / speeds[i] + 1;
            } else {
                min[i] = n / speeds[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        
        int a = 1;
        int maxDay = min[0];
        for(int i= 1; i < progresses.length; i++){
            if(min[i] > maxDay){
                list.add(a);
                a = 1;
                maxDay = min[i];
            } else {
                a++;
            }
        }
        list.add(a);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
                
        //상위 작업이 진행중이면 안나감.
        return answer;
    }
}