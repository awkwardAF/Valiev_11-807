import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StartGame {

    private Matrix matrix = new Matrix();

    public Matrix begin() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Если вы хотите начать новую игру, то введите \"new\", чтобы продолжить игру - \"continue\"");
        boolean done = false;
        while (!done) {
            String answer = sc.nextLine();
            switch (answer) {
                case "new":
                    matrix.random();
                    done = true;
                    break;
                case "continue":
                    try {
                        matrix.readFile();
                    } catch (FileNotFoundException e) {
                        System.err.println("Файл где-то потерялся");
                    }
                    System.out.println("Вы продолжили игру");
                    done = true;
                default:
                    if (!done) {
                        System.err.println("Вы че-то не то вводите");
                        break;
                    }
            }
        }
        return matrix;
    }

}
