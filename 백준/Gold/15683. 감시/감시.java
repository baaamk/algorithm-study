import java.util.*;
import java.io.*;

class Main {
    static int n,m;
    static int[][] board;
    static boolean[][] visit;
    static boolean[][] temp;
    
    static int min = Integer.MAX_VALUE;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0 && board[i][j] != 6){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        backTrack(0);
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
    
    static void backTrack(int depth){
        if(depth == list.size()){
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 0 && !visit[i][j]){
                        count++;
                    }
                }
            }
            min = Math.min(min, count);
            return;
        }
        
        
            int[] cur = list.get(depth);
            int cr = cur[0];
            int cc = cur[1];
            
            if(board[cr][cc] == 5){
                boolean[][] temp = copyArray(visit);
                moveRight(cr,cc);
                moveLeft(cr,cc);
                moveUp(cr,cc);
                moveDown(cr,cc);
                backTrack(depth + 1);
                visit = temp;
            } else if(board[cr][cc] == 2){
                boolean[][] temp = copyArray(visit);
                moveUp(cr,cc);
                moveDown(cr,cc);
                backTrack(depth + 1);
                visit = temp;
                
                temp = copyArray(visit);
                moveLeft(cr,cc);
                moveRight(cr,cc);
                backTrack(depth + 1);
                visit = temp;
            } else if(board[cr][cc] == 3){
                for(int j = 0; j < 4; j++){
                    boolean[][] temp = copyArray(visit);
                    if(j == 0){
                        moveUp(cr,cc);
                        moveRight(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 1){
                        moveRight(cr,cc);
                        moveDown(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 2){
                        moveDown(cr,cc);
                        moveLeft(cr,cc);
                        backTrack(depth + 1); 
                    } else {
                        moveLeft(cr,cc);
                        moveUp(cr,cc);
                        backTrack(depth + 1); 
                    }
                    visit = temp;
                }
            } else if(board[cr][cc] == 4){
                for(int j = 0; j < 4; j++){
                    boolean[][] temp = copyArray(visit);
                    if(j == 0){
                        moveUp(cr,cc);
                        moveRight(cr,cc);
                        moveLeft(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 1){
                        moveUp(cr,cc);
                        moveRight(cr,cc);
                        moveDown(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 2){
                        moveDown(cr,cc);
                        moveRight(cr,cc);
                        moveLeft(cr,cc);
                        backTrack(depth + 1); 
                    } else {
                        moveLeft(cr,cc);
                        moveUp(cr,cc);
                        moveDown(cr,cc);
                        backTrack(depth + 1); 
                    }
                    visit = temp;
                }
            } else if(board[cr][cc] == 1){
                for(int j = 0; j < 4; j++){
                    boolean[][] temp = copyArray(visit);
                    if(j == 0){
                        moveUp(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 1){
                        moveRight(cr,cc);
                        backTrack(depth + 1); 
                    } else if (j == 2){
                        moveDown(cr,cc);
                        backTrack(depth + 1); 
                    } else {
                        moveLeft(cr,cc);
                        backTrack(depth + 1); 
                    }
                    visit = temp;
                }
            }
        
    }
    
    
    
    static void moveRight(int r, int c){
        if(c >= m){
            return;
        } else if (board[r][c] == 6){
            return;
        }
        visit[r][c] = true;
        moveRight(r, c + 1);
    }
    static void moveLeft(int r, int c){
        if(c < 0){
            return;
        } else if (board[r][c] == 6){

            return;
        }
        visit[r][c] = true;
        moveLeft(r, c - 1);
    }
    static void moveUp(int r, int c){
        if(r < 0){
            return;
        } else if (board[r][c] == 6){

            return;
        }
        visit[r][c] = true;
        moveUp(r - 1, c);
    }
    static void moveDown(int r, int c){
        if(r >= n){
            return;
        } else if (board[r][c] == 6){

            return;
        }
        visit[r][c] = true;
        moveDown(r + 1, c);
    }
    static boolean[][] copyArray(boolean[][] arr){
        boolean[][] copy = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }
}