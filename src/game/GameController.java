package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public static Game game = new Game();

    @FXML
    private VBox mainView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
