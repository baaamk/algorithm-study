import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        
        for(int i = 1; i <= n; i++){
            long a = Long.parseLong(br.readLine());
            if (a == 0 || a == 1){
                bw.write("2");
                bw.newLine();
                continue;
            }
            while(true){
                boolean status = false;
                for(int j = 2; j <= Math.sqrt(a); j++) {
			        if(a % j == 0) {
                        a++;
                        status = true;
			        	break;
			        }
		        }
                if(!status){
                    bw.write(String.valueOf(a));
                    bw.newLine();
                    break;
                }
                
            }
        }
        bw.flush();
        bw.close();
        
    }
}