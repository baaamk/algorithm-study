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
                buckets[i] = 0;
            }
        //m개의 줄 입력받음
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //a~b의 바구니에는 c공으로 교체;
            for(int j = a - 1; j < b; j++){
                buckets[j] = c;
            }
            
        }
        
        for(int i = 0; i < buckets.length; i++){
            bw.write(buckets[i] + " ");
        }
        bw.flush();
        bw.close();
        
        
    }
}