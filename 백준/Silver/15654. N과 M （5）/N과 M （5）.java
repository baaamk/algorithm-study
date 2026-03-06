import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[] arr;
    static int[] selected;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        selected = new int[m];
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
                bw.write(selected[i] + " ");
            }
            bw.newLine();
            return;
        }
        
        for(int i = 0 ; i < n; i++){
            if(visit[i]){
                continue;
            }
            
            visit[i] = true;
            selected[depth] = arr[i];
            make(depth + 1);
            visit[i] = false;
            
        }
    }
}