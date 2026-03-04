import java.util.*;
import java.io.*;

class Main{
    static int n, k;
    static int[] board;
    static boolean[] visit;
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //수빈
        k = Integer.parseInt(st.nextToken()); //동생
        //수빈이 동생 찾는 빠른 시간.
        
        Deque<Integer> deque = new ArrayDeque<>();
        

        board = new int[100001];
        visit = new boolean[board.length];
        
        deque.add(n);
        visit[n] = true;
        
        
        while(!deque.isEmpty()){
            int current = deque.poll();
            visit[current] = true;
            
            for(int i = 0; i < 3; i++){
                
                
                if(current == k){
                    bw.write(board[current] + "");
                    bw.flush();
                    bw.close();
                    return;
                }
                
                int nx = 0;
                if(i == 2){
                    nx = current * dx[2];
                } else{
                    nx = current + dx[i];
                }

                if(nx < board.length && nx >= 0 && !visit[nx]){
                    if(!visit[nx]){
                        visit[nx] = true;
                        board[nx] = board[current] + 1;
                        deque.add(nx);
                    }
                    
                }
            }
        }
        
        
    }
}