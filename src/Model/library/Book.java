package Model.library;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class Book {
    //    public static final List<Book> ALL_BOOKS = new ArrayList<>();
    public static final ObservableList<Book> ALL_BOOKS = FXCollections.observableArrayList();
//    public static final ObservableList<Book> data = FXCollections.observableArrayList(new Book(new SimpleStringProperty("john"), new SimpleStringProperty("smith")), new Book(new SimpleStringProperty("david"), new SimpleStringProperty("web")), new Book(new SimpleStringProperty("jeff"), new SimpleStringProperty("dean")), new Book(new SimpleStringProperty("will"), new SimpleStringProperty("smith")));
    private SimpleStringProperty Name, authorName, code ;
    private SimpleStringProperty availability;

    public boolean isReserved() {
        return isReserved;
    }

    private boolean isReserved = true;

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String getAvailability() {
        if (isReserved)
            this.availability = new SimpleStringProperty("It's available");
        else
            this.availability = new SimpleStringProperty("It's not available");
        return availability.get();
    }


    public Book(SimpleStringProperty name, SimpleStringProperty authorName) {
        Name = name;
        this.authorName = authorName;
    }

    public String getName() {
        return Name.get();
    }


    public String getAuthorName() {
        return authorName.get();
    }

//    public String getCode() {
//        code = new SimpleStringProperty(Integer.toString(data.size()));
//        return code.get();
//    }

}
