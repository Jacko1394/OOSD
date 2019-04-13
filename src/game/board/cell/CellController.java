package game.board.cell;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
                fg.setFill(Paint.valueOf("red"));
            }


        };

//        scene.addEventFilter(eventHandler);

        cellPane.setOnMouseClicked(eventHandler);
    }

    public void setSize(int x, int y) {
        bg.setWidth(x + getThickness());
        bg.setHeight(y + getThickness());
        fg.setWidth(x);
        fg.setHeight(y);
    }

}
