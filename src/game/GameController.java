package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController extends Application {

    public static Game game = new Game();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // game start
        game.startGame();

        // init main view
        Parent root = FXMLLoader.load(getClass().getResource("board/board.fxml"));
        var scene = new Scene(root, 800, 1000);
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
