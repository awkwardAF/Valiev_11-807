import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StartGame {

    private Matrix matrix = new Matrix();

    public String login() throws IOException {
        System.out.println("Здравствуйте, введите свое имя, чтобы зайти в свой профиль или создать новый");
        Scanner sc = new Scanner(System.in);
        String answer = null;
        boolean logged = false;
        while (!logged) {
            String s = sc.nextLine();
            matrix.setUsername(s);
            if (new File(s + ".txt").exists()) {
                System.out.println("Какие люди! Вы снова тут!");
                System.out.println("Если вы хотите начать новую игру, то введите \"new\", чтобы продолжить игру - \"continue\"");
                answer = sc.nextLine();
                if (answer.equals("new") | answer.equals("continue")) {
                    logged = true;

                } else {
                    System.err.println("Такой команды не существует");
                }
            } else {
                logged = true;
                System.out.println("Добро пожаловать в игру, мы всегда рады новым знакомствам!");
                System.out.println("Чтобы начать новую игру, введите \"new\"");
                answer = sc.nextLine();
            }
        }
        return answer;
    }



    public Matrix begin(String answer) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
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
                        System.err.println("Вы вводите определенно что-то не то");
                        answer = sc.nextLine();
                        break;
                    }
            }
        }
        return matrix;
    }

}
