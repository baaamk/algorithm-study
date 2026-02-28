import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 1];
                
        int answer = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = 1;
        }
        
        
        for(int i = 0; i < lost.length; i++){
            int m = lost[i];
            arr[m]--;
        }
        
        for(int i = 0; i < reserve.length; i++){
            int m = reserve[i];
            arr[m]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(arr[i] < 1){
                if(i - 1 >= 1 && arr[i - 1] > 1){
                    arr[i]++;
                    arr[i - 1]--;
                    
                } else if(i + 1 <= n && arr[i + 1] > 1){
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(arr[i] >= 1){
                answer++;
            }
        }
        
        

        return answer;
    }
}