import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] cal = new int[366];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int j = m; j <= k; j++){
                cal[j]++;
            }
        }
        
        //연속
        int len = 0;
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 1; i <= 365; i++){
            if(cal[i] > 0) {
                len++;
                max = Math.max(max, cal[i]);
            } else {
                answer += len*max;
                len = 0;
                max = Integer.MIN_VALUE;
            }
        }
        answer += len * max;
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}