import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2 * n][2];
        StringTokenizer st;
        for(int i = 0 ; i < n; i++){
            st= new StringTokenizer(br.readLine());
            arr[2 * i][0] = Integer.parseInt(st.nextToken());//시작
            arr[2 * i][1] = 1;
            arr[2 * i + 1][0] = Integer.parseInt(st.nextToken());//끝
            arr[2 * i + 1][1] = -1;
        }
        
        
        Arrays.sort(arr, (a,b)-> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int ans = 0;
        int cur = 0;
        
        for(int i = 0; i < 2 * n; i++){
            cur += arr[i][1];
            ans = Math.max(ans, cur);
        }
        
        bw.write(ans+"");
        bw.flush();
        bw.close();
        
    }
}