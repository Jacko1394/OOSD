package game.board;

import game.board.cell.CellView;
import game.board.cell.product.Product;
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
                    if (board.Cells[i][j].isEmpty() == false ) {

                        System.out.println(board.Cells[i][j].getProducts());
//                        cell.getController().setImg(board.Cells[i][j].getProduct().imgPath);
                        try {
                            // This for loop is for each of the products that could be in the cell
                            for( Product prod : board.Cells[i][j].getProducts() ){
                                ImageView img = new ImageView();
                                var image = new Image(new FileInputStream(prod.imgPath));
                                img.setImage(image);
                                GridPane.setRowIndex(img, i);
                                GridPane.setColumnIndex(img, j);
                                img.setFitHeight(20);
                                img.setFitWidth(20);
                                getChildren().add(img);

                            }
                            continue;
                        } catch (Exception ex) {
                            ex.printStackTrace();
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
