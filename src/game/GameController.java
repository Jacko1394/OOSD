package game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController extends Application {

    public static Game game = new Game();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // init main view
        Parent root = FXMLLoader.load(getClass().getResource("board/board.fxml"));
        var scene = new Scene(root, 800, 1000);
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(scene);
        primaryStage.show();

        // game start
        game.startGame();

    }

    @FXML
    public void initialize() throws Exception {
        
        Game game = new Game();
        game.startGame();

        for (int i = 0; i < game.getBoard().Cells.length; i++)
        {
            for (int j = 0; j < game.getBoard().Cells[i].length; j++)
            {
                var rec = (Pane) FXMLLoader.load(getClass().getResource("cell/cell.fxml"));

                GridPane.setRowIndex(rec, i);
                GridPane.setColumnIndex(rec, j);

                try {

                    if (game.getBoard().Cells[i][j].getIsSet()) {
                        mainGrid.getChildren().add(rec);
//                        System.out.println("YES");
                    }
                } catch (Exception e) {
//                    System.out.println(e.toString());
                }

            }
        }
    }

    public static void main(String[] args) { launch(args); }

}
