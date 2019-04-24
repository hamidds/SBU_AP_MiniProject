package Model.users;

import Model.Lesson.Lesson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Users {
    public static final List<Professor> ALL_PROFESSORS = new ArrayList<>();
    public final ObservableList<Lesson> lessons = FXCollections.observableArrayList();

    public Professor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Professor(String username){
        super(username);
    }
}
