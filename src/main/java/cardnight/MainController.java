package cardnight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/cardnight/images/Taskbar-Icon.png")));

        Main.mainStage = stage;

        loadViews();

        Scene mainScene = new Scene(ScreenController.getScreen("main-menu-view"));
        PerspectiveCamera cam = new PerspectiveCamera();
        mainScene.setCamera(cam);
        mainScene.getStylesheets().add(getClass().getResource("/cardnight/styles/background-gradient.css").toExternalForm());
        ScreenController.setScene(mainScene);

        stage.setScene(mainScene);
        stage.setTitle("Card Night");
        stage.show();
    }

    private void loadViews() throws IOException {
        ScreenController.addScreen("main-menu-view", new FXMLLoader(getClass().getResource("main-menu-view.fxml")).load());
        ScreenController.addScreen("pause-menu", new FXMLLoader(getClass().getResource("pause-menu.fxml")).load());
    }
}
