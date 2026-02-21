import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int spot = commands[i][2] - 1;
            List<Integer> list = new ArrayList<>();
            for(int j = start; j <= end; j++){
                list.add(array[j]);
            }
            list.sort(Comparator.naturalOrder());
            answer[i] = list.get(spot);
        }
        
        return answer;
    }
}