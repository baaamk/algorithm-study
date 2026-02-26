class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            clothes[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++){
            int a = lost[i];
            clothes[a]--;
        }
        
        for(int i = 0; i < reserve.length; i++){
            clothes[reserve[i]]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(clothes[i] == 0){
                if(i > 0 && clothes[i - 1] == 2){
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if(i < n && clothes[i + 1] == 2){
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(clothes[i] >= 1){
                answer++;
            }
        }
        return answer;
    }
}