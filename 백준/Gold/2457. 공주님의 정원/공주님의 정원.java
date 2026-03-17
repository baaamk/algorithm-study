import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());// 시작 월
            int sd = Integer.parseInt(st.nextToken());// 시작 일
            int em = Integer.parseInt(st.nextToken());// 종료 월
            int ed = Integer.parseInt(st.nextToken()); // 종료 일
            
            arr[i][0] = sm * 100 + sd;
            arr[i][1] = em * 100 + ed;
        }
        
        int t = 301;
        int ans = 0;
        
        while(t < 1201){
            int next = t;
            for(int i = 0; i < n; i++){
                if(arr[i][0] <= t && arr[i][1] > next) {
                    next = arr[i][1];
                }
            }
            if(next == t){
                bw.write("0");
                bw.flush();
                bw.close();
                return;
            }
            
            ans++;
            t = next;
        }
            
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}