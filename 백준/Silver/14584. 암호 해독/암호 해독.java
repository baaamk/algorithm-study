import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //사전 중 하나라도 맞으면 그대로 출력 -> 안맞으면 맨 뒤 앞으로 보내기

        String str = br.readLine();
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }
        
        for(int i = 0; i < 26; i++){
            String temp = "";
            for(int j = 0; j < str.length(); j++){
                temp += (char)((str.charAt(j) - 'a' + i) % 26 + 'a');
            }
            for(int j = 0; j < n; j++){
                if(temp.contains(arr[j])){
                    bw.write(temp);
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}