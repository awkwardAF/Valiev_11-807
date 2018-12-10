import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        int c = (((n * m) - n) / 2) + n, i = 0, j = -1;
        //System.out.println(c);
        int[][] matrix = new int[n][m];
        int k = 0;
        while (k < c) {
            while (j + 1 < m && matrix[i][j + 1] == 0) {
                j++;
                k++;
                matrix[i][j] = k;
            }
            while (i + 1 < n && matrix[i + 1][j] == 0) {
                i++;
                k++;
                matrix[i][j] = k;
            }
            while (j - 1 > -1 && i - 1 > -1 && matrix[i - 1][j - 1] == 0) {
                j--;
                i--;
                k++;
                matrix[i][j] = k;
            }
        }
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < m; j++) {
                System.out.printf("%4d", matrix[i][j]);
                //System.out.print(matrix[i][j] + "\t");
            }

        }
    }
}
