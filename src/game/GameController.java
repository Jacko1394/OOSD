package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private Game game = new Game();

    @FXML
    private HBox mainView;

    public Game getModel() { return game; }
    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
