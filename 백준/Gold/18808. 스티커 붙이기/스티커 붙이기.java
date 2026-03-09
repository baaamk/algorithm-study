import java.util.*;
import java.io.*;

class Main{
    static int n,m,k;
    static int[][] board;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        
        
        while(k-- >0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] paper = new int[r][c];
            
            for(int j = 0; j < r; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < c; k++){
                    paper[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int rot = 0; rot < 4; rot++){
                boolean pasted = false;
                
                int pr = paper.length;
                int pc = paper[0].length;
                
                for(int x = 0; x <= n - pr; x++){
                    if(pasted){
                        break;
                    }
                    for(int y = 0; y <= m - pc; y++){
                        if(pastable(x, y, paper)){
                            pasted = true;
                            break;
                        }
                    }
                }
                if(pasted){
                    break;
                }
                paper = rotate(paper);
            }
            
                
            
        }
        int ans = 0; 
            
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans += board[i][j];
            }
        }
            
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    
    static int[][] rotate(int[][] paper){
        int r = paper.length;
        int c = paper[0].length;
        
        int[][] rotated = new int[c][r];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                rotated[j][r - 1 - i] = paper[i][j];
            }
        }
        return rotated;
    }
    
    static boolean pastable(int x, int y, int[][] paper){
        int r = paper.length;
        int c = paper[0].length;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(paper[i][j] == 1 && board[x + i][y + j] == 1){
                    return false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }

        return true;
    }
}