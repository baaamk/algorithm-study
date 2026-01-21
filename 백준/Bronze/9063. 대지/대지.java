import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if(n < 1){
            bw.write("0");
        } else {
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                if(x <= minX){
                    minX = x;
                }
                if(x >= maxX){
                    maxX = x;
                }
                int y = Integer.parseInt(st.nextToken());
                if(y <= minY){
                    minY = y;
                }
                if(y >= maxY){
                    maxY = y;
                }
            }
            int w = maxX - minX;
            int h = maxY - minY;
            
            bw.write(String.valueOf(w * h));
        }
        bw.flush();
        bw.close();
    }
}