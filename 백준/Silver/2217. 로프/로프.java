import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (a,b) -> b - a);
        
        
        int max = arr[0];
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, arr[i] * (i + 1));
        }
        
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}