package game.board;

import game.Game;
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
    private Game currentGame; // reference to raise events

//    public void setModel(Board board) {
//
//    }

    public Board getModel() { return board; }
    public GridPane getView() { return mainGrid; }

    public BoardController() {

    }

    public void setCurrentGame(Game game) {
        this.currentGame = game;
        this.board = game.getBoard();
        initialize(null, null);
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
                        CellController cellController = loader.getController();
                        cellController.setModel(board.cells[i][j]);

                        // add its view to this view
                        var cellView = cellController.getView();
//                        mainGrid.setRowIndex(cellView, i);
//                        mainGrid.setColumnIndex(cellView, j);
//                        mainGrid.getChildren().add(cellView);
                        mainGrid.add(cellView, j, i);

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
            clickedCell(rowIndex, colIndex);

        }

    }

    public void clickedCell(Integer x , Integer y) {

        // PRE: integer Values are valid board positions

        var cell = this.board.getCell(x,y);
        Product prod = null;

        if(cell != this.board.getCurrentCell()) {
            this.board.getCurrentCell().setCellColor(Cell.defaultColor);
            RenderCell(this.board.getCurrentCell());
            this.board.updateCurrentCell(cell);
        }

        if (cell.getProducts().size() > 0){

            prod = cell.getProducts().get(0);
            this.board.setCurrentProduct(prod);

            if (prod.getTeam().equals(currentGame.getCurrentTeam())) {
                cell.setCellColor(Cell.selectColor);
            }

        }

        if (prod != null) {
            RenderCell(cell);
        }

        // For debugging
        //info.setText("Cell x:"+x+" y:"+y+" color:"+cell.getCellColor()+"\n"+"Product "+this.board.getCurrentProduct());
        //initialize(null, null); // re-render shortcut
    }

    public void RenderCell (Cell cell) {
        try {
            var prod = cell.getProducts().get(0); // default for now
            var x = prod.getPositionX();
            var y = prod.getPositionY();

            var view = getClass().getResource("cell/cell.fxml");
            // load new cell view
            var loader = new FXMLLoader(view);
            loader.load();

            // set its model via controller
            CellController cellController = loader.getController();
            cellController.setModel(cell);

            // add its view to this view
            var cellView = cellController.getView();
            mainGrid.add(cellView, y, x);
        } catch (Exception ex) {
            // empty cell
        }
    }

}
