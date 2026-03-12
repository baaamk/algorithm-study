import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input <= 100 && input >= 90) {
            System.out.println("A");
        } else if (input <= 89 && input >= 80) {
            System.out.println("B");
        } else if (input <= 79 && input >= 70) {
            System.out.println("C");
        } else if (input <= 69 && input >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
    


