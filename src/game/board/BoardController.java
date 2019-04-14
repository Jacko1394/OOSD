package game.board;

import game.board.cell.CellController;
import game.board.product.Product;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private GridPane mainGrid; // ref to fxml (a hardcoded-markup view file)

    private Board board;// copy of current the model

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

            var view = getClass().getResource("cell/cell.fxml");

            // the more i think about it, the more i believe this loop belongs here in the controller
            // the alternative is to pass the model to the view directly as a parameter
            // the controller should be responsible for reading the model, and initialising the view, which this loop does
            for (int i = 0; i < board.cells.length; i++) {

                for (int j = 0; j < board.cells[i].length; j++) {

                    if (board.cells[i][j].getIsSet()) {

                        // load new cell view
                        var loader = new FXMLLoader(view);
                        loader.load();

                        // set its model via controller
                        var cellController = (CellController)loader.getController();
                        cellController.setModel(board.cells[i][j]);

                        // add its view to this view
                        var cellView = cellController.getView();
                        GridPane.setRowIndex(cellView, i);
                        GridPane.setColumnIndex(cellView, j);
                        mainGrid.getChildren().add(cellView);

                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

}
