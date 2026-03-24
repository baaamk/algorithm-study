class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        //마지막 공격초
        int maxHealth = health;
        int n = attacks[attacks.length-1][0];
        int time = bandage[0];
        int plus = bandage[1];
        int fin = bandage[2];
        int sec = 1;
        for(int j = 0; j < attacks.length; j++){
            
            int monSec = attacks[j][0];
            if(j == 0){
                sec = monSec - sec;
            } else {
                sec = monSec - sec - 1;
            }
            
            
            int mondam = attacks[j][1];
            health += (plus * sec);
            if(sec >= time){
                health += sec/time*fin;
            }
            if(health > maxHealth){
                health = maxHealth;
            }
            health -= mondam;
            if(health <= 0){
                return -1;
            }
            sec = attacks[j][0];
        }

        
        
        int answer = health;
        return answer;
    }
}