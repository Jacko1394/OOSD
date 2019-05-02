package game;

import game.board.BoardController;

import game.board.cell.Cell;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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

    private static BoardController boardController;

//    public Game getModel() { return game; }
//    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            game.startGame(); // this should be in ctor of Game

            var loader = new FXMLLoader(getClass().getResource("board/board.fxml"));
            GridPane board = loader.load();

            boardController = loader.getController();
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

    @FXML
    public void rollClicked() {

        try {
            var board = game.getBoard();

            //todo: is this needed? DBC ::: game won't let user select piece if not his team's
            if (board.getCurrentProduct().getTeam() != game.getCurrentTeam()) {
                return;
            }

            button.setDisable(true);

            var product = board.getCurrentProduct();
            var rolled = product.getDice().roll();
            diceNumber.setText("" + rolled);

            for (var i = rolled; i > 0; i--) {
                var newCell = game.getBoard().movePiece(product, board.getCurrentCell().getDirections()[0]);
                board.setCurrentCell(newCell);
            }
            boardController.initialize(null, null);
            currentTurnLabel.setText("Current team: " + game.nextTeam());

            button.setDisable(false);

        } catch (Exception ex) {
            //
        }

    }

}
