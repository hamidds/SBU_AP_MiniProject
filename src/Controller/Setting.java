package Controller;

import Model.PageLoader;
import Model.users.Professor;
import Model.users.Student;
import Model.users.Users;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class Setting {

    @FXML
    public TextField newUsername, newVisiblePass, verifyVisiblePass;
    @FXML
    public PasswordField newPass, verifyPass;
    @FXML
    public JFXButton passButton, usernameButton;
    @FXML
    public ToggleButton showPassword;


    public void changeUsername(ActionEvent actionEvent) {
        LogedInUser.getLoggedInUser().setUserName(newUsername.getText());
    }

    public void ChangePassword(ActionEvent actionEvent) {
        if (newPass.getText().equals(verifyPass.getText()) || (newVisiblePass.getText().equals(verifyVisiblePass.getText()))) {
            if (newPass.getText().length() > 5) {
                LogedInUser.getLoggedInUser().setPassword(newPass.getText());
            } else {
                Alert invalidPass = new Alert(Alert.AlertType.INFORMATION, "Your Password should be at least 6 characters!" );
                invalidPass.showAndWait();
            }
        } else {
            Alert invalidPass = new Alert(Alert.AlertType.INFORMATION, "Please check your password!" );
            invalidPass.showAndWait();
        }
    }

    public void showPassword(ActionEvent actionEvent) {
        if (showPassword.isSelected()) {
            newVisiblePass.setText(newPass.getText());
            newVisiblePass.setVisible(true);
            newPass.setVisible(false);
            verifyVisiblePass.setText(verifyPass.getText());
            verifyVisiblePass.setVisible(true);
            verifyPass.setVisible(false);
        } else {
            newPass.setText(newVisiblePass.getText());
            newPass.setVisible(true);
            newVisiblePass.setVisible(false);
            verifyPass.setText(verifyVisiblePass.getText());
            verifyPass.setVisible(true);
            verifyVisiblePass.setVisible(false);
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        if (LogedInUser.getLoggedInUser() instanceof Student)
            new PageLoader().Load("../View/students-panel.fxml");
        else if (LogedInUser.getLoggedInUser() instanceof Professor)
            new PageLoader().Load("../View/professors-panel.fxml");
        else
            new PageLoader().Load("../View/admin-panel.fxml");
    }
}
