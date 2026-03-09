import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] selected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    chicken.add(new int[] {i, j});
                } else if(board[i][j] == 1){
                    house.add(new int[] {i, j});
                }
            }
        }
        selected = new boolean[chicken.size()];
        dfs(0,0);
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int depth, int start) {
        if (depth == m) {
            int cityDist = 0;

            for (int[] h : house) {
                int hr = h[0];
                int hc = h[1];
                int dist = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (!selected[i]) {
                        continue;
                    }

                    int cr = chicken.get(i)[0];
                    int cc = chicken.get(i)[1];

                    dist = Math.min(dist, Math.abs(hr - cr) + Math.abs(hc - cc));
                }

                cityDist += dist;
            }

            min = Math.min(min, cityDist);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[i] = true;
            dfs(depth + 1, i + 1);
            selected[i] = false;
        }
    }
}