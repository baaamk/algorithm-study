import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //숫자보이도록
        int m = Integer.parseInt(st.nextToken()); //을 크게 외친다
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n - 2; i++){
            for(int j = 1 + i; j < n - 1; j++){
                for(int k = 1 + j; k < n; k++){
                    if(arr[i] + arr[j] + arr[k] >= max && arr[i] + arr[j] + arr[k] <= m){
                        max = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}