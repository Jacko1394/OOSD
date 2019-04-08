package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController implements Initializable {

    private Game game = new Game();

    @FXML
    private HBox mainView;
    @FXML
    private ImageView img;

    public Game getModel() { return game; }
    public HBox getView() { return mainView; }

    public GameController() throws Exception {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));


//        img = new ImageView(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            var image = new Image(new FileInputStream("src/logos/macOS.png"));
            img.setImage(image);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

}
