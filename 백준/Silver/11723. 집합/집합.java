import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            if (com.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = true;
            } 
            else if (com.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = false;
            } 
            else if (com.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                bw.write((arr[x] ? 1 : 0) + "\n");
            } 
            else if (com.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = !arr[x];
            } 
            else if (com.equals("all")) {
                Arrays.fill(arr, true);
            } 
            else if (com.equals("empty")) {
                Arrays.fill(arr, false);
            }
        }

        bw.flush();
        bw.close();
    }
}