package Controller;

import Model.PageLoader;
import Model.users.Professor;
import Model.users.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class UsersListController extends ListView<String> implements Initializable {
    @FXML
    ListView<String> studentsList;
    @FXML
    ListView<String> professorsList;
    ObservableList<String> stuList = FXCollections.observableArrayList();
    ObservableList<String> proList = FXCollections.observableArrayList();
    private Image studentsAvatar = new Image("View/resources/boy.png");
    private Image professorsAvatar = new Image("View/resources/man.png");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < Student.ALL_STUDENTS.size(); i++) {
            stuList.add(Student.ALL_STUDENTS.get(i).toString());
        }
        for (int i = 0; i < Professor.ALL_PROFESSORS.size(); i++) {
            proList.add(Professor.ALL_PROFESSORS.get(i).toString());
        }

        studentsList.setItems(stuList);
        professorsList.setItems(proList);
        studentsList.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(name);
                    imageView.setImage(studentsAvatar);
                    setGraphic(imageView);
                }
            }
        });
        professorsList.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(name);
                    imageView.setImage(professorsAvatar);
                    setGraphic(imageView);
                }
            }
        });
    }

    public void back(ActionEvent actionEvent) throws IOException {
    new PageLoader().Load("../View/admin-panel.fxml");
    }
}
