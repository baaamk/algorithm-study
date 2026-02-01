import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st2.nextToken());
            if(st1.nextToken().equals("0")){
                dq.addLast(a);
            }
        }
        for(int i = 0; i < m; i++){
            dq.addFirst(Integer.parseInt(st3.nextToken()));
            bw.write(dq.pollLast() + " ");

        }

        bw.flush();
        bw.close();
    }
}