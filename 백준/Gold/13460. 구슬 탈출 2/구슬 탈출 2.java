import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static char[][] board;
    static boolean[][][][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class Node {
        int rr;
        int rc;
        int br;
        int bc;
        int depth;
        
        Node (int rr, int rc, int br, int bc, int depth){
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.depth = depth;
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        visit = new boolean[n][m][n][m];
        int[] red = new int[2];
        int[] blue = new int[2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                } else if(board[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }
       
        
        bw.write(move(red,blue)+"");
        bw.flush();
        bw.close();
    }
    
    static int move(int[] red, int[] blue){
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(red[0], red[1], blue[0], blue[1], 0));
        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.depth >= 10){
                return -1;
            }
            
            for(int d = 0; d < 4; d++){
                int nrr = cur.rr;
                int nrc = cur.rc;
                int nbr = cur.br;
                int nbc = cur.bc;
                
                boolean redHole = false;
                boolean blueHole = false;
                
                int rMove = 0;
                int bMove = 0;
                
                while(board[nrr + dr[d]][nrc + dc[d]] != '#'){
                    nrr += dr[d];
                    nrc += dc[d];
                    rMove++;
                    if(board[nrr][nrc] == 'O'){
                        redHole = true;
                        break;
                    }
                }
                while(board[nbr + dr[d]][nbc + dc[d]] != '#'){
                    nbr += dr[d];
                    nbc += dc[d];
                    bMove++;
                    if(board[nbr][nbc] == 'O'){
                        blueHole = true;
                        break;
                    }
                }
                
                if(blueHole){
                    continue;
                }
                if(redHole){
                    return cur.depth + 1;
                }
                
                if(nrr == nbr && nrc == nbc){
                    if(rMove > bMove){
                        nrr -= dr[d]; 
                        nrc -= dc[d]; 
                    } else {
                        nbr -= dr[d];
                        nbc -= dc[d];
                    }
                }
                if (!visit[nrr][nrc][nbr][nbc]) {
                    visit[nrr][nrc][nbr][nbc] = true;
                    queue.add(new Node(nrr, nrc, nbr, nbc, cur.depth + 1));
                }
            }
            
        }
        
        
        return -1;
    }
}