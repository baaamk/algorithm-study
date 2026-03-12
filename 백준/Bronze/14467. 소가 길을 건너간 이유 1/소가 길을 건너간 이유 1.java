import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        Arrays.fill(arr, -1);
        int count = 0;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            if(arr[cow] == -1){
                arr[cow] = position;
            } else if(arr[cow] == position){
                continue;
            } else {
                arr[cow] = position;
                count++;
            }

        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}