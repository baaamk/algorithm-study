import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int time = 0;

        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);

            if(a == 'A' || a == 'B' || a == 'C'){
                time += 3;
            } else if(a == 'D' || a == 'E' || a == 'F'){
                time += 4;
            } else if(a == 'G' || a == 'H' || a == 'I'){
                time += 5;
            } else if(a == 'J' || a == 'K' || a == 'L'){
                time += 6;
            } else if(a == 'M' || a == 'N' || a == 'O'){
                time += 7;
            } else if(a == 'P' || a == 'Q' || a == 'R' || a == 'S'){
                time += 8;
            } else if(a == 'T' || a == 'U' || a == 'V'){
                time += 9;
            } else if(a == 'W' || a == 'X' || a == 'Y' || a == 'Z'){
                time += 10;
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
}