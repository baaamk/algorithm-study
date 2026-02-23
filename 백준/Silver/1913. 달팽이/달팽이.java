import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int total = n * n;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int length = 1;
        int dir = 0;
        int r = n /2;
        int c = n /2;
        int row = 0;
        int col = 0;
        arr[r][c] = 1;
        if (m == 1) { row = r; col = c; }
        int num = 2;
        while(num <= total){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < length; j++){
                    r += dr[dir];
                    c += dc[dir];
                    
                    if(r <0 || c <0 || r >=n || c>=n){
                        continue;
                    }
                    
                    arr[r][c] = num;
                    if(arr[r][c] == m){
                        row = r;
                        col = c;
                    }
                    num++;
                }
                dir = (dir + 1) % 4;
            }
            length ++;
        }
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write((row +1) + " " + (col +1));
        bw.flush();
        bw.close();
    }
}