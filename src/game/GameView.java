package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameView extends Application {

    private GameController controller = new GameController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // init main view
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        var scene = new Scene(root, 1000, 1000);
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
