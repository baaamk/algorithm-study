import java.util.*;
import java.io.*;

class Main{
    static int[][] board;
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = s.charAt(j) -'0';
            }
        }
        
        cal(0,0,n);
        bw.flush();
        bw.close();
    }
    
    static void cal(int r, int c, int size)throws IOException{
        int color = board[r][c];
        
        for(int i = r; i < r + size; i++){
            for(int j = c; j <c + size; j++){
                if(board[i][j] != color){
                    bw.write("(");
                    int half = size/2;
                    cal(r, c, half);
                    cal(r, c + half, half);
                    cal(r + half, c, half);
                    cal(r+half, c+half, half);
                    bw.write(")");
                    return;
                }
            }
        }
        bw.write(String.valueOf(color));
    }
}