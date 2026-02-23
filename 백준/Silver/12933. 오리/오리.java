import java.util.*;
import java.io.*;
 
public class Main {
    static char[] duck = new char[]{'q', 'u', 'a', 'c', 'k'};
    
    static char[] ch;
    static boolean[] visited;
    
    static int idx, cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ch = br.readLine().toCharArray();
        visited = new boolean[ch.length];
        
        if(ch[0] != 'q' || ch.length % 5 != 0) {
            System.out.println(-1);
            return;
        }
        
        for(int i = 0 ; i < ch.length ; i++) {
            List<Character> list = new ArrayList<>();
            
            for(int j = i ; j < ch.length ; j++) {
                if(visited[j])  continue;
                
                if(ch[j] == duck[idx]) {
                    visited[j] = true;
                    list.add(ch[j]);
                    idx = (idx + 1) % 5;
                }
            }
            
            if(list.size() != 0) {
                if(list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}