package game.board;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import game.GameController;

public class BoardController {

    @FXML
    private GridPane mainGrid; // ref to fxml (a hardcoded-markup view file)
    public static Board board = new Board();

    @FXML
    public void initialize() throws Exception {

        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {
                var cell = (Pane) FXMLLoader.load(getClass().getResource("cell/cell.fxml"));

                GridPane.setRowIndex(cell, i);
                GridPane.setColumnIndex(cell, j);

                if (board.Cells[i][j].getIsSet()) {
                    mainGrid.getChildren().add(cell);
                }

            }
        }

    }

}
