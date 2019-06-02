package game.board.cell;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class CellController implements Initializable {

    @FXML
    private Pane cellPane;
    @FXML
    private Rectangle bg;
    @FXML
    private Rectangle fg;
    @FXML
    private Pane arrows;

    private Image arrowImg;
    private Cell cell;

    public Cell getModel() {
        return cell;
    }

    public Pane getView() {

        try {
            // This for loop is for each of the products that could be in the cell

            for (var prod : cell.getProducts()) {
                ImageView img = new ImageView();
                var image = new Image(new FileInputStream(prod.imgPath));
                img.setImage(image);
                img.setFitHeight(48);
                img.setFitWidth(48);
                cellPane.getChildren().add(img);
                // hide arrow if piece in cell:
                arrows.setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cellPane;
    }

    public void setModel(Cell cell) {

        this.cell = cell;

        // draw arrow:
        if (cell.getIsSet()) {

            var dir = cell.getDirections();

            for (var d : dir) { // u d l r

                if (d == 'u') {
                    var i = new ImageView(arrowImg);
                    i.setRotate(270);
                    arrows.getChildren().add(i);
                }
                if (d == 'r') {
                    arrows.getChildren().add(new ImageView(arrowImg));
                }
                if (d == 'd') {
                    var i = new ImageView(arrowImg);
                    i.setRotate(90);
                    arrows.getChildren().add(i);
                }
                if (d == 'l') {
                    var i = new ImageView(arrowImg);
                    i.setRotate(180);
                    arrows.getChildren().add(i);
                }
            }

            //set color:
            fg.setFill(Paint.valueOf(cell.getCellColor()));

        }

    }

    public CellController() {
        try {
            arrowImg = new Image(new FileInputStream("src/logosml/arrow-right.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void clickCell(MouseEvent event) {

    }

}
