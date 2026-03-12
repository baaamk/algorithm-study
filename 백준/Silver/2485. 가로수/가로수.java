import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        int gcd = 0;
        
        for(int i = 1; i < n; i++){
            int a = list.get(i - 1);
            int b = list.get(i);
            gcd = gcd(gcd, b - a);
            
        }
        
        int answer = ((list.get(n -1) - list.get(0)) / gcd + 1) - n;
            
        bw.write(answer+ "");
        bw.flush();
        bw.close();
        
    }
    
    static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}