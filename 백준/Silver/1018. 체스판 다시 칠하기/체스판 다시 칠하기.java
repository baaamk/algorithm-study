import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] board = new String[n];
        String[] white = {"WBWBWBWB", "BWBWBWBW"};
        String[] black = {"BWBWBWBW", "WBWBWBWB"};
        for(int i = 0; i < n; i++){
            board[i] = br.readLine();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 7; i++){
            for(int j = 0; j < m - 7; j++){
                int w = getCount(board, i, j, white);
                int b = getCount(board, i, j, black);
                min = Math.min(min,Math.min(w,b));
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
    
    static int getCount(String[] board, int startRow, int startCol, String[] pattern){
        int count = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[startRow + i].charAt(startCol + j) != pattern[i % 2].charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}