class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visit = new boolean[n];
        dfs(k, visit, dungeons, 0);
        return answer;
    }
    
    void dfs(int tired, boolean[] visit, int[][] dungeons, int count){
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(dungeons[i][0] <= tired && !visit[i]){
                visit[i] = true;
                dfs(tired - dungeons[i][1], visit, dungeons, count + 1);
                visit[i] = false;
            }
        }
    }
}