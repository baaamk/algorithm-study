import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        //m~n 소수 전체 더하기.
        //소수가 없다면 -1 출력.
        
        int result = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i = m; i <= n; i++){
            if(i == 1){
                continue;
            }
            result += i;
            arr.add(i);
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    result -= i;
                    arr.remove(Integer.valueOf(i));
                    break;
                }
            }
        }
        if(result == 0){
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
            bw.newLine();
            bw.write(String.valueOf(arr.get(0)));
        }
        bw.flush();
        bw.close();
    }
}