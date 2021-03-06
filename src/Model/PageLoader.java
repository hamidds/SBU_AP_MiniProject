package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLoader {
    private static final int WIDTH = 977;
    private static final int HEIGHT = 577;
    private static Stage stage;

    public static void initStage(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("Log in");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
    }
    public void Load(String url) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();
    }
}
