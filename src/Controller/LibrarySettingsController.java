package Controller;

import Model.PageLoader;
import Model.library.Book;
import javafx.beans.property.SimpleStringProperty;
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

public class LibrarySettingsController implements Initializable {

    @FXML
    TableView<Book> bookSettingsTable;
    @FXML
    TableColumn<String, String> nameCol;
    @FXML
    TableColumn<String, String> authorCol;
    @FXML
    TextField bookname;
    @FXML
    TextField authorname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        bookSettingsTable.setItems(Book.ALL_BOOKS);
    }

    public void back(ActionEvent actionEvent) throws IOException {
         new PageLoader().Load("../View/admin-panel.fxml");
    }

    public void addButton(ActionEvent actionEvent) {
        Book addingFood = new Book(new SimpleStringProperty(bookname.getText()), new SimpleStringProperty(authorname.getText()));
//        foodTable.getItems().add(addingFood);
        Book.ALL_BOOKS.add(addingFood);
    }
}
