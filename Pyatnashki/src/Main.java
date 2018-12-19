import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static boolean play = true;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean go = false;
        while (!go) {
            System.out.println("Если вы хотите начать новую игру, то введите \"new\", чтобы продолжить игру - \"continue\"");
            String e = sc.nextLine();
            if (e.equals("new")) {
                System.out.println("Сколько строк (столбцов) вы хотите в матрице?");
                int n = sc.nextInt();
                Matrix.readFile(n);
                Matrix.randomMatrix(n);
                go = true;
            } else if (e.equals("continue")) {
                System.out.println("Вы продолжили игру");
                go = true;
            } else {
                System.err.println("No such command");
            }
        }
        System.out.println("\"type\" - enter new level by yourself,");
        System.out.println("\"exit\" - save and exit the game");
        System.out.println("\"undo\" - moves \"0\" to previous position");
        System.out.println("\"random\" - random matrix");
        System.out.println("or enter coordinates to move Zero");
        Matrix.readFile(Matrix.n);
        Matrix.vivod();
        while (play) {
            Matrix.shift();
            Matrix.check();
        }
    }
}