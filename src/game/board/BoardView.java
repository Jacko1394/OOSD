package game.board;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardView extends GridPane {

    private BoardController controller = new BoardController();

    public BoardView() throws Exception {

        var board = controller.board;

        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {
                var cell = (Pane) FXMLLoader.load(getClass().getResource("cell/cell.fxml"));

                GridPane.setRowIndex(cell, i);
                GridPane.setColumnIndex(cell, j);

                if (board.Cells[i][j].getIsSet()) {
                    getChildren().add(cell);
                }

            }
        }
    }

    public void updateView(Board board) {
        //todo:
        controller.board = board;
    }

}
