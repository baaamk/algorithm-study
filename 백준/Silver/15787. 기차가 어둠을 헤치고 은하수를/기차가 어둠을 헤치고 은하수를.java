import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] train = new boolean[n + 1][21];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            
            
            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                train[b][c] = true;
            } else if (a == 2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                train[b][c] = false;
            } else if (a == 3){
                int b = Integer.parseInt(st.nextToken());

                for(int j = 20; j >= 2; j--){
                    train[b][j] = train[b][j-1];
                }
                train[b][1] = false;
            } else {
                int b = Integer.parseInt(st.nextToken());
                for(int j = 1; j <= 19; j++){
                    train[b][j] = train[b][j+1];
                }
                train[b][20] = false;
            }
        }
        
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                if(train[i][j]){
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            set.add(sb.toString());
        }

        bw.write(set.size() + "");
        bw.flush();
        bw.close();
    }
}