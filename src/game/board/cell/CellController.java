package game.board.cell;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class CellController implements Initializable {

    @FXML
    private Pane cellPane;
    @FXML
    private Rectangle bg;
    @FXML
    private Rectangle fg;

    private double getThickness() {
        return bg.getHeight() - fg.getHeight();
    };

    private Cell cell = new Cell();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setSize(int x, int y) {
        bg.setWidth(x + getThickness());
        bg.setHeight(y + getThickness());
        fg.setWidth(x);
        fg.setHeight(y);
    }

}
