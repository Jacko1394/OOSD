package game.board;

import game.board.cell.CellView;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;

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
                    ImageView img = new ImageView();
                    if (board.Cells[i][j].getProduct() != null) {

                        System.out.println(board.Cells[i][j].getProduct());
//                        cell.getController().setImg(board.Cells[i][j].getProduct().imgPath);
                        try {
                            var image = new Image(new FileInputStream(board.Cells[i][j].getProduct().imgPath));
                            img.setImage(image);
                            GridPane.setRowIndex(img, i);
                            GridPane.setColumnIndex(img, j);
                            img.setFitHeight(40);
                            img.setFitWidth(40);
                            getChildren().add(img);
                            continue;
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
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
