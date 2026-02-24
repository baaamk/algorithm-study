import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] s = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            if(g == 1){
                int p = Integer.parseInt(st.nextToken());
                int x = 1;
                while(p * x <= n){
                    if(s[p * x] == 0) {
                        s[p * x] = 1;
                    } else {
                        s[p * x] = 0;
                    }
                    x++;
                }
                
            } else {
                int p = Integer.parseInt(st.nextToken());
               
                int left = p;
                int right = p;
                while(true){
                    if(left < 1 || right > n){
                        break;
                    }
                    if(s[left] == s[right]){
                        if(s[left] == 0) {
                            s[left] = 1;
                            s[right] = 1;
                        } else {
                            s[left] = 0;
                            s[right] = 0;
                        }
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
            
            
        }
        for(int i = 1; i <= n; i++){
                bw.write(s[i] + " ");
                if(i % 20 == 0){
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
    }
}