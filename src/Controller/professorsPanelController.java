package Controller;

import Model.PageLoader;
import Model.users.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class professorsPanelController implements Initializable {
    @FXML
    public Label nameLabel;
    @FXML
    public Label creditLabel;
    @FXML
    public Label markLabel;
    Professor obj = (Professor) LogedInUser.getLoggedInUser();

    public void settingEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Setting.fxml");
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Log-in.fxml");
    }

    public void ClassSettingsEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/ClassSettings.fxml");
    }

    public void Grades(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/GradesList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText("Name : " + obj.toString());
    }
}
