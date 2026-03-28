class Solution {
    public int[] solution(String[] wallpaper) {
        
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int minr = Integer.MAX_VALUE;
        int minc = Integer.MAX_VALUE;
        int maxr = 0;
        int maxc = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minr = Math.min(minr, i);
                    maxr = Math.max(maxr, i);
                    minc = Math.min(minc, j);
                    maxc = Math.max(maxc, j);
                }
            }
        }
        int[] answer = {minr, minc, maxr + 1, maxc+1};
        return answer;
        
        
        //1. 먼저 배열 생성.
        //2. 각 제일 넓게 있는 좌표 구하기. -> 배열 만들때마다 비교해서 구하기.
    }
}