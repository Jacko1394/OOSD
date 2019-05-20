import game.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        var menu = getClass().getResource("game/startMenu.fxml");
        var loader = new FXMLLoader(menu);
        Parent menuView = loader.load();

        MenuController menuCont = loader.getController();
        menuCont.setMainStage(primaryStage);

        var scene = new Scene(menuView, 1800, 1000);
        primaryStage.setTitle("Boom Sum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
