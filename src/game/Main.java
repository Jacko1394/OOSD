package game;

import game.board.Board;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private GridPane grid;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(new Scene(root, 800, 1000));
        grid = (GridPane)primaryStage.getScene().lookup("#mainGrid");
        primaryStage.show();

        var game = new Game();
        game.startGame();

        var board = Board.Cells;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {

                var rec = (Pane)FXMLLoader.load(getClass().getResource("board/cell/cell.fxml"));

                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);

                try {

//                    if (board[row][col].getIsSet()) {
                        grid.getChildren().add(rec);
//                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
