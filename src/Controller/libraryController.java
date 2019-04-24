package Controller;

import Model.PageLoader;
import Model.library.Book;
import Model.users.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class libraryController implements Initializable {
    @FXML
    TableView<Book> bookTable;
    @FXML
    TableColumn<Book, String> nameCol;
    @FXML
    TableColumn<Book, String> authorCol;
    @FXML
    TableColumn<Book, String> availabilityCol;
//    private final ObservableList<Book> data = FXCollections.observableArrayList(Book.ALL_BOOKS);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
//        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        bookTable.setItems(Book.ALL_BOOKS);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }

    public void reserve(ActionEvent actionEvent) {
        Student obj = (Student) LogedInUser.getLoggedInUser();
        if (!bookTable.getSelectionModel().getSelectedItem().isReserved()) {
            Alert reserved = new Alert(Alert.AlertType.INFORMATION, "This Book is not available!");
            reserved.showAndWait();
            return;
        }
        if (obj.books.size() < 3) {
            bookTable.getSelectionModel().getSelectedItem().setReserved(true);
            obj.books.add(bookTable.getSelectionModel().getSelectedItem());
            Alert userNotFound = new Alert(Alert.AlertType.INFORMATION, "Book Reserved!");
            userNotFound.showAndWait();
        } else {
            Alert limit = new Alert(Alert.AlertType.INFORMATION, "You have 3 books!");
            limit.showAndWait();
        }
    }
}

