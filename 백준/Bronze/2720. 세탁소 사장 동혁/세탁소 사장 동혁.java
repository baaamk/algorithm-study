import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //쿼터(Quarter, $0.25)
        //다임(Dime, $0.10)
        //니켈(Nickel, $0.05)
        //페니(Penny, $0.01)
        //손님 돈 동전 개수 최소.
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            int quarter = a / 25;
            int dime =a % 25 / 10;
            int nickel =a % 25 % 10 / 5;
            int qenny =a % 25 % 10 % 5 / 1;
            bw.write(quarter + " " + dime + " " + nickel + " " + qenny + " ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}