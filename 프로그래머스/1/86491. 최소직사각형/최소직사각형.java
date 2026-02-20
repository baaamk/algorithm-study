class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            int w2 = Math.max(w, h);
            int h2 = Math.min(w, h);
            max = Math.max(max, w2);
            min = Math.max(min, h2);
        }
        answer = max * min;
        return answer;
    }
}