import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int zero;
    static int one;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cal(0,0,n);
        
        bw.write(zero +"");
        bw.newLine();
        bw.write(one +"");
        bw.flush();
        bw.close();
    }
    
    static void cal(int r, int c, int size){
        int color = board[r][c];
        
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(board[i][j] != color){
                    int half = size / 2;
                    cal(r, c, half);
                    cal(r, c + half, half);
                    cal(r + half, c, half);
                    cal(r + half, c + half, half);
                    return;
                }
            }
        }
        if(color == 0){
            zero++;
        } else {
            one++;
        }
    }
}