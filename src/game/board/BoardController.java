package game.board;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private BoardView mainGrid; // ref to fxml (a hardcoded-markup view file)

    private Board board = new Board(); // the model

    public Board getBoard() { return board; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
