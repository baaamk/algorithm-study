import java.util.*;

class Solution {
    static int[] dr = {1,0,-1};
    static int[] dc = {0,1,-1};
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int r = -1;
        int c = 0;
        int num = 1;
        int dir = 0;

        int len = n;

        while (len > 0) {
            for (int i = 0; i < len; i++) {
                r += dr[dir];
                c += dc[dir];
                board[r][c] = num++;
            }
            dir = (dir + 1) % 3;
            len--;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k <= j; k++) {
                list.add(board[j][k]);
            }
        }
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }

        return answer;
    }
}