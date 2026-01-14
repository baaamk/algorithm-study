import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int multiple = n / 4;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < multiple; i++){
            sb.append("long").append(" ");
        }
        sb.append("int");
        
        System.out.println(sb);
    }
}