import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] A = new int[9];
        
        for(int i = 0; i < A.length; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        
        int max = A[0];
        int index = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] >= max){
                max = A[i];
                index = i + 1;
            }
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(index));
        bw.flush();
        bw.close();
    }
}