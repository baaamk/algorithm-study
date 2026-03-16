import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        Arrays.sort(b, (c,d) -> d - c);
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans + a[i] * b[i];
        }
        
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}