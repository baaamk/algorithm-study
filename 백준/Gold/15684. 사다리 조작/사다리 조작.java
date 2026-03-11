import java.util.*;
import java.io.*;

class Main {
    static int n, m, h;
    static boolean[][] board;
    static int answer = 4;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        board = new boolean[h + 1][n + 1];
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            
            board[a][b] = true;
        }
        
        dfs(1, 0);
        if(answer == 4){
            bw.write("-1");
        } else {
            bw.write(answer + "");
        }
        
        bw.flush();
        bw.close();
    }
    
    static void dfs(int startRow, int count){
        if(count >= answer){
            return;
        }
        if(check()){
            answer = count;
            return;
        }
        if(count == 3){
            return;
        }
        
        for(int i = startRow; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(board[i][j]){
                    continue;
                }
                if(j > 1 && board[i][j-1]){
                    continue;
                }
                if(j < n - 1 && board[i][j+1]){
                    continue;
                }
                
                board[i][j] = true;
                dfs(i, count + 1);
                board[i][j] = false;
            }
        }
    }
    
    static boolean check(){
        for(int start = 1; start <= n; start++){
            int cur = start;
            
            for(int row = 1; row <= h; row++){
                if(board[row][cur]){
                    cur++;
                } else if(cur > 1 && board[row][cur - 1]){
                    cur--;
                }
            }
            
            if(cur != start){
                return false;
            }
        }
        
        return true;
    }
}