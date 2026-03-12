import java.util.*;
import java.io.*;

class Main{
    
    static boolean[][] board = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            move(x,y,d,g);
        }
        
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]){
                    count++;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
    
    static void move(int x, int y, int d, int g){
        List<Integer> list = new ArrayList<>();
        list.add(d);
        for(int gen = 0; gen < g; gen++){
            for(int i = list.size() - 1; i >= 0; i--){
                list.add((list.get(i) + 1)%4);
            }
        }
        
        board[y][x] = true;
        for(int dir : list){
            x += dx[dir];
            y += dy[dir];
            board[y][x] = true;
        }

    }
}