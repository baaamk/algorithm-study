import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int min = list[0];
        int max = list[0];
        
        for(Integer a : list){
            if (a <= min){
                min = a;
            }
            if (a >= max){
                max = a;
            }
        }
        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }
}