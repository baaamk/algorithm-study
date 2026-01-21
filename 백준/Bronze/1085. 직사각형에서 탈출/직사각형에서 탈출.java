import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int a = x;
        int b = w - x;
        int c = y;
        int d = h - y;
        
        int min = a;
        int[] arr = {a, b, c, d};
        
        for(int i : arr){
            if(i <= min){
                min = i;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}