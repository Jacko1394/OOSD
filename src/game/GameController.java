package game;

import game.board.BoardController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GameController implements Initializable {

    private Game game = new Game();

    @FXML
    private HBox mainView;
    @FXML
    private ImageView img;
    @FXML
    private VBox vbox;

    public Game getModel() { return game; }
    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            game.startGame(); // this should be in ctor of Game
            var loader = new FXMLLoader(getClass().getResource("board/board.fxml"));
            var board = (GridPane)loader.load();
            vbox.getChildren().add(board);
            var bCont = (BoardController)loader.getController();

            bCont.setModel(game.getBoard());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
