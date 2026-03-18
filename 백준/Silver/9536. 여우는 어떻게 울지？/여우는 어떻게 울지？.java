import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t -- >0){
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = st.countTokens();
            for(int i = 0; i < num; i++){
                list.add(st.nextToken());
            }
            
            while(true){
                String s = br.readLine();
                if(s.equals("what does the fox say?")){
                    break;
                }
                st = new StringTokenizer(s);
                st.nextToken();
                st.nextToken();
                list2.add(st.nextToken());

            }
            list.removeAll(list2);
            for(String w : list){
                bw.write(w + " ");
            }
            bw.newLine();
            
        }
        bw.flush();
        bw.close();
    }
}