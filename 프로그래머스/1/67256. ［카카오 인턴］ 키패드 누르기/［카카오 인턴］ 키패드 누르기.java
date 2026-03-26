import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        int[] left = new int[] {3,0};
        int[] right = new int[] {3,2};
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 ||numbers[i] == 4||numbers[i] == 7){
                sb.append("L");
                left = new int[] {numbers[i]/3,0};
            } else if(numbers[i] == 3 ||numbers[i] == 6||numbers[i] == 9){
                sb.append("R");
                right = new int[] {numbers[i]/3 - 1,2};
            } else {
                if(numbers[i] == 0){
                    numbers[i] = 9;
                }
                int[] temp = {numbers[i]/3, 1};
                int lr = left[0];
                int lc = left[1];
                int rr = right[0];
                int rc = right[1];
                int ld = Math.abs(temp[0] - lr) + Math.abs(temp[1] - lc);
                int rd = Math.abs(temp[0] - rr) + Math.abs(temp[1] - rc);
                if(ld < rd){
                    sb.append("L");
                    left = new int[] {numbers[i]/3,1};
                } else if(ld > rd){
                    sb.append("R");
                    right = new int[] {numbers[i]/3,1};
                } else {
                    if(hand.equals("right")){
                        sb.append("R");
                        right = new int[] {numbers[i]/3,1};
                    } else {
                        sb.append("L");
                        left = new int[] {numbers[i]/3,1};
                    }
                }
            }
            
        }
        String answer = sb.toString();
        return answer;
    }
}