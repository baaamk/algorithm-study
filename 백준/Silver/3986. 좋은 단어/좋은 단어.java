import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            Deque<Character> deque = new ArrayDeque<>();
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                if(!deque.isEmpty()){
                    if(deque.peek() == str.charAt(j)){
                        deque.pop();
                    } else {
                        deque.push(str.charAt(j));
                    }
                } else {
                    deque.push(str.charAt(j));
                }
            }
            if(deque.isEmpty()){
                count++;
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}