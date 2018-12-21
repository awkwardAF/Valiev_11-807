import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StartGame sg = new StartGame();
        String choice = sg.login();
        Matrix matrix = sg.begin(choice);
        Game game = new Game(matrix);
        while (game.play) {
            game.action();
        }
    }
}
