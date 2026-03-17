import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = n - 1; i > 0; i--){
            int now = arr[i];
            if(now <= arr[i - 1]){
                while(true){
                    if(arr[i-1] < now){
                        break;
                    }
                    arr[i-1]--;
                    count++;
                }
            }
        }
        
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}