import java.util.*;
import java.io.*;

class Main{
    static int n,m,x,y,k;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dice = new int[6];
    static int[] loc;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int dir = Integer.parseInt(st.nextToken());
            if(dir == 1){
                if(y + 1 < m){
                    y++;
                    move(x,y,dir);
                }
            } else if(dir == 2){
                if(y - 1 >= 0){
                    y--;
                    move(x,y,dir);
                   
                }
            } else if(dir == 3){
                if(x - 1 >= 0){
                    x--;
                    move(x,y,dir);
                }
            } else if(dir == 4){
                if(x + 1 < n){
                    x++;
                    move(x,y,dir);
                }
            }
        }
        
        bw.flush();
        bw.close();
        
        
        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    }
    
    static void move(int r, int c, int dir) throws IOException {
        //돌리고 복사하기
        if(dir == 1){
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;
        } else if(dir == 2){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else if(dir == 3){
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        } else {
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        }
        
        if(board[r][c] == 0){
            board[r][c] = dice[5];
        } else {
            dice[5] = board[r][c];
            board[r][c] = 0;
        }
        
        bw.write(dice[0] + "");
        bw.newLine();

    }
}
