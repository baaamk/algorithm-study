import java.util.*;
import java.io.*;

class Main{
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;
    static int a; // -1
    static int b; // 0
    static int c; // 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        func(0, 0, n);
        
        bw.write(a +"");
        bw.newLine();
        bw.write(b +"");
        bw.newLine();
        bw.write(c +"");
        bw.newLine();
        
        bw.flush();
        bw.close();
    }
    
    static void func(int x, int y, int size) {
        //한 면이 다 같은 숫자일 때 종료
        // 다를 때 len/3 => 한 면의 길이.
        // 첫꺼 len 두번째 2*len 세번째 3 * len 
        if(isSame(x, y, size)){
            int m = board[x][y];
            if(m == -1){
                a++;
            } else if(m == 0){
                b++;
            } else {
                c++;
            }
            return;
        }
        int newSize = size/3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                func(x + newSize * i, y + newSize * j, newSize);
            }
        }
    }
    
    static boolean isSame(int x, int y, int size){
        int value = board[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(board[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }
}