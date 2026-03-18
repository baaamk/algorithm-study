import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        char[] arr2 = new char[m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        
        for(int i = 0; i < m; i++){
            int a = 0;
            int g = 0;
            int c = 0;
            int t = 0;
            int max = 0;
            for(int j = 0; j < n; j++){
                char target = arr[j][i];
                if(target == 'A'){
                    a++;
                    max = Math.max(max, a);
                } else if(target == 'G'){
                    g++;
                    max = Math.max(max, g);
                    
                } else if(target == 'C'){
                    c++;
                    max = Math.max(max, c);
                    
                } else if(target == 'T'){
                    t++;
                    max = Math.max(max, t);
                }
            }
            if(max == a){
                arr2[i] = 'A';
            } else if(max == c){
                arr2[i] = 'C';
            } else if(max == g){
                arr2[i] = 'G';
            } else if(max == t){
                arr2[i] = 'T';
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr2[j] != arr[i][j]){
                    count++;
                }
            }
        }
        for(char d : arr2){
            bw.write(d);
        }
        bw.newLine();
        bw.write(count +"");
        bw.flush();
        bw.close();
    }
}