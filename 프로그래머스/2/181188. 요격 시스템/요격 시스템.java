import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int count = 0;
        int current = -1;
        
        for(int i = 0; i < targets.length; i++){
            int start = targets[i][0];
            int end = targets[i][1];
            if(start >= current){
                count++;
                current = end;
            }
        }
        

        return count;
    }
}