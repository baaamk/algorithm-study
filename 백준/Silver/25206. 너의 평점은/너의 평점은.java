import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double total = 0;
        double credits = 0;
        for(int i = 0; i < 20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            credits += credit;
            String grade = st.nextToken();
            if(grade.equals("A+")){
                total += credit * 4.5;
            } else if(grade.equals("A0")){
                total += credit * 4.0;
            } else if(grade.equals("B+")){
                total += credit * 3.5;
            } else if(grade.equals("B0")){
                total += credit * 3.0;
            } else if(grade.equals("C+")){
                total += credit * 2.5;
            } else if(grade.equals("C0")){
                total += credit * 2.0;
            } else if(grade.equals("D+")){
                total += credit * 1.5;
            } else if(grade.equals("D0")){
                total += credit * 1.0;
            } else if(grade.equals("F")){
                total += 0;
            } else {
                credits -= credit;
            }
        }
        double result = total / credits;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}