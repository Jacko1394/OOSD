package game.board;

import game.board.cell.CellFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardView extends GridPane {

    private BoardController controller = new BoardController();

    public BoardView() throws Exception {

        var board = controller.getBoard();

        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {

                if (board.Cells[i][j].getIsSet()) {

                    var cell = CellFactory.CellView();

                    GridPane.setRowIndex(cell, i);
                    GridPane.setColumnIndex(cell, j);

                    getChildren().add(cell);
                }

            }
        }
    }

    public void updateView(Board board) {
        //todo:
        var b = controller.getBoard();
    }

}
