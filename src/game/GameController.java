package game;

import game.board.BoardController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private VBox controlView;
    @FXML
    private VBox teamsView;
    @FXML
    private Label currentTurnLabel;

//    public Game getModel() { return game; }
//    public HBox getView() { return mainView; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            game.startGame(); // this should be in ctor of Game

            var loader = new FXMLLoader(getClass().getResource("board/board.fxml"));
            GridPane board = loader.load();

            var boardController = (BoardController)loader.getController();
            boardController.setModel(game.getBoard());

            boardVbox.getChildren().add(board);

            // add team controls:
            var count = 1;
            for (var t : game.getListOfTeams()) {

                var labelView = (Label)FXMLLoader.load(getClass().getResource("bigLabel.fxml"));
                labelView.setText("Team " + count++ + " - " + t);
                teamsView.getChildren().add(labelView);

            }

            // add gap
            controlView.getChildren().add(new Pane());

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
        var r = new Random();
        diceNumber.setText("" + r.nextInt(9));
    }

}
