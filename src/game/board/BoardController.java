package game.board;

import game.board.cell.CellView;
import game.board.product.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private GridPane mainGrid; // ref to fxml (a hardcoded-markup view file)

    private Board board;// = new Board(); // the model

    public void setModel(Board board) {
        this.board = board;
        initialize(null, null);
    }
    public Board getModel() { return board; }
    public GridPane getView() { return mainGrid; }

    public BoardController() {
//        System.out.println("ctorctor");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            if (board == null) {
                return;
            }

            // the more i think about it, the more i believe this loop belongs here in the controller
            // the alternative is to pass the model to the view directly as a parameter
            // the controller should be responsible for reading the model, and initialising the view, which this loop does
            for (int i = 0; i < board.cells.length; i++)
            {
                for (int j = 0; j < board.cells[i].length; j++)
                {

                    if (board.cells[i][j].getIsSet()) {

                        CellView cell = FXMLLoader.load(getClass().getResource("cell/cell.fxml"));
                        if (!board.cells[i][j].isEmpty()) {

                            try {
                                // This for loop is for each of the products that could be in the cell
                                for( Product prod : board.cells[i][j].getProducts() ){
                                    System.out.println(prod.toString());
                                    ImageView img = new ImageView();
                                    var image = new Image(new FileInputStream(prod.imgPath));
                                    img.setImage(image);
                                    GridPane.setRowIndex(img, i);
                                    GridPane.setColumnIndex(img, j);
                                    img.setFitHeight(30);
                                    img.setFitWidth(30);
                                    mainGrid.getChildren().add(img);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {

                            GridPane.setRowIndex(cell, i);
                            GridPane.setColumnIndex(cell, j);

                            // this
                            mainGrid.getChildren().add(cell);
                        }

                    }

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
