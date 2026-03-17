import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        long start = arr[0][0];
        long end = arr[0][1];
        long ans = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i][0] <= end){
                end = Math.max(end, arr[i][1]);
            } else {
                ans += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        ans += end - start;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}