import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] list = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            list[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));
        
        if(list[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            sb.append(list[i]);
        }
        return sb.toString();
    }
}