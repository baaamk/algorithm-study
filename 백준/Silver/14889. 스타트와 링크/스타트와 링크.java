import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] board;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0);
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int index, int count){
        if(count == n / 2){
            calc();
            return;
        }
        
        for(int i = index; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
    
    static void calc(){
        int start = 0;
        int link = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(visit[i] && visit[j]){
                    start = start + board[i][j] + board[j][i];
                } else if (!visit[i] && !visit[j]){
                    link = link + board[i][j] + board[j][i];
                }
            }
        }
        
        int result = Math.abs(start - link);
        if(result < min){
            min = result;
        }
    }
    
}