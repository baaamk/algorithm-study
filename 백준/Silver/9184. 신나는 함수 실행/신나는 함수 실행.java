import java.util.*;
import java.io.*;

class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int k;
    static long[][][] arr = new long[21][21][21];
    
    static long w(int n, int m, int k){
        if(n <= 0 || m <= 0 || k <= 0){
            return 1;
        } else if(n > 20 || m > 20 || k > 20){
            return arr[20][20][20] = w(20, 20, 20);
        } else if(arr[n][m][k] != 0){
            return arr[n][m][k];
        }  else if(n < m && m < k) {
            return arr[n][m][k] = w(n, m, k - 1) + w(n, m - 1, k - 1) - w(n, m - 1, k);
        } else {
            return arr[n][m][k] = w(n - 1, m, k) + w(n - 1, m - 1, k) + w(n - 1, m, k - 1) - w(n - 1, m - 1, k -1);
        }

    }
    
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n == -1 && m == -1 && k == -1){
                break;
            }
            bw.write("w(" + n + ", " + m + ", " + k + ") = " + w(n, m, k));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}