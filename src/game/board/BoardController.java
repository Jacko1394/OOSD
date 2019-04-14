package game.board;

import game.board.cell.Cell;
import game.board.cell.CellController;
import game.board.product.Product;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

    @FXML
    private Label info;

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
//                        mainGrid.setRowIndex(cellView, i);
//                        mainGrid.setColumnIndex(cellView, j);
//                        mainGrid.getChildren().add(cellView);
                        mainGrid.add(cellView,j,i);

                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }


    public void clickGrid(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != mainGrid) {
            // click on descendant node
            Node parent = clickedNode.getParent();
            while (parent != mainGrid) {
                clickedNode = parent;
                parent = clickedNode.getParent();
            }
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            //System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
            clickedCell(colIndex,rowIndex);

        }

    }

    public void clickedCell(Integer x , Integer y) {
        var cell = this.board.getCell(x,y);
        if( cell == this.board.getCurrentCell() ) {
            // this is for the times when there are more than one product in a cell
            //System.out.println("Updating cell item");
            this.board.updateCurrentCellItem(cell);
        } else {
            this.board.getCurrentCell().setCellColor(Cell.defaultColor);
            this.board.setCurrentCell(cell);
            cell.setCellColor("red");

        }
        if ( cell.getProducts().size() > 0 ){
            this.board.setCurrentProduct(cell.getProducts().get(this.board.getCurrentCellItem()));
        }


        // For debugging
        //info.setText("Cell x:"+x+" y:"+y+" color:"+cell.getCellColor()+"\n"+"Product "+this.board.getCurrentProduct());

    }

}
