import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //다음행 중 본인열 과 다음 열.
        int[][] t = new int[501][501];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] r = new int[501][501];

        
        r[0][0] = t[0][0];

        
        for(int i = 1; i < n; i++){
            for (int j = 0; j <= i; j++){
                if(j == 0){
                    r[i][j] = r[i - 1][j] + t[i][j];
                } else if(j == i){
                    r[i][j] = r[i - 1][j - 1] + t[i][j];
                } else {
                    r[i][j] = Math.max(r[i - 1][j], r[i - 1][j - 1]) + t[i][j];
                }
            }
            
        }
        int ans = 0;
        for(int i = 0 ; i < n; i++){
            ans = Math.max(r[n-1][i], ans);
        }

        
        bw.write(ans + "");
        bw.flush();
        bw.close();
        
        
        
    }
}