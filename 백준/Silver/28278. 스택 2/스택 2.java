import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            if(input.equals("2")){
                if(!stack.isEmpty()){
                    bw.write(String.valueOf(stack.pop()));
                    bw.newLine();
                } else {
                    bw.write("-1");
                    bw.newLine();
                }
            } else if(input.equals("3")){
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
            } else if(input.equals("4")){
                if(stack.isEmpty()){
                    bw.write("1");
                    bw.newLine();
                } else{
                    bw.write("0");
                    bw.newLine();
                }
            } else if(input.equals("5")){
                if(!stack.isEmpty()){
                    bw.write(String.valueOf(stack.peek()));
                    bw.newLine();
                } else {
                    bw.write("-1");
                    bw.newLine();
                }
            } else {
                st = new StringTokenizer(input);
                st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                stack.push(b);
            }
        }
        bw.flush();
        bw.close();
    }
}