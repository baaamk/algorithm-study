import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    //국어 감소 -> 영어 증가 -> 수학 감소 -> 이름 사전순 감소
    
        int n = Integer.parseInt(br.readLine());
        String[] name = new String[n];
        Map<String, Integer> kor = new HashMap<>();
        Map<String, Integer> en = new HashMap<>();
        Map<String, Integer> math = new HashMap<>();
    
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String named = st.nextToken();
            name[i] = named;
            kor.put(named, Integer.parseInt(st.nextToken()));
            en.put(named, Integer.parseInt(st.nextToken()));
            math.put(named, Integer.parseInt(st.nextToken()));
        }
    
        Arrays.sort(name, (a,b) -> {
            if(kor.get(a) != kor.get(b)){
                return kor.get(b) - kor.get(a);
            }
            if(en.get(a) != en.get(b)){
                return en.get(a) - en.get(b);
            }
            if(math.get(a) != math.get(b)){
                return math.get(b) - math.get(a);
            }
            return a.compareTo(b);
        });
    
        for(String a : name){
            bw.write(a);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}