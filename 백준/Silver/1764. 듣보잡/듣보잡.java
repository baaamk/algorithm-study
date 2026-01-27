import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String a = br.readLine();
            if(set.contains(a)){
                list.add(a);
            }
        }
        list.sort(Comparator.naturalOrder());
        int number = list.size();
        bw.write(number+"");
        bw.newLine();
        for(String a : list){
            bw.write(a);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}