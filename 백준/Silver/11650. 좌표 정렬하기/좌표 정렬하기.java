import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            int cmp = Integer.compare(o1[0], o2[0]);
            if(cmp != 0){
                return cmp;
            }
            return Integer.compare(o1[1], o2[1]);
        });
        
        for(int i = 0; i < n; i++){
            bw.write(arr[i][0] + " " + arr[i][1]);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}