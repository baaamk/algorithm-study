import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        Map<Integer, Integer> right = new HashMap<>();
        for(int t : topping){
            right.put(t, right.getOrDefault(t,0)+1);
        }
        Set<Integer> left = new HashSet<>();
        
        for (int t : topping) {
            left.add(t);           // 왼쪽 추가

            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) right.remove(t); // 오른쪽 제거

            if (left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}