import java.util.*;
import java.io.*;

class Main {
    static int k;
    static int[] arr;
    static int[] select;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            }
            st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            select = new int[6];
            visit = new boolean[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            make(0,0);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    static void make(int depth, int start) throws IOException {
        if(depth == 6){
            for(int i = 0; i < 6; i++){
                bw.write(select[i]+" ");
            }
            bw.newLine();
            return;
        }
        
        int prev = -1;
        
        for(int i = start; i < k; i++){
            
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            select[depth] = arr[i];
            prev = arr[i];
            make(depth + 1, i);
            visit[i] = false;
        }
    }
}