import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] pos = new int[n];
        int[] neg = new int[n];
        int pIdx = 0;
        int nIdx = 0;
        int one = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > 1){
                pos[pIdx++] = num;
            } else if(num == 1){
                one++;
            } else {
                neg[nIdx++] = num;
            }
        }

        Arrays.sort(pos, 0, pIdx); // 양수
        Arrays.sort(neg, 0, nIdx); // 음수

        int ans = 0;

        // 양수 (큰거부터)
        int i = pIdx - 1;
        while(i > 0){
            ans += pos[i] * pos[i - 1];
            i -= 2;
        }
        if(i == 0) ans += pos[0];

        // 음수 (작은거부터)
        int j = 0;
        while(j < nIdx - 1){
            ans += neg[j] * neg[j + 1];
            j += 2;
        }
        if(j == nIdx - 1) ans += neg[j];

        ans += one;

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}