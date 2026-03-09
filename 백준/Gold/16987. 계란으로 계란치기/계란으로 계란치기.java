import java.util.*;
import java.io.*;

class Main{
    static class Egg{
        int hp;
        int weight;
        
        Egg (int hp, int weight){
            this.hp = hp;
            this.weight = weight;
        }
    }
    
    static int n;
    static Egg[] eggs;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            eggs[i] = new Egg(hp, weight);
        }
        
        crash(0, 0);
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
    
    static void crash(int depth, int count){
        if(depth == n){
            max = Math.max(max, count);
            return;
        }
        boolean canHit = false;
        
        for(int i = 0; i < n; i++){
            if(i == depth){
                continue;
            }
            if(eggs[depth].hp <= 0){
                continue;
            }
            if(eggs[i].hp <= 0){
                continue;
            }
            canHit = true;
            Egg leftEgg = eggs[depth];
            Egg rightEgg = eggs[i];
            int lhp = leftEgg.hp;
            int rhp = rightEgg.hp;
            int broken = 0;
            leftEgg.hp = leftEgg.hp - rightEgg.weight;
            rightEgg.hp = rightEgg.hp - leftEgg.weight;
            if(leftEgg.hp <= 0){
                broken++;
            }
            if(rightEgg.hp <= 0){
                broken++;
            }
            crash(depth + 1, count + broken);
            leftEgg.hp = lhp;
            rightEgg.hp = rhp;
            
        }
        if(!canHit){
            crash(depth + 1, count);
        }
    }
}