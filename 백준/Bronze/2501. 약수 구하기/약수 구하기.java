import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //n약수들 중 k번째 출력
        //없다면 0 출력 20  1 2 
        List<Integer> a = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                a.add(i);
            }
        }
        if(a.size() < k){
            bw.write("0");
        } else{
            bw.write(String.valueOf(a.get(k-1)));
        }
        bw.flush();
        bw.close();
    }
}