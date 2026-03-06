import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[] arr;
    static int[] select;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        select = new int[m];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        make(0, 0);
        bw.flush();
        bw.close();
        
        

    }
    
    static void make(int depth, int start) throws IOException {
        if(depth == m){
            for(int i = 0; i < m; i++){
                bw.write(select[i] + " ");
            }
            bw.newLine();
            return;
        }
        int prev = -1;
        for(int i = start; i < n; i++){
            if(prev == arr[i]){
                continue;
            }
            select[depth] = arr[i];
            prev = arr[i];

            make(depth+1, i + 1);

        }
    }
  
}