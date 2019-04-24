package Controller;

import Model.Lesson.Lesson;
import Model.PageLoader;
import Model.users.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassManagementController implements Initializable {
    @FXML
    TableView<Lesson> lessonTable;
    @FXML
    TableColumn<String, String> dayCol, unitCol, lessonCol, timeCol, capacityCol, professorCol;
    private Student obj = (Student) LogedInUser.getLoggedInUser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lessonCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        professorCol.setCellValueFactory(new PropertyValueFactory<>("professorName"));
        lessonTable.setItems(Lesson.ALL_LESSONS);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }

    public void add(ActionEvent actionEvent) {
        Lesson selectedItem = lessonTable.getSelectionModel().getSelectedItem();
        if (Integer.parseInt(selectedItem.getCapacity()) > 0) {
            selectedItem.decreaseCapacity();
            selectedItem.students.add(obj);
            obj.lessons.add(selectedItem);
        }else {
            Alert Full = new Alert(Alert.AlertType.INFORMATION, "This Class is FULL!");
            Full.showAndWait();
        }
    }
}
