package game.board.cell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class CellView extends Pane {

    private static Pane cellView;

    private CellController controller = new CellController();

//    private CellView() throws Exception {
//        cellView = (Pane)FXMLLoader.load(getClass().getResource("cell.fxml"));
//    }

//    public static Pane NewCell() throws Exception {
//        var pane = new CellView();
//        return cellView;
//    }
//
//    public static Pane NewCell(int x, int y) throws Exception {
//        var pane = new CellView();
//        pane.controller.setSize(x, y);
//        return cellView;
//    }


}
