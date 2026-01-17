import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String st = br.readLine();
        int[] list = new int[26];
        
        for(int i = 0; i < list.length; i++){
            list[i] = -1;
        }
        for(int i = 0; i < st.length(); i++){
            char a = st.charAt(i);
            int b = (byte) a - 97; //알파벳 위치
            if(list[b] == -1){
                list[b] = i;
            }
        }
        
        for(int c : list){
            bw.write(c + " ");
        }
        bw.flush();
        bw.close();
    }
}