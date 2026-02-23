import java.util.*;
import java.io.*;

class Main {
    static int jun;
    static int sung;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[14];
        for(int i = 0; i < 14; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        calJun(n, price);
        calSung(n, price);
        
        if(jun > sung) {
            bw.write("BNP");
        } else if(jun < sung) {
            bw.write("TIMING");
        } else {
            bw.write("SAMESAME");
        }
        bw.flush();
        bw.close();
    }
    
    static void calJun(int n, int[] price){
        int money = n;
        int count = 0;
        for(int i = 0; i < 14; i++){
            if(money < price[i]){
                continue;
            } 
            int temp = money / price[i];
            count += temp;
            money -= temp * price[i];
        }
        
        jun = money + price[13] * count;
    }
    
    static void calSung(int n, int[] price){
        int money = n;
        int count = 0;
        
        for(int i = 3; i < 14; i++){
            if(price[i] > price [i - 1] & price[i - 1] > price [i - 2] & price[i - 2] > price [i - 3]){
                money += price[i] * count;
                count = 0;
            } else if (price[i] < price [i - 1] & price[i - 1] < price [i - 2] & price[i - 2] < price [i - 3]){
                
                int temp = money / price[i];
                count += temp;
                money -= temp * price[i];
            }
        }
        sung = money + price[13] * count;
    }
}