package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // init main view
        Parent gameView = FXMLLoader.load(getClass().getResource("game.fxml"));
        var scene = new Scene(gameView, 1200, 700);
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
