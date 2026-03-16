import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            arr[i][0] = Integer.parseInt(st.nextToken()); //시작
            arr[i][1] = Integer.parseInt(st.nextToken()); //끝
        }
        
        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int count = 0;
        int endTime = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i][0] >= endTime){
                count++;
                endTime = arr[i][1];
            }
        }
        
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}