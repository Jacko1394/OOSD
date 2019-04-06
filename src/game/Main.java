package game;

import game.board.Board;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private GridPane grid;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(new Scene(root, 500, 500));
        grid = (GridPane)primaryStage.getScene().lookup("#mainGrid");
        primaryStage.show();

        var board = Board.Cells;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
//                int n = rand.nextInt(4);
                Rectangle rec = new Rectangle();
                rec.setWidth(24);
                rec.setHeight(24);
                rec.setFill(Color.color(0.5,0.5,0.5));
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
