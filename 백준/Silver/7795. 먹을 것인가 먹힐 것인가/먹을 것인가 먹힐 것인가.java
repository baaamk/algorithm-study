import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Integer[] A = new Integer[n];
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(A, Comparator.reverseOrder());
            
            int count = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            
            for(int i = 0; i < n; i++){
                int temp = A[i];

                for(int j = 0; j < m; j++){
                    if(temp <= B[j]){
                        break;
                    }
                    count++;
                }
            }
            bw.write(count+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        
    }
}