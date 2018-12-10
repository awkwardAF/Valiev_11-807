import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int m = sc.nextInt();
        int[][] matrix = new int[n][n]; //{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //if () else if() else
        boolean isMagic = true;
        int glav = 0;
        int obr = 0;
        //int n = matrix.length; //число строк
        //int m = matrix[0].length; //число столбцов
        for (int i = 0; i < n; i++) {
            glav += matrix[i][i];
            //collateral
            obr += matrix[n - i - 1][n - i - 1];
        }
        isMagic = (glav == obr);
        for (int i = 0; i < n; i++) {
            int sum = 0; int sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                sum2 += matrix[j][i];
            }
            if (sum!=glav || sum2 !=glav) isMagic = false;
        }
        System.out.println(isMagic);
    }
}
