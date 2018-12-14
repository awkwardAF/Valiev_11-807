
import java.io.IOException;

public class Main {

    public static boolean play = true;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
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