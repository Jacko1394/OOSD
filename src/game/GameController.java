package game;

import game.board.Board;
import game.board.BoardController;

import game.board.cell.Cell;
import game.board.product.Product;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.input.DragEvent;
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

    public static Cell[][] RollChoice;

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

//    @FXML
//    private Label info;

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
        System.out.println("Starting roll");

//        if (BoardController.Rolled) {
//            return;
//        }

        try {
            var board = game.getBoard();
            var product = board.getCurrentProduct();

            //todo: is this needed? DBC ::: game won't let user select piece if not his team's
            if (!product.getProductTeam().getTeamID().equalsIgnoreCase(game.getCurrentTeam().getTeamID())) {
                return;
            }

            var rolled = product.getDice().roll();
            diceNumber.setText("" + rolled);

            //todo: rm static
            RollChoice = board.search(product.getPositionX(), product.getPositionY(), rolled);
            BoardController.Rolled = true;

//            for (var list : RollChoice) {
//                var c = list[list.length - 1]; // landing cell
//                c.setCellColor("salmon");
//                boardController.RenderCell(c); // doesn't work because cell doesnt know position...
//            }
            this.movePeice(rolled + 1, product);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void movePeice(int rolled, Product product) {
        var board = game.getBoard();
        button.setDisable(true);
        Cell[][] paths = board.search(product.getPositionX(), product.getPositionY(), rolled);
        System.out.println("Number of paths: " + paths.length + " | Dice:" + rolled);

        if ( paths.length == 1 ) {
            board.movePiece(product, paths[0][rolled - 1]);
        } else {
            var rand = new Random();
            board.setChoiceState(paths);
            int choice = rand.nextInt(paths.length);
            System.out.println("Moving piece to path: " + choice);
            board.movePiece(product, paths[choice][rolled]);
            //TODO update board state to wait for user input
        }


        boardController.initialize(null, null);
        currentTurnLabel.setText("Current team: " + game.nextTeam());

        button.setDisable(false);
    }

    @FXML
    public void powerupClicked() {
        System.out.println("Starting roll");
        var board = game.getBoard();
        var product = board.getCurrentProduct();
        product.powerUp();

        try {

            //todo: is this needed? DBC ::: game won't let user select piece if not his team's
            if (!board.getCurrentProduct().getProductTeam().getTeamID().equalsIgnoreCase(game.getCurrentTeam().getTeamID())) {
                return;
            }

            button.setDisable(true);

            var rolled = product.getDice().roll();
            diceNumber.setText("" + rolled);

            this.movePeice(rolled,product);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            product.powerDown();
        }

        System.out.println("POWER");
    }

}
