import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] a = new int[9][9];
        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] >= max){
                    max = a[i][j];
                    maxi = i + 1;
                    maxj = j + 1;
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(maxi + " " + maxj);
        bw.flush();
        bw.close();
    }
}