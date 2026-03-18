import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String s = st.nextToken();

            long bit = 0;
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == 'Y'){
                    bit |= (1L << j);
                }
            }
            arr[i] = bit;
        }

        int maxSong = 0;
        int minGuitar = Integer.MAX_VALUE;

        for(int i = 1; i < (1 << n); i++){
            long sum = 0;
            int guitarCount = 0;

            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    sum |= arr[j];
                    guitarCount++;
                }
            }

            int songCount = 0;
            for(int j = 0; j < m; j++){
                if((sum & (1L << j)) != 0){
                    songCount++;
                }
            }

            if(songCount > maxSong){
                maxSong = songCount;
                minGuitar = guitarCount;
            } else if(songCount == maxSong){
                minGuitar = Math.min(minGuitar, guitarCount);
            }
        }

        if(maxSong == 0){
            bw.write("-1");
        } else {
            bw.write(minGuitar + "");
        }

        bw.flush();
        bw.close();
    }
}