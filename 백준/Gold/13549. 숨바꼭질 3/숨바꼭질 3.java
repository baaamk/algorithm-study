import java.util.*;
import java.io.*;

class Main{
    static int n,k;
    static int[] board = new int[100001];
    static int[] dr = {-1, 1, 2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(board, -1);
        dfs(n, k);
        
        bw.write(board[k] + "");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int start, int end){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        board[start] = 0;
        
        while(!deque.isEmpty()){
            int cur = deque.poll();
            if(cur == end){
                return;
            }
            
            for(int i = 0; i < 3; i++){
                if(i == 2){
                    int nr = cur * dr[2];
                    if(nr >= 0 && nr < 100001){
                        if(board[nr] == -1 || board[nr] > board[cur]){
                            board[nr] = board[cur];
                            deque.addFirst(nr);
                        }
                    }
                } else {
                    int nr = cur + dr[i];
                    if(nr >= 0 && nr < 100001){
                        if(board[nr] == -1 || board[nr] > board[cur] + 1){
                            board[nr] = board[cur] + 1;
                            deque.add(nr);
                        }
                    }
                }
                
                
            }
        }
    }
}