import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 0;
        int prev = 0;
        int b;
        for (int i = 0; i < n; i++) {
            b = sc.nextInt();
            prev = last;
            b = prev;
            if (last < prev && b < prev) {
                if (i != 0 && i != n) {
                    System.out.println(prev);
                }
            }
        }
    }
}
