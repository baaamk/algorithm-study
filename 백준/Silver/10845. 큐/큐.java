import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                deque.add(Integer.parseInt(st.nextToken()));
            } else if(str.equals("pop")){
                if(deque.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(deque.poll()));
                    bw.newLine();
                }
            } else if(str.equals("size")){
                bw.write(String.valueOf(deque.size()));
                bw.newLine();
            } else if(str.equals("empty")){
                if(deque.isEmpty()){
                    bw.write("1");
                    bw.newLine();
                } else {
                    bw.write("0");
                    bw.newLine();
                }
            } else if(str.equals("front")){
                if(deque.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(deque.getFirst()));
                    bw.newLine();
                }
            } else {
                if(deque.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(deque.getLast()));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
    }
}