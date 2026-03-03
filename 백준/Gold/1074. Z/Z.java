import java.util.*;
import java.io.*;

class Main{
    
    static boolean[][] board;
    static int n, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int result = func(n,r,c);
        
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
    
    static int func(int n, int r, int c){
        if(n == 0){
            return 0;
        }
        int half = 1 << (n - 1);
        int area = half * half;
        
        if(r < half && c < half){
            return func(n - 1, r, c);
        }
        if (r < half && c < half) return func(n - 1, r, c);
        if (r < half && c >= half) return area + func(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * area + func(n - 1, r - half, c);
        return 3 * area + func(n - 1, r - half, c - half);
    }
}