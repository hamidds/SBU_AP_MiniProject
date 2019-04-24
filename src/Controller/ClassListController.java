package Controller;

import Model.Lesson.Lesson;
import Model.PageLoader;
import Model.users.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassListController implements Initializable {
    @FXML
    TableView<Lesson> lessonTable;
    @FXML
    TableColumn<String, String> dayCol, unitCol, lessonCol, timeCol, professorCol;
    @FXML
    TableColumn<String, String>  gradeCol;
    Student obj = (Student) LogedInUser.getLoggedInUser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lessonCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
//        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        professorCol.setCellValueFactory(new PropertyValueFactory<>("professorName"));
        lessonTable.setItems(obj.lessons);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }
}
