import java.util.*;
import java.io.*;

class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] board;
    static int count;
    static int n;
    static void backTrack(int row) throws IOException{
        if (row == n){
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            board[row] = i;
            if(isSafe(row)){
                backTrack(row + 1);
            }
        }
    }
    
    static boolean isSafe(int row){
        for(int i = 0; i < row; i++){
            if(board[row] == board[i] || Math.abs(row - i) == Math.abs(board[row] - board[i])){
            return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        backTrack(0);
        bw.write(count +"");
        bw.flush();
        bw.close();
    }
}