import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        //음수면 큰거 넣기. 아니면 더하기.
        
        int[] a = new int[100001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a[1] = Integer.parseInt(st.nextToken());
        int max = a[1];
        for(int i = 2; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            a[i] = Math.max(num, a[i - 1] + num);
            max = Math.max(a[i], max);
        }
        
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}