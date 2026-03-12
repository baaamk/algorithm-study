import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();
        int total = 0;
        for(int i = 0; i < 5; i++){
            int n = Integer.parseInt(br.readLine());
            total += n;
            arr.add(n);
        }
        arr.sort(Comparator.naturalOrder());
        
        bw.write(total/5 + "");
        bw.newLine();
        bw.write(arr.get(2) + "");
        bw.flush();
        bw.close();
    }
}