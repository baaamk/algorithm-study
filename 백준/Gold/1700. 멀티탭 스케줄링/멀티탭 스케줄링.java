import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        boolean[] power = new boolean[k + 1];
        int[] arr = new int[k+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i<=k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int ans = 0;
        
        for(int i = 1; i <= k; i++){
            int cur = arr[i];
            
            if(power[cur]){
                continue;
            }
            
            if(count < n){
                power[cur] = true;
                count++;
            } else {
                List<int[]> idx = new ArrayList<>();
                
                for(int x = 1; x <= k; x++){
                    if(!power[x]){
                        continue;
                    }
                    boolean vis = false;
                    for(int y = i + 1; y <=k; y++){
                        if(arr[y] == x){
                            idx.add(new int[] {y, x});
                            vis = true;
                            break;
                        }
                    }
                    if(!vis){
                        idx.add(new int[]{k + 1, x});
                    }
                }
                idx.sort((o1, o2)-> o2[0]-o1[0]);
                
                int target = idx.get(0)[1];
                power[target] = false;
                ans++;
                power[cur] = true;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}