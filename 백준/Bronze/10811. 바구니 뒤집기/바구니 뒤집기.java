import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        
        for(int i = 0; i < a.length; i++){
            a[i] = i + 1;
        }
        for(int i = 0; i < m; i++){
            //b와 c의 순서를 역으로 한다.
            // 1, 3 들어왔다면 3,2,1
            // 1,4 => 4,3,2,1
            // 어떻게 바꾸지.. 역순. 1 2 3 4 => 1 4 / 2 3 , 1 3 2
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            while (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
                }
        }
        for(int i = 0; i < a.length; i++){
            bw.write(a[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}