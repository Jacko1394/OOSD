package game;

import game.board.BoardController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    // main model
    private Game game = new Game();

    @FXML
    private HBox mainView;

    @FXML
    private VBox boardVbox;
    @FXML
    private HBox diceView;

    @FXML
    private Label diceNumber;

    @FXML
    private Label info;

    @FXML
    private VBox controlView;

    public Game getModel() { return game; }
    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            game.startGame(); // this should be in ctor of Game

            var loader = new FXMLLoader(getClass().getResource("board/board.fxml"));
            GridPane board = loader.load();

            var boardController = (BoardController)loader.getController();
            boardController.setModel(game.getBoard());

            boardVbox.getChildren().add(board);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void rollClicked() {
        var product = game.getBoard().getCurrentProduct();
        var rolled = product.getDice().roll();
        diceNumber.setText("" + rolled);

        // For debugging
        //info.setText("Current Team:"+game.getCurrentTeam()+" \n Product Team:"+product.getTeam() +"\n Current Product:"+product.getID()+"\n Dice Loaded:"+product.getDice().getConf());

        //TODO move the product



        //TODO change teams
    }

}
