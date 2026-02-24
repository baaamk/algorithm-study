import java.util.*;
import java.io.*;

class Main{
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};
    
    static boolean inRange(int r, int c){
        return r >= 0 && c >= 0 && c < 19 && r < 19;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] board = new int[19][19];
        for(int i = 0; i < 19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int r = 0; r < 19; r++){
            for(int c = 0; c < 19; c++){
                if(board[r][c] == 0){
                    continue;
                }
                int color = board[r][c];
                for(int k = 0; k < 4; k++){
                    int pr = r - dr[k];
                    int pc = c - dc[k];
                    if(inRange(pr, pc) && board[pr][pc] == color){
                        continue;
                    }
                    
                    int cnt = 1;
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    while(inRange(nr, nc) && board[nr][nc] == color){
                        cnt++;
                        nr += dr[k];
                        nc += dc[k];
                    }
                    
                    if(cnt == 5){
                        if (inRange(nr, nc) && board[nr][nc] == color){
                            continue;
                        }
                        bw.write(color +"");
                        bw.newLine();
                        bw.write((r+1) + " " + (c+1));
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
    }
}