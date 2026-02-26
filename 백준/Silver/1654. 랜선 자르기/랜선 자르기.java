import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] >= max){
                max = arr[i];
            }
        }
        
        long left = 1;
        long right = max;
        long answer = 0;
        
        while(right >= left){
            long mid = (left + right) / 2;
            
            long count = 0;
            for(int i = 0; i < k; i++){
                count += arr[i] / mid;
            }
            if (count >= n){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
        
        
    }
}