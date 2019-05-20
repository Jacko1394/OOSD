package game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    private static Stage mainStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void setMainStage(Stage stage) {
        mainStage = stage;
    }

    @FXML
    public void onePlayerClicked() throws Exception {



    }

    @FXML
    public void twoPlayerClicked() throws Exception {
        Parent gameView = FXMLLoader.load(getClass().getResource("game.fxml"));
        mainStage.getScene().setRoot(gameView);
    }

    @FXML
    public void exitClicked() {
        mainStage.close();
    }

}
