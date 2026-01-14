import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int totalAmount = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int product = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            result += product * amount;
        }
        if (totalAmount == result){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}