package game.board;

import game.board.cell.CellView;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {

    private BoardController controller = new BoardController();

    public BoardView() throws Exception {

        var board = controller.getModel();

        for (int i = 0; i < board.Cells.length; i++)
        {
            for (int j = 0; j < board.Cells[i].length; j++)
            {

                if (board.Cells[i][j].getIsSet()) {

                    var cell = CellView.NewCell();

                    GridPane.setRowIndex(cell, i);
                    GridPane.setColumnIndex(cell, j);

                    // this
                    getChildren().add(cell);
                }

            }
        }
    }

    public void updateView(Board board) {
        //todo:
        var b = controller.getModel();
    }

}
