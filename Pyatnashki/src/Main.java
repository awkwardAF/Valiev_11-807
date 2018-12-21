import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static boolean play = true;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException, InterruptedException {
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
                Matrix.readFile();
                go = true;
            } else {
                System.err.println("Такой команды нет, введите снова");
            }
        }
        System.out.println("Enter coordinates to move Zero");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\"type\" - enter new level by yourself");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\"undo\" - moves \"0\" to previous position");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\"random\" - random matrix");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\"save\" - saves matrix");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\"exit\" - save and exit the game");
        Matrix.readFile(Matrix.n);
        Matrix.vivod();
        while (play) {
            Matrix.shift();
            Matrix.vivod();
            Matrix.check();
        }
    }
}