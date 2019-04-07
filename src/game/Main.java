package game;

import game.board.Board;
import game.board.cell.Cell;
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

        var board = new Board();

//        for (int i = 0; i < board.Cells.length - 1; i++)
//        {
//            for (int j = 0; j < board.Cells[i].length - 1; j++)
//            {
//                System.out.println(String.format("Configuring Cell[%d][%d] with conf %s ", i, j, conf[i][j]));
//                Cells[i][j] = new Cell();
//                Cells[i][j].setDirections(conf[i][j]);
//            }
//        }

//        for (var c : board.Cells) {
//            for (var c2 : c) {
//                try {
//                    System.out.println(c2.getIsSet());
//                } catch (Exception e) {
//
//                }
//            }
//        }
//
        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {

                var rec = (Pane)FXMLLoader.load(getClass().getResource("board/cell/cell.fxml"));

                GridPane.setRowIndex(rec, i);
                GridPane.setColumnIndex(rec, j);

                try {

                    if (board.Cells[i][j].getIsSet()) {
                        grid.getChildren().add(rec);
//                        System.out.println("YES");
                    }
                } catch (Exception e) {
//                    System.out.println(e.toString());
                }

            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
