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
        make(0);
        bw.flush();
        bw.close();
    }
    
    static void make(int depth) throws IOException{
        if(depth == m){
            for(int i = 0; i < m; i++){
                bw.write(select[i] + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < n; i++){
            select[depth] = arr[i];
            make(depth + 1);
        }
    }
}