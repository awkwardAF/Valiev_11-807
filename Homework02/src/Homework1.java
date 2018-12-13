import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0;
        int odd = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a % 2 == 0) {
                even += a;
            }
            else {
                odd += a;
            }
        }
        int difference = even - odd;
        System.out.println("Разница: " + Math.abs(difference));
    }
}
