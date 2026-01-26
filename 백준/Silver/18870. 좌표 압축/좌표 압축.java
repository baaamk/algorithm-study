import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //해당 숫자보다 작은 개수 출력하면 된다.
        
        int[] list = new int[n];
        int[] sort = new int[n];
        
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            sort[i] = list[i];
        }
        Arrays.sort(sort);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        
        for(int a : sort){
            if(!map.containsKey(a)){
                map.put(a, index++);
            }
        }
        
        for(int a : list){
            bw.write(map.get(a) + " ");
        }
        
        bw.flush();
        bw.close();
    }
}