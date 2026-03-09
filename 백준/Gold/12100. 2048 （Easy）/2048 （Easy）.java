import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] board;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, board);
        bw.write(max +"");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int depth, int[][] board){
        if(depth == 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                   max = Math.max(max, board[i][j]); 
                }
            }
            return;
        }
        for(int dir = 0; dir < 4; dir++){
            int[][] newBoard = copy(board);
            move(newBoard, dir);
            dfs(depth + 1, newBoard);
        }
    }
    
    static void move(int[][] board, int dir) {

        if (dir == 0) { // 위
            for (int col = 0; col < n; col++) {

                int[] temp = new int[n];
                int idx = 0;

                for (int row = 0; row < n; row++) {
                    if (board[row][col] == 0) continue;

                    if (temp[idx] == 0) {
                        temp[idx] = board[row][col];
                    } 
                    else if (temp[idx] == board[row][col]) {
                        temp[idx++] *= 2;
                    } 
                    else {
                        temp[++idx] = board[row][col];
                    }
                }

                for (int row = 0; row < n; row++) {
                    board[row][col] = temp[row];
                }
            }
        }

        else if (dir == 1) { // 오른쪽
            for (int row = 0; row < n; row++) {

                int[] temp = new int[n];
                int idx = n - 1;

                for (int col = n - 1; col >= 0; col--) {
                    if (board[row][col] == 0) continue;

                    if (temp[idx] == 0) {
                        temp[idx] = board[row][col];
                    } 
                    else if (temp[idx] == board[row][col]) {
                        temp[idx--] *= 2;
                    } 
                    else {
                        temp[--idx] = board[row][col];
                    }
                }

                board[row] = temp;
            }
        }

        else if (dir == 2) { // 아래
            for (int col = 0; col < n; col++) {

                int[] temp = new int[n];
                int idx = n - 1;

                for (int row = n - 1; row >= 0; row--) {
                    if (board[row][col] == 0) continue;

                    if (temp[idx] == 0) {
                        temp[idx] = board[row][col];
                    } 
                    else if (temp[idx] == board[row][col]) {
                        temp[idx--] *= 2;
                    } 
                    else {
                        temp[--idx] = board[row][col];
                    }
                }

                for (int row = 0; row < n; row++) {
                    board[row][col] = temp[row];
                }
            }
        }

        else { // 왼쪽
            for (int row = 0; row < n; row++) {

                int[] temp = new int[n];
                int idx = 0;

                for (int col = 0; col < n; col++) {
                    if (board[row][col] == 0) continue;

                    if (temp[idx] == 0) {
                        temp[idx] = board[row][col];
                    } 
                    else if (temp[idx] == board[row][col]) {
                        temp[idx++] *= 2;
                    } 
                    else {
                    temp[++idx] = board[row][col];
                    }
                }

            board[row] = temp;
            }
        }
    }
    
    static int[][] copy(int[][] board){
        int r = board.length;
        int c = board[0].length;
        int[][] newBoard = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
}