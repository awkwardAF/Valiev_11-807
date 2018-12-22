import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StartGame sg = new StartGame();
        String choice = sg.login();
        Matrix matrix = sg.begin(choice);
        Game game = new Game(matrix);
        while (game.play) {
            if (game.loggedIn) {
                game.action();
            }
            else {
                choice = sg.login();
                game.loggedIn = true;
                matrix = sg.begin(choice);
            }
        }
    }
}