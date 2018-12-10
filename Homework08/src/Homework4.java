import java.util.Scanner;

public class Homework4 {
    //мин в строке макс в столбце
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int minInd = 0, maxInd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] < matrix[i][minInd]) {
                    minInd = j;
                }
                maxInd = 0;
                for (int k = 0; k < n; k++) {
                    if (matrix[k][minInd] > matrix[maxInd][minInd]) {
                        maxInd = k;
                    }
                }
            }
            if (i == maxInd ) System.out.print(matrix[maxInd][minInd] + " ");
        }
    }
}
