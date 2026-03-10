import java.util.*;
import java.io.*;

class Main{
    static int[][] a;
    static int ans;
    static int n,m,k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        a = new int[4][8];
        for(int i = 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                a[i][j] = str.charAt(j) - '0';
            }
        }
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()) - 1;
            k = Integer.parseInt(st.nextToken());
            
            move(m, k);
        }
        for(int i = 0; i < 4; i++){
            if(a[i][0] == 1){
                if(i == 0){
                    ans +=1;
                } else if(i == 1){
                    ans +=2;
                } else if(i == 2){
                    ans +=4;
                } else if(i == 3){
                    ans +=8;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    //1 시계방향 -1 반시계방향
    static void move(int number, int dir){
        boolean[] same = new boolean[3];
        for(int i = 0; i < 3; i++){
            if(a[i][2] == a[i + 1][6]){
                same[i] = true;
            }
        }
        
        int[] rotateDir = new int[4];
        rotateDir[number] = dir;
        
        for(int i = number; i > 0; i--){
            if(same[i - 1]){
                break;
            }
            rotateDir[i-1] = - rotateDir[i];
        }
        
        for(int i = number; i < 3; i++){
            if(same[i]){
                break;
            }
            rotateDir[i+1] = - rotateDir[i];
        }
        
        for(int i = 0; i < 4; i++){
            if(rotateDir[i] == 1){
                int temp = a[i][7];
                for(int j = 7; j > 0; j--){
                    a[i][j] = a[i][j - 1];
                }
                a[i][0] = temp;
            } else if(rotateDir[i] == -1){
                int temp = a[i][0];
                for(int j = 0; j < 7; j++){
                    a[i][j] = a[i][j + 1];
                }
                a[i][7] = temp;
            }
        }
    }
}