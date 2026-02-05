import java.util.*;
import java.io.*;

class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] numbers;
    static int[] arr = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    static void backTrack(int index, int current) throws IOException{
        if(index == n){
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            if(arr[i] != 0){
                arr[i]--;
                int next = current;
                if(i == 0){
                    next = current + numbers[index];
                } else if(i == 1){
                    next = current - numbers[index];
                } else if(i == 2){
                    next = current * numbers[index];
                } else {
                    if (current < 0){
                        next = -(-current / numbers[index]);
                    } else {
                        next = current / numbers[index];
                    }
                }
                backTrack(index + 1,next);
                arr[i]++;
            }
            
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backTrack(1, numbers[0]);
        bw.write(max +"\n");
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}