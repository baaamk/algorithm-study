import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int i = 3; i * i <= total; i++){
            if(total % i != 0){
                continue;
            }
            int w = total / i;
            if (w < i){
                continue;
            }
            if((w - 2) * (i - 2) == yellow){
                return new int[] {w,i};
            }
        }
        return new int[]{0};
    }
}