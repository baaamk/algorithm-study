import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //겹치는 부분 한 번 빼기. 겹치는걸 어떻게 판단?
        //1이면 1개, 2면 2개 -> 1개 빼기, 3이면 3개 -> 2개 빼기
        boolean[][] a = new boolean[100][100];
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //x 시작점
            int y = Integer.parseInt(st.nextToken()); //y 시작점
            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    a[j][k]=true;
                }
                    
            }
        }
        int result = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(a[i][j]){
                    result ++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}