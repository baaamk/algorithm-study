import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer,Integer> freq = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        List<Integer> list = new ArrayList<>(freq.keySet());

        list.sort((a,b) -> freq.get(b) - freq.get(a));

        StringBuilder sb = new StringBuilder();

        for(int num : list){
            for(int i = 0; i < freq.get(num); i++){
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}