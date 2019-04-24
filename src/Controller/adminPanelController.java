package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminPanelController implements Initializable {
    @FXML
    public Label nameLabel;

    public void library(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/LibrarySettings.fxml");
    }

    public void lists(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/UsersList.fxml");
    }

    public void food(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/FoodSettings.fxml");
    }

    public void setting(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Setting.fxml");
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/log-in.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText("Name : Hamidreza Saffari");
    }
}
