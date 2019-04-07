package game.board;

import game.Game;
import game.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardController {

    @FXML
    private GridPane mainGrid;

    @FXML
    public void initialize() throws Exception {

        var board = Game.board;

        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {
                var rec = (Pane) FXMLLoader.load(getClass().getResource("cell/cell.fxml"));

                GridPane.setRowIndex(rec, i);
                GridPane.setColumnIndex(rec, j);

                try {

                    if (board.Cells[i][j].getIsSet()) {
                        mainGrid.getChildren().add(rec);
//                        System.out.println("YES");
                    }
                } catch (Exception e) {
//                    System.out.println(e.toString());
                }

            }
        }
    }

}
