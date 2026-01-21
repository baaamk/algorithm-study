import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //소인수 분해 결과 한줄마다 출력
        
        while(true){
            if(n == 1){
                break;
            }
            int i = 2;
            while(true){
                if(n % i == 0){
                    bw.write(String.valueOf(i));
                    bw.newLine();
                    n = n / i;
                    break;
                } else {
                    i++;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}