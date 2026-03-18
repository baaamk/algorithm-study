import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int state = 0;
        while(m -- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                state |= (1 << (x - 1));
            } else if(com.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                state &= ~(1<<(x - 1));
            } else if (com.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                bw.write(((state >> (x - 1)) & 1) + "\n");
            } else if (com.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                state ^= (1 << (x - 1));
            } else if (com.equals("all")) {
                state = (1 << 20) - 1;
            } else if (com.equals("empty")) {
                state = 0;
            }
        }
        bw.flush();
        bw.close();
    }
}