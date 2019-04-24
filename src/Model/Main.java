package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

        private static final int HEIGHT = 500;
        private static final int WIDTH = 375;

    @Override
    public void start(Stage primaryStage) throws Exception{
        PageLoader.initStage(primaryStage);
        new PageLoader().Load("../View/Log-in.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
