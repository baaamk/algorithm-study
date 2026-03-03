import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        while(!list.isEmpty()){
            index = (index + k - 1) % list.size();
            answer.add(list.remove(index));
        }
        
        bw.write("<");
        for(int i = 0; i < answer.size(); i++){
            if(i == answer.size() - 1){
                bw.write(answer.get(i)+"");
            } else {
                bw.write(answer.get(i) + ", ");
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}