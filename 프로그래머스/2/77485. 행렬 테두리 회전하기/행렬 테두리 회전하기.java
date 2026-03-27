class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;

            int prev = board[x1][y1];
            int min = prev;

            for (int j = y1 + 1; j <= y2; j++) {
                int temp = board[x1][j];
                board[x1][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int i = x1 + 1; i <= x2; i++) {
                int temp = board[i][y2];
                board[i][y2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int j = y2 - 1; j >= y1; j--) {
                int temp = board[x2][j];
                board[x2][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int i = x2 - 1; i >= x1; i--) {
                int temp = board[i][y1];
                board[i][y1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            answer[q] = min;
        }

        return answer;
    }
}