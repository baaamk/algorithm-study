import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void hanoi(int n, String from, String temp, String to)throws IOException{
        if(n == 1){
            bw.write(from + " " + to);
            bw.newLine();
            return;
        }
        
        hanoi(n-1, from, to, temp);
        bw.write(from + " " + to);
        bw.newLine();
        hanoi(n-1, temp, from, to);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        bw.write((int) Math.pow(2,n) - 1 + "");
        bw.newLine();
        hanoi(n, "1", "2", "3");
        bw.flush();
        bw.close();
    }
}