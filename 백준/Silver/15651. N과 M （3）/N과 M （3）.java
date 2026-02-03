import java.io.*;
import java.util.*;

class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    static int m;
    
    static void create(int length) throws IOException{
        if(length == m){
            for(int i = 0; i < m; i++){
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }
        
        for(int i = 0; i < n; i++){
            arr[length] = i + 1;
            create(length + 1);
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        create(0);
        bw.flush();
        bw.close();
        
    }
}