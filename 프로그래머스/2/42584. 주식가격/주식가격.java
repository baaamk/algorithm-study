class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            int m = prices[i];
            int count = -1;
            for(int j = i; j < n; j++){
                count++;
                if(m > prices[j]){
                    break;   
                }

            }
            answer[i] = count;
        }
        
        
        return answer;
    }
}