package game.board.cell;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CellController implements Initializable {

    @FXML
    private Pane cellPane;

    private Cell cell = new Cell();

    public Cell getCell() { return cell; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
