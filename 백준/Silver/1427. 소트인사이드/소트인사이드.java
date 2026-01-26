import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String number = br.readLine();
        int[] arr = new int[number.length()];
        for(int i = 0; i < number.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        Arrays.sort(arr);
        
        for(int i = arr.length - 1; i >= 0; i--){
            bw.write(arr[i]+"");
        }
        bw.flush();
        bw.close();
    }
}