import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StartGame {

    File pass;
    private Matrix matrix = new Matrix();

    public String login() throws IOException {
        System.out.println("Здравствуйте, введите свое имя, чтобы зайти в свой профиль или создать новый");
        Scanner sc = new Scanner(System.in);
        String answer = null;
        boolean logged = false;
        while (!logged) {
            String name = sc.nextLine();
            matrix.setUsername(name);
            if (new File(name + ".txt").exists()) {
                System.out.println("Введите свой пароль для входа в аккаунт");
                String t = sc.nextLine();
                if (passCheck(t, name)) {
                    System.out.println("Какие люди! Вы снова тут!");
                    System.out.println("Если вы хотите начать новую игру, то введите \"new\", чтобы продолжить игру - \"continue\"");
                    answer = sc.nextLine();
                    if (answer.equals("new") | answer.equals("continue")) {
                        logged = true;

                    } else {
                        System.err.println("Такой команды не существует");
                        System.out.println("Введите свое имя снова");
                    }
                }
            } else {
                pass = new File(name + "pass.txt");
                System.out.println("Введите свой новый пароль для входа в аккаунт");
                String t = sc.nextLine();
                createPass(t, name);
                System.out.println("Добро пожаловать в игру, мы всегда рады новым знакомствам!");
                System.out.println("Чтобы начать новую игру, введите \"new\"");
                answer = sc.nextLine();
                logged = true;
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

    private boolean passCheck(String password, String name) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(name + "pass.txt"));
        return password.equals(scan.nextLine());
    }

    private void createPass(String pass, String name) throws IOException {
        FileWriter write = new FileWriter(name + "pass.txt");
        write.write(pass);
        write.close();
    }

}
