import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        for(int i = 0; i < n; i++){
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }

            String num = st.nextToken();
            

            String newA = new StringBuilder(num).reverse().toString();

            arr[i] = Long.parseLong(newA);
        }

        Arrays.sort(arr);

        for(long a : arr){
            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
    }
}