import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int min = 999;
        int prev = 0;
        for (int i = 0; i < a; i++) {
            int now = sc.nextInt();
            if (Math.abs(now - prev) < min ) {
                min = now - prev;
            }
            prev = now;
        }
        System.out.println("Lowest difference: " + min);
    }
}
