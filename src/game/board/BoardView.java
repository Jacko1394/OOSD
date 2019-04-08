package game.board;

import game.board.cell.CellView;
import javafx.fxml.FXMLLoader;
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

                    CellView cell = FXMLLoader.load(getClass().getResource("cell/cell.fxml"));

                    if (board.Cells[i][j].getProduct() != null) {
//                        System.out.println(board.Cells[i][j].getProduct());
//                        cell.getController().setImg(board.Cells[i][j].getProduct().imgPath);
                    }

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
