import java.util.*;
import java.io.*;

class Main{
    static int n,w,l;
    static int weight;
    static Deque<Integer> bridge = new ArrayDeque<>();
    static Deque<Integer> truck = new ArrayDeque<>(); 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
                      
        int time = 0;
        int weightSum = 0;
                      
        while(!truck.isEmpty() || weightSum > 0){
            time++;
            weightSum -= bridge.poll();
            if (!truck.isEmpty() && weightSum + truck.peek() <= l) {
                int newTruck = truck.poll();
                bridge.add(newTruck);
                weightSum += newTruck;
            } else {
                bridge.add(0);
            }
        }
        

        bw.write(time+"");
        bw.flush();
        bw.close();
                      
    }
}
                      