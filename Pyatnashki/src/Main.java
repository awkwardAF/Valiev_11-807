import java.io.IOException;

public class Main {

    public static boolean play = true;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        System.out.println("\"type\" - enter new game by yourself,");
        System.out.println("\"exit\" - save and exit the game");
        System.out.println("\"undo\" - moves \"0\" to previous position");
        System.out.println("or enter coordinates to move Zero");
        Matrix.readFile(4, 4);
        Matrix.vivod();
        while (play) {
            Matrix.shift();
            Matrix.check();
        }
        Matrix.vivod();
        Matrix.writeFile();
        }
    }