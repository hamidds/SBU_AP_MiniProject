package Controller;

import Model.PageLoader;
import Model.library.Book;
import Model.users.Student;
import Model.users.Users;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import sun.rmi.runtime.Log;


public class studentsPanelController implements Initializable {

    @FXML
    public JFXButton libraryButton;
    @FXML
    public JFXButton foodButton;
    @FXML
    public JFXButton classesButton;
    @FXML
    public Label nameLabel;
    @FXML
    public Label creditLabel;
    @FXML
    public Label markLabel;

    private Student obj = (Student) LogedInUser.getLoggedInUser();

    public void libraryEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Library.fxml");
    }

    public void ClassEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/ClassManagement.fxml");
    }

    public void foodSystemEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/FoodSystem.fxml");
    }

    public void bankEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Bank.fxml");
    }

    public void settingEnter(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Setting.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText("Name : " + obj.toString());
        creditLabel.setText("Credit : " + obj.getCredit());
        markLabel.setText("Mark : " + obj.markCalculator());
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/Log-in.fxml");
    }

    public void classList(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/ClassList.fxml");
    }

    public void bookList(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/BookList.fxml");
    }
}
