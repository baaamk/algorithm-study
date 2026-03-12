import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        String second = scanner.next();

        System.out.println((second.charAt(2) - '0') * first);
        System.out.println((second.charAt(1) - '0') * first);
        System.out.println((second.charAt(0) - '0') * first);
        System.out.println(Integer.parseInt(second) * first);

    }
}