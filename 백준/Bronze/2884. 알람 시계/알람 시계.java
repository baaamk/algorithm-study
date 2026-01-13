import java.util.*;

class Main{
    public static void main(String[] args){
        //시간 -45분 한게 답이다.

        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        M = M - 45;
        
        
        if(M < 0){
            H -= 1;
            if (H < 0){
                H = 23;
            }
            M = 60 + M;
        }
        System.out.println(H + " " + M);
    }
}