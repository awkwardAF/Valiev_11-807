import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m]; //{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int maxInd = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sumStr = 0;
            for (int j = 0; j < m; j++) {
                sumStr += matrix[i][j];
            }
            if (sumStr > maxSum) {
                maxSum = sumStr;
                maxInd = i;
            }
        }
        int maxInd2 = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int sumCol = 0;
            for (int j = 0; j < n; j++) {
                sumCol += matrix[j][i];
            }
            if (sumCol > maxSum) {
                maxSum = sumCol;
                maxInd2 = i;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.print(matrix[maxInd][i] + " ");
        }
        System.out.println();
        //System.out.printf("hey = %d and %d %s", 10, 20 srt) = hey = 10 and 20 srt;
        //System.out.printf("%2f", 2.5555564466); = 2.55
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][maxInd2] + " ");
        }
    }
}
