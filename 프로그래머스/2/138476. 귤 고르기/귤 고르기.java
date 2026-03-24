import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int max = 0;
        
        for(int i = 0; i < tangerine.length; i++){
            max = Math.max(max, tangerine[i]);
        }
        
        int[][] arr = new int[max + 1][1];
        for(int i = 0; i < tangerine.length; i++){
            arr[tangerine[i]][0]++;
        }
        
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(k <= 0){
                break;
            }
            k = k - arr[i][0];
            answer++;
        }
        
        return answer;
    }
}

