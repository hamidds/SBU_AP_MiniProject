package Controller;

import Model.PageLoader;
import Model.users.Student;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Bank {
    @FXML
    JFXTextField cardNumber, password, price, card, cardPassword;
    Student obj = (Student) LogedInUser.getLoggedInUser();

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }

    public void add(ActionEvent actionEvent) {
        if (cardNumber.getText() != null && cardPassword.getText() != null) {
            obj.setCardNumber(cardNumber.getText());
            obj.setCardPassword(cardPassword.getText());
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "added Successfully!");
            userNotFound.showAndWait();
        } else {
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "Please fill the fields!");
            userNotFound.showAndWait();
        }
    }

    public void increase(ActionEvent actionEvent) {
        if (card.getText().equals(obj.getCardNumber()) && password.getText().equals(obj.getCardPassword())) {
            obj.setCredit(Integer.parseInt(price.getText()));
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "Charged Successfully!");
            userNotFound.showAndWait();
        } else {
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "Please try again!");
            userNotFound.showAndWait();
        }
    }
}
