import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int total = 1;
        for(int i = 1; i <= n; i++){
            total *= i;
        }
        bw.write(total + "");
        bw.flush();
        bw.close();
    }
}