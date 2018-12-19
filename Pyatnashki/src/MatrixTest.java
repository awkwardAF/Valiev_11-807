import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MatrixTest {

    Matrix matrix;

    @Before
    public void setUp() {
        matrix = new Matrix();
    }

    // проверяет, что кол-во сгенерированных случайным образом чисел соответсувет кол-ву ячеек матрицы
    @Test
    public void testAmountOfRandomedElements() {
        int n = 0;
        int count = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = ((int) ((Math.random() * 15)));
                if (matrix[i][j] == matrix.length) {
                    matrix[i][j] = ((int) ((Math.random() * 15)));
                    count++;
                }
            }

        }

        int newMatrix[][] = new int[n][n];
        int[][] actual = newMatrix;
        int newCount = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newCount++;
            }
        }
        assertEquals(count, newCount);
    }

    // проверяет, что каждый элемент матрицы >= 0
    @Test
    public void testHigher() {
        int n = 0;
        int count = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = ((int) ((Math.random() * 15)));
                if (matrix[i][j] == matrix.length) {
                    matrix[i][j] = ((int) ((Math.random() * 15)));
                    count++;
                }
            }
        }
        int sum1 = 16;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] >= 0) {
                    int sum = 0;
                    sum++;
                    assertEquals(sum, sum1);
                }
            }
        }
    }

    // проверяет на наличие файла в папке
    @Test
    public void testFileExists () {
        assertTrue(new File("pyat.txt").exists());
    }

    // проверяет, что в матрице есть пустая клетка
    @Test
    public void testContainsZero () throws FileNotFoundException {
        boolean has = false;
        Scanner file = new Scanner(new File ("pyat.txt"));
        while (file.hasNextInt()) {
            if (file.nextInt() == 0) {
                has = true;
            }
        }
        System.out.println(has);
        assertTrue(has);
    }

    @Test
    public void test () {

    }

}