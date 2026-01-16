import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] list = new double[n];
        for(int i = 0; i < list.length; i++){
            //최대값 구하고
            //모든 점수를 점수/M*100 로 변경
            //그리고 평균 점수 
            list[i] = (double) Integer.parseInt(st.nextToken());
        }
        
        double max = list[0];
        
        for(int i = 0; i < list.length; i++){
            if(max <= list[i]){
                max = list[i];
            }
        }
        double result = 0;
        for(int i = 0; i < list.length; i++){
            list[i] = (list[i] / max) * 100;
            result += list[i];
        }
        double average = result/list.length;
        bw.write(String.valueOf(average));
        bw.flush();
        bw.close();
        
    }
}