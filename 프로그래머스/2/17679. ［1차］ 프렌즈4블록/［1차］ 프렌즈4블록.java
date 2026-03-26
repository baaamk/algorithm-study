class Solution {
    public int solution(int m, int n, String[] board) {
        int[] dr = {1, 1, 0};
        int[] dc = {0, 1, 1};
        
        char[][] map = new char[m][n];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        int answer = 0;
        while(true){
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char cur = map[i][j];
                    if (cur == '0') continue;

                    if (cur == map[i][j+1] &&
                        cur == map[i+1][j] &&
                        cur == map[i+1][j+1]) {

                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                        check[i+1][j+1] = true;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '0';
                        cnt++;
                    }
                }
            }
            if (cnt == 0) break;
            answer += cnt;
            
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '0') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '0') {
                                map[i][j] = map[k][j];
                                map[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
            
            //초기에서 터뜨림.
            //터뜨리고 내리고 터ㄸ리고 반복
            //없다면 끝
        }
        
        return answer;
    }
}