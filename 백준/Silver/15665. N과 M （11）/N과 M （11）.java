import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[] select;
    static int[] number;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        number = new int[n];
        select = new int[m];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
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
        
        int prev = -1;
        
        for(int i = 0; i < n; i++){
            if(prev == number[i]){
                continue;
            }
            select[depth] = number[i];
            prev = number[i];
            make(depth + 1);
        }
    }
}