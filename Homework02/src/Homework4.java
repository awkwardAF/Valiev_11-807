import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int a = sc.nextInt();
            while (a != 0){
                sum += a % 10;
                a /= 10;
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
