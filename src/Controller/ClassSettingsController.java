package Controller;

import Model.Lesson.Lesson;
import Model.PageLoader;
import Model.users.Professor;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassSettingsController implements Initializable {

    @FXML
    JFXComboBox<String> time;
    @FXML
    JFXComboBox<String> day;
    @FXML
    TextField name, unit, capacity;
    @FXML
    TableView<Lesson> lessonsTable;
    @FXML
    TableColumn<String, String> dayCol, unitCol, nameCol, timeCol, capacityCol;
    Professor obj = (Professor) LogedInUser.getLoggedInUser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        lessonsTable.setItems(obj.lessons);
        time.getItems().add("8AM - 10AM");
        time.getItems().add("10AM - 12AM");
        time.getItems().add("14PM - 16PM");
        day.getItems().add("Saturday");
        day.getItems().add("Sunday");
        day.getItems().add("Monday");
        day.getItems().add("Tuesday");
        day.getItems().add("Thursday");
    }

    public void add(ActionEvent actionEvent) {
        Lesson addingLesson = new Lesson(new SimpleStringProperty(name.getText()),new SimpleStringProperty(time.getValue()),new SimpleStringProperty(day.getValue()),new SimpleStringProperty(unit.getText()),new SimpleStringProperty(capacity.getText()),new SimpleStringProperty(LogedInUser.getLoggedInUser().toString()));
//        foodTable.getItems().add(addingFood);
        addingLesson.setProfessor(obj);
        Lesson.ALL_LESSONS.add(addingLesson);
        obj.lessons.add(addingLesson);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/professors-panel.fxml");
    }

    public void remove(ActionEvent actionEvent) {
        Lesson selectedItem = lessonsTable.getSelectionModel().getSelectedItem();
        obj.lessons.remove(selectedItem);
        Lesson.ALL_LESSONS.remove(selectedItem);
    }
}
