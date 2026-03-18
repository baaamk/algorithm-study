import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int n = str.length();
        int r = 0;
        int c = 0;
        int max = 0;
        for(int i = 1; i <= n; i++){
            r = i;
            if(n % r != 0){
                continue;
            }
            c = n /r;
            if(r > c) {
                break;
            }
            max = r;
        }
        int rr = max;
        int rc = n/rr;
        
        char[][] arr = new char[rc][rr];
        int k = 0;
        for(int i = 0; i < rc; i++){
            for(int j = 0; j < rr; j++){
                arr[i][j] = str.charAt(k);
                k++;
            }
        }
        for(int i = 0; i < rr; i++){
            for(int j = 0; j < rc; j++){
                bw.write(arr[j][i] + "");
            }
        }
        bw.flush();
        bw.close();
    }
}