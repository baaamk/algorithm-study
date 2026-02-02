import java.util.*;
import java.io.*;

class Main{
    static int number;
    public static int recursion(String s, int l, int r){
        number++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            number = 0;
            bw.write(isPalindrome(br.readLine()) + " " + number);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}