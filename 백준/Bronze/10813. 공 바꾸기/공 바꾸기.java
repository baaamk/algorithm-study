import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] buckets = new int[n];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = i + 1;
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = buckets[a - 1];
            int temp2 = buckets[b - 1];
            buckets[b - 1] = temp;
            buckets[a - 1] = temp2;
        }
        for(int bucket : buckets){
            bw.write(bucket + " ");
        }
        bw.flush();
        bw.close();
    }
}