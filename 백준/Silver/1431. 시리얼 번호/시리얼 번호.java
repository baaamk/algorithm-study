import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] arsg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            }
            
            int numA = digitSum(a);
            int numB = digitSum(b);
            
            if(numA != numB){
                return numA - numB;
            }
            
            return a.compareTo(b);
        });
        
        for(int i = 0; i < n; i++){
            bw.write(arr[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    static int digitSum(String a){
        int sum = 0;
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) >= '0' && a.charAt(i) <= '9'){
                sum += a.charAt(i) - '0';
            }
        }
        return sum;
    }
}