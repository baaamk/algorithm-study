import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        
        for(Integer a : arr){
            bw.write(a+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}