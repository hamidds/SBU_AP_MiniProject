package Controller;

import Model.PageLoader;
import Model.users.Professor;
import Model.users.Student;
import Model.users.Users;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class LoginController implements Initializable {
    @FXML
    public JFXButton enterBtn, accButton;
    @FXML
    public TextField username, visiblePassword;
    @FXML
    public TextField password;
    @FXML
    public Label wrongPassword;
    @FXML
    public ToggleButton showPassword;
    @FXML
    public RadioButton studentRadioButton, professorRadioButton, adminRadioButton, studentRadioButton1, professorRadioButton1;
    @FXML
    public TextField signupUsername, firstname, lastname;
    @FXML
    public PasswordField signupConfirm, signupPassword;
    @FXML
    public AnchorPane SignUp, logIn;


    public void enter(ActionEvent actionEvent) throws IOException, InterruptedException {
        if (!(studentRadioButton.isSelected() || professorRadioButton.isSelected() || adminRadioButton.isSelected())) {
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "Please Select!");
            userNotFound.showAndWait();
        }
        if (studentRadioButton.isSelected()) {
            Users search = studentsSearch(username.getText());
            if (search == null) {
                Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "User Not Found!");
                userNotFound.showAndWait();
                return;
            }
            if ((password.getText().equals(search.getPassword()) || visiblePassword.getText().equals(search.getPassword()))) {
                Alert welcome = new Alert(Alert.AlertType.INFORMATION, "Welcome" + " " + search.toString());
                welcome.showAndWait();
                new PageLoader().Load("../View/students-panel.fxml");
            } else {
                wrongPassword.setVisible(true);
            }
        } else if (professorRadioButton.isSelected()) {
            Users search = professorsSearch(username.getText());
            if (search == null) {
                Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "User Not Found!");
                userNotFound.showAndWait();
                return;
            }
            if ((password.getText().equals(search.getPassword()) || visiblePassword.getText().equals(search.getPassword()))) {
                Alert welcome = new Alert(Alert.AlertType.INFORMATION, "Welcome" + " " + search.toString());
                welcome.showAndWait();
                new PageLoader().Load("../View/professors-panel.fxml");
            } else {
                wrongPassword.setVisible(true);
            }
        } else if (adminRadioButton.isSelected()) {
            if (username.getText().equals("hamid") && (password.getText().equals("123456") || visiblePassword.getText().equals("123456"))) {
                new PageLoader().Load("../View/admin-panel.fxml");
            } else if (username.getText().equals("hamid") && !password.getText().equals("123456")) {
                wrongPassword.setVisible(true);
            }
        }
    }

    private Users studentsSearch(String username) {
        if (Student.ALL_STUDENTS.size() == 0)
            return null;
        Student concernStudent = new Student(username);
        if (Student.ALL_STUDENTS.contains(concernStudent)) {
            LogedInUser.setLoggedInUser(Student.ALL_STUDENTS.get(Student.ALL_STUDENTS.indexOf(concernStudent)));
            return Student.ALL_STUDENTS.get(Student.ALL_STUDENTS.indexOf(concernStudent));
        }
        return null;
    }

    private Users professorsSearch(String username) {
        if (Professor.ALL_PROFESSORS.size() == 0)
            return null;
        Professor concernProfessor = new Professor(username);
        if (Professor.ALL_PROFESSORS.contains(concernProfessor)) {
            LogedInUser.setLoggedInUser(Professor.ALL_PROFESSORS.get(Professor.ALL_PROFESSORS.indexOf(concernProfessor)));
            return Professor.ALL_PROFESSORS.get(Professor.ALL_PROFESSORS.indexOf(concernProfessor));
        }
        return null;
    }

    public void showPassword(ActionEvent actionEvent) {
        if (showPassword.isSelected()) {
            visiblePassword.setText(password.getText());
            visiblePassword.setVisible(true);
            password.setVisible(false);
        } else {
            password.setText(visiblePassword.getText());
            password.setVisible(true);
            visiblePassword.setVisible(false);
        }
    }

    public void signUp(ActionEvent actionEvent) {
        if (!(studentRadioButton1.isSelected() || professorRadioButton1.isSelected())) {
            Alert select = new Alert(Alert.AlertType.INFORMATION, "Please Select!");
            select.showAndWait();
        }
        if (studentRadioButton1.isSelected()) {
            Users search = studentsSearch(signupUsername.getText());
            if (search != null) {
                Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "This username is already taken!");
                userNotFound.showAndWait();
                return ;
            }
            if (signupPassword.getText().equals(signupConfirm.getText())) {
                if (signupPassword.getText().length() < 6) {
                    Alert invalidPass = new Alert(Alert.AlertType.INFORMATION, "Your Password should be at least 6 characters!");
                    invalidPass.showAndWait();
                } else {
                    Student newStudent = new Student(signupUsername.getText());
                    newStudent.setPassword(signupPassword.getText());
                    newStudent.setFirstName(firstname.getText());
                    newStudent.setLastName(lastname.getText());
                    Student.ALL_STUDENTS.add(newStudent);
                    logIn.setOpacity(1);
                    Alert signupAlert = new Alert(Alert.AlertType.INFORMATION, "SignUp Successfully!");
                    signupAlert.showAndWait();
                }
            } else {
                Alert checkPass = new Alert(Alert.AlertType.INFORMATION, "Please check your password");
                checkPass.showAndWait();
            }
        } else if (professorRadioButton1.isSelected()) {
            Users search = professorsSearch(signupUsername.getText());
            if (search != null) {
                Alert takenUsername = new Alert(Alert.AlertType.INFORMATION, "This username is already taken!");
                takenUsername.showAndWait();
            }
            if (signupPassword.getText().equals(signupConfirm.getText())) {
                if (signupPassword.getText().length() < 6) {
                    Alert invalidPass = new Alert(Alert.AlertType.INFORMATION, "Your Password should be at least 6 characters!");
                    invalidPass.showAndWait();
                } else {
                    Professor newProfessor = new Professor(signupUsername.getText());
                    newProfessor.setPassword(signupPassword.getText());
                    newProfessor.setFirstName(firstname.getText());
                    newProfessor.setLastName(lastname.getText());
                    Professor.ALL_PROFESSORS.add(newProfessor);
                    logIn.setOpacity(1);
                    Alert signupAlert = new Alert(Alert.AlertType.INFORMATION, "SignUp Successfully!");
                    signupAlert.showAndWait();
                }
            } else {
                Alert checkPass = new Alert(Alert.AlertType.INFORMATION, "Please check your password");
                checkPass.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void signUpPage(ActionEvent actionEvent) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), SignUp);
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000), logIn);
        transition2.setToX(-230);
        transition2.playFromStart();
        transition.setToY(-540);
        transition.playFromStart();
        logIn.setOpacity(0.4);
    }
}
