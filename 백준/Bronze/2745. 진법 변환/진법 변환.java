import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        long result = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int value;

            if ('0' <= c && c <= '9') {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }

            result = result * b + value;
        }

        System.out.println(result);
        
    }
}