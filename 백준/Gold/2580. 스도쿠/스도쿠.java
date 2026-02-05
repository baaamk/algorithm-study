import java.util.*;
import java.io.*;

class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] sdocu = new int[9][9];
    static boolean solved;

    static void backTrack(int row, int col) throws IOException{
        if(row == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    bw.write(sdocu[i][j] + " ");
                }
                bw.newLine();
            }
            solved = true;
            return;
        }
        
        if(col == 9){
            backTrack(row + 1, 0);
            return;
        }
        
        if(sdocu[row][col] != 0){
            backTrack(row, col + 1);
            return;
        }
        
        for(int i = 1; i <= 9; i++){
            if(isValid(row,col,i)){
                sdocu[row][col] = i;
                backTrack(row, col + 1);
                if(solved){
                    return;
                }
                sdocu[row][col] = 0;
            }
        }
    }
    
    static boolean isValid(int row, int col, int num){
        for(int i = 0; i < 9; i++){
            if(sdocu[i][col] == num || sdocu[row][i] == num){
                return false;
            }
        }
        
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        
        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(sdocu[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                sdocu[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTrack(0,0);
        bw.flush();
        bw.close();
    }
}