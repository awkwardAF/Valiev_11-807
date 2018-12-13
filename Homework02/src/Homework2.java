import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int highest = 0;
        int highest2 = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a > highest) {
                highest2 = highest;
                highest = a;
            }
        }
        System.out.println("Highest is " + highest );
        System.out.println("Second highest is " + highest2);
    }
}
