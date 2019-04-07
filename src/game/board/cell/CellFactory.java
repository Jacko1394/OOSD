package game.board.cell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CellFactory {

    private static Pane cellView;

    private CellFactory() throws Exception {
        cellView = FXMLLoader.load(getClass().getResource("cell.fxml"));
    }

    public static Pane CellView() throws Exception {
        var c = new CellFactory();
        return cellView;
    }

}
