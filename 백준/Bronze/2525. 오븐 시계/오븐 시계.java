import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int ovenTime = sc.nextInt();
        
        //오븐타임은 분으로만 입력 -> 시간으로 바꾸어야 함.
        int ovenMin = min + ovenTime;
        
        int ovenHour = ovenMin/60;
        
        hour = hour + ovenHour;
        
        min = ovenMin%60;
        
        if(hour > 23){
            hour = hour - 24;
        }
        
        System.out.println(hour + " " + min);
       
        
    }
}