package Controller;

import Model.PageLoader;
import Model.library.Book;
import Model.users.Student;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookListController implements Initializable {

    @FXML
    TableView<Book> bookTable;
    @FXML
    TableColumn<Book, String> nameCol;
    @FXML
    TableColumn<Book, String> authorCol;
    private Student obj = (Student) LogedInUser.getLoggedInUser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        bookTable.setItems(obj.books);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }

    public void returnButton(ActionEvent actionEvent) {
        Book selectedItem = bookTable.getSelectionModel().getSelectedItem();
        selectedItem.setReserved(false);
        obj.books.remove(selectedItem);
    }
}
