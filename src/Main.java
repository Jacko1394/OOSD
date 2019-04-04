package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        var list = root.getChildrenUnmodifiable();

        System.out.println(list);

    }

    public static void main(String[] args) {
        launch(args);
    }

 
    
    
}