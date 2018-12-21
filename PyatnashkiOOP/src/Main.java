import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StartGame sg = new StartGame();
        Matrix matrix = sg.begin();
        Game game = new Game(matrix);
        while (game.play) {
            game.action();
        }
    }
}
