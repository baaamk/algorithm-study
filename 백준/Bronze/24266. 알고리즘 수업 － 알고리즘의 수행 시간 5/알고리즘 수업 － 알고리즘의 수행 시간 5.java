import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        bw.write(String.valueOf(n * n * n));
        bw.newLine();
        bw.write("3");
        bw.flush();
        bw.close();
    }
}