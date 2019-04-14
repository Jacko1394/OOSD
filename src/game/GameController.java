package game;

import game.board.BoardController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    @FXML
    private VBox teamsView;
    @FXML
    private Label currentTurnLabel;
    @FXML
    private Button button;

//    public Game getModel() { return game; }
//    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            game.startGame(); // this should be in ctor of Game

            var loader = new FXMLLoader(getClass().getResource("board/board.fxml"));
            GridPane board = loader.load();

            BoardController boardController = loader.getController();
            boardController.setCurrentGame(game);

            boardVbox.getChildren().add(board);

            // add team controls:
            var count = 1;
            for (var t : game.getListOfTeams()) {

                Label labelView = FXMLLoader.load(getClass().getResource("bigLabel.fxml"));
                labelView.setText("Team " + count++ + " - " + t);
                teamsView.getChildren().add(labelView);

            }

            currentTurnLabel.setText("Current turn: " + game.getCurrentTeam());


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    private void runGame() {
//
//        var gameover = false;
//
//        while (!gameover) {
//            // current Team
//        }
//
//    }

    @FXML
    public void rollClicked() {

        var board = game.getBoard();

        if (board.getCurrentProduct().getTeam() != game.getCurrentTeam()) {
            return;
        }

        button.setDisable(true);

        var product = game.getBoard().getCurrentProduct();
        var rolled = product.getDice().roll();
        diceNumber.setText("" + rolled);

        // For debugging
        //info.setText("Current Team:"+game.getCurrentTeam()+" \n Product Team:"+product.getTeam() +"\n Current Product:"+product.getID()+"\n Dice Loaded:"+product.getDice().getConf());

        //TODO move the product
//        for (var i = rolled; i > 0; i--) {
//
//        }

        var piece = board.getCurrentProduct();
        game.getBoard().movePiece(piece, board.getCurrentCell().getDirections()[0]);


        //TODO change teams
        currentTurnLabel.setText("Current team: " + game.nextTeam());

    }

}
