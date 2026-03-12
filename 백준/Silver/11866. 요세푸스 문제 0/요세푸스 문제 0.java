import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            deque.addLast(i + 1);
        }

        int k = Integer.parseInt(st.nextToken());
        bw.write("<");
        while(!deque.isEmpty()){
            for(int i = 0; i< k - 1; i++){
                deque.addLast(deque.pollFirst());
            }
            if(deque.size() == 1){
                bw.write(deque.pop() + "");
            } else {
                bw.write(deque.pop() + ", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        
    }
}