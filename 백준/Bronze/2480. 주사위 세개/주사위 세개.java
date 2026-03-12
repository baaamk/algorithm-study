import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        int max = 0;
        
        if(first != second && second !=third && first != third){
            max = Math.max(first, Math.max(second,third));
            System.out.println(max * 100);
        } else if(first == second && second == third){
            max = first;
            System.out.println(10000 + max * 1000);
        } else if(first == second || second == third){
            max = second;
            System.out.println(1000 + max * 100);
        } else {
            max = third;
            System.out.println(1000 + max * 100);
        }
        
        
    }
}