import java.util.Scanner;

public class Homework7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 1; i <= n; i++) {
            int k = i - 2, j = -1;
            while (k + 1 < n) {
                j++;
                k++;
                matrix[j][k] = i;
                matrix[k][j] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
