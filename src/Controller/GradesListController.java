package Controller;

import Model.Lesson.Lesson;
import Model.PageLoader;
import Model.users.Professor;
import Model.users.Student;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GradesListController implements Initializable {

    @FXML
    JFXComboBox<Lesson> lessons;
    @FXML
    TableView<Student> gradeTable;
    @FXML
    TableColumn<String, String> nameCol;
    @FXML
    TextField grade;
    private Professor obj = (Professor) LogedInUser.getLoggedInUser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < obj.lessons.size(); i++) {
            lessons.getItems().add(obj.lessons.get(i));
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/professors-panel.fxml");
    }

    public void add(ActionEvent actionEvent) {
        Student selectedStudent = gradeTable.getSelectionModel().getSelectedItem();
        selectedStudent.lessons.get(selectedStudent.lessons.indexOf(lessons.getValue())).setGrade(Double.parseDouble(grade.getText()));
    }

    public void show(ActionEvent actionEvent) {
        Lesson selectedItem = lessons.getValue();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        gradeTable.setItems(selectedItem.students);
    }
}
