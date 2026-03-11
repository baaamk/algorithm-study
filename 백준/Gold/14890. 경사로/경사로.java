import java.util.*;
import java.io.*;

class Main{
    static int n,l;
    static int[][] board;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        board = new int[n][n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            int[] row = new int[n];
            int[] col = new int[n];
            
            for(int j = 0; j < n; j++){
                row[j] = board[i][j];
                col[j] = board[j][i];
            }
            
            if(check(row)){
                count++;
            }
            if(check(col)){
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
    
    static boolean check(int[] arr){
        boolean[] used = new boolean[n];
        
        for(int i = 0; i < n - 1; i++){
            if(arr[i] == arr[i + 1]){
                continue;
            }
            
            if(Math.abs(arr[i] - arr[i+1]) > 1){
                return false;
            }
            
            if(arr[i] + 1 == arr[i+1]){
                for(int j = 0; j < l; j++){
                    int idx = i - j;
                    if(idx < 0){
                        return false;
                    } 
                    if(arr[idx] != arr[i]){
                        return false;
                    }
                    if (used[idx]) {
                        return false;
                    }
                    used[idx] = true;
                }
            } else if(arr[i] - 1 == arr[i+1]){
                for(int j = 1; j <= l; j++){
                    int idx = i + j;
                    if(idx >= n){
                        return false;
                    } 
                    if(arr[idx] != arr[i + 1]){
                        return false;
                    }
                    if (used[idx]) {
                        return false;
                    }
                    used[idx] = true;
                }
            }
        }
        return true;
    }
    
}