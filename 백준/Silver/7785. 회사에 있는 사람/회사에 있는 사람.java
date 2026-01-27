import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            
            if(status.equals("enter")){
                set.add(name);   
            } else {
                set.remove(name);
            }
        }
        
        List<String> result = new ArrayList<>(set);
        result.sort(Comparator.reverseOrder());
        
        for(String a : result){
            bw.write(a);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        
        
    }
}