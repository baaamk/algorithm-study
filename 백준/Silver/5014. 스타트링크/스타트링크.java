import java.util.*;
import java.io.*;

class Main{
    static int f, g, s, u, d;
    static int[] floor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;
        g = Integer.parseInt(st.nextToken()) - 1;
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int[] df = {u, -d};
        floor = new int[f];
        Arrays.fill(floor, -1);        
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.add(s);
        floor[s] = 0;
        
        while(!deque.isEmpty()){
            int cf = deque.poll();
            if(cf == g){
                bw.write(floor[cf] + "");
                bw.flush();
                bw.close();
                return;
            }
            for(int i = 0; i < 2; i++){
                int nf = cf + df[i];
                
                if(nf < f && nf >=0 && floor[nf] == -1){
                    
                    if(floor[nf] == -1){
                        floor[nf] = floor[cf] + 1;
                        deque.add(nf);
                    }
                }
            }
            
        }
        bw.write("use the stairs");
        bw.flush();
        bw.close();
        
        
    }
}