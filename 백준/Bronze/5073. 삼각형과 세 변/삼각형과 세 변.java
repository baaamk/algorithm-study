import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0 && c== 0){
                bw.flush();
                bw.close();
                break;
            }
        
            int max = Math.max(a,Math.max(b,c));
        
            if(max == a){
                if(a >= b + c){
                    bw.write("Invalid");
                    bw.newLine();
                    continue;
                }
            } else if(max == b) {
                if(b >= a + c){
                    bw.write("Invalid");
                    bw.newLine();
                    
                    continue;
                    
                }
            } else {
                if(c >= a + b){
                    bw.write("Invalid");
                    bw.newLine();
                    
                    continue;
                    
                }
            }
            
            if(a == b && a == c && b == c){
                bw.write("Equilateral");
                bw.newLine();
            } else if(a == b || a == c || b == c){
                bw.write("Isosceles");
                bw.newLine();
                
            } else {
                bw.write("Scalene");
                bw.newLine();
                
            }
        
        }
        
    }
}