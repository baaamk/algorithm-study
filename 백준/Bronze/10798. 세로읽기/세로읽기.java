import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] a = new String[5][15];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 15; j++){
                a[i][j] = "";
            }
        }
        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                a[i][j] = String.valueOf(str.charAt(j));
            }
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                bw.write(a[j][i]);
            }
        }
        bw.flush();
        bw.close();
    }
}