

import java.io.IOException;
import java.util.Scanner;


public class Game {

    private Matrix matrix;
    boolean loggedIn = false;
    boolean play = true;

    public Game(Matrix matrix) {
        loggedIn = true;
        this.matrix = matrix;
        System.out.println("Возможности:");
        System.out.println("Переместить \"0\" в ближайшую клетку по горизотали или вертикали");
        System.out.println("Для этого введите двузначное число, где первая цифра координата x, а вторая - y");
        System.out.println("\"undo\" - возвращаят \"0\" на предыдущую позицию");
        System.out.println("\"type\" - позволяет ввести матрицу собственноручно");
        System.out.println("\"random\" - генерирует матрицу с указанной размерностью");
        System.out.println("\"save\" - сохраняет вашу матрицу");
        System.out.println("\"logout\" - выйти из профиля");
        System.out.println("\"exit\" - выйти из игры");
    }

    public void action() throws IOException {
        boolean performed = false;
        Scanner sc = new Scanner(System.in);
        while (!performed) {
            String answer = sc.nextLine();
            switch (answer) {
                case "undo":
                    matrix.undo();
                    performed = true;
                    matrix.setSaved(false);
                    break;
                case "type":
                    matrix.type(matrix);
                    performed = true;
                    matrix.setSaved(false);
                    break;
                case "random":
                    matrix.random();
                    performed = true;
                    matrix.setSaved(false);
                    break;
                case "save":
                    matrix.writeFile();
                    performed = true;
                    matrix.setSaved(true);
                    break;
                case "logout":
                    loggedIn = false;
                    performed = true;
                    break;
                case "exit":
                    performed = true;
                    exit();
                    break;
                default:
                    if (isParsable(answer)) {
                        int a = Integer.parseInt(answer);
                        if (a < 0) System.err.println("Координаты не могут быть отрицательными");
                        else if ((a >= 0) && isTwo(answer)) {
                            matrix.shift(a);
                            performed = true;
                        }
                        else if (!isTwo(answer)) System.err.println("Число должно состоять из двух цифр и быть положительным ( Например, 21: 2 - координата по x, 1 - по y )");
                        else System.err.println("Координаты введены в неверном формате");
                    }
                    matrix.setSaved(false);
                    break;
            }
        }
    }

    private boolean isParsable(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isTwo(String s) {
        char[] ch = s.toCharArray();
        return ch.length == 2;
    }

    private void exit() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (matrix.getSaved()) {
            System.out.println("Спасибо за игру");
            play = false;
        }
        else {
            System.err.println("Вы действительно хотите выйти без сохранения?");
            System.out.println("1 - сохранить и выйти.");
            System.out.println("0 - выйти без сохранения");
            boolean quit = false;
            while (!quit) {
                switch (sc.nextInt()) {
                    case 1:
                        matrix.writeFile();
                        System.out.println("Спасибо за уделенное время");
                        play = false;
                        quit = true;
                        break;
                    case 2:
                        play = false;
                        quit = true;
                        System.out.println("Вы вышли без сохранения");
                        break;
                    default:
                        System.err.println("Введите 1 или 0");
                        break;
                }
            }
        }
    }

}
