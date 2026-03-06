import java.util.*;
import java.io.*;

class Main{
    static char[][] tree;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        
        tree = new char[n][2 * n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                tree[i][j] = ' ';
            }
        }
        make(0,n-1,n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n * 2; j++){
                bw.write(tree[i][j] + "");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    static void make(int r, int c, int size){
        if (size == 3) {
            tree[r][c] = '*';
            tree[r + 1][c - 1] = '*';
            tree[r + 1][c + 1] = '*';
            tree[r + 2][c - 2] = '*';
            tree[r + 2][c - 1] = '*';
            tree[r + 2][c] = '*';
            tree[r + 2][c + 1] = '*';
            tree[r + 2][c + 2] = '*';
            return;
        }
        int half = size / 2;
        
        make(r, c, half);
        make(r+half, c-half, half);
        make(r+half, c+half, half);
        
        
    }
}