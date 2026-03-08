import java.io.*;
import java.util.*;

class Main{
    static char[][] arr;
    static void star(int x, int y, int n){
        if(n == 1){
            arr[x][y] = '*';
            return;
        }
        
        int size = n / 3;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(j == 1 && i == 1){
                    continue;
                }
                star(x + i * size, y + j * size, size);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = ' ';
            }
        }
        
        star(0,0,n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bw.write(String.valueOf(arr[i][j]));      
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}