package game.board;

import com.google.java.contract.Requires;
import game.Game;
import game.board.cell.Cell;
import game.board.cell.CellController;
import game.board.product.Product;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
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

    public static boolean Rolled = false;

    public Board getModel() { return board; }
    public GridPane getView() { return mainGrid; }

    public BoardController() {

    }

    @Requires("game != null")
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

                    var cell = board.cells[i][j];

                    if (cell.getIsSet()) {

                        // load new cell view
                        var loader = new FXMLLoader(view);
                        loader.load();

                        // set its model via controller
                        CellController cellController = loader.getController();
                        cellController.setModel(cell);

                        // add its view to this view
                        var cellView = cellController.getView(); // pane

                        if (cell.HasProducts()) {

                            var prod = cell.getProducts().get(0);
                            addDrag(cellView, prod);

                        }

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

    @Requires("x >= 0 && y >= 0")
    public void clickedCell(Integer x, Integer y) {

        if (Rolled) {
            return;
        }

        var cell = this.board.getCell(x, y);
        Product prod = null;

        if(cell != this.board.getCurrentCell()) {
            this.board.getCurrentCell().setCellColor(Cell.defaultColor);
            RenderCell(this.board.getCurrentCell());
            this.board.updateCurrentCell(cell);
        }

        if (cell.getProducts().size() > 0) { // if has products

            prod = cell.getProducts().get(0);
            this.board.setCurrentProduct(prod);

            if (prod.getProductTeam().getTeamID().equals(currentGame.getCurrentTeam().getTeamID())) {
                cell.setCellColor(Cell.selectColor);
            }

        }

        if (prod != null) { // to follow pre-condition
            RenderCell(cell);
        }

        // For debugging
        //info.setText("Cell x:"+x+" y:"+y+" color:"+cell.getCellColor()+"\n"+"Product "+this.board.getCurrentProduct());
        //initialize(null, null); // re-render shortcut
    }

    @Requires("cell != null")
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
            addDrag(cellView, cellController.getModel().getProducts().get(0));
            mainGrid.add(cellView, y, x);
        } catch (Exception ex) {
            // empty cell
        }
    }

    private void addDrag(Pane view, Product prod) {
        view.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                try {
                    if (!Rolled) {
                        return;
                    }
                    /* drag was detected, start a drag-and-drop gesture*/
                    /* allow any transfer mode */
                    Dragboard db = view.startDragAndDrop(TransferMode.ANY);

                    /* Put a string on a dragboard */
                    ClipboardContent content = new ClipboardContent();
                    var image = new Image(new FileInputStream(prod.imgPath));
                    content.putImage(image);
                    db.setContent(content);

                    event.consume();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
