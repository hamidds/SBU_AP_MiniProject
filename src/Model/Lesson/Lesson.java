package Model.Lesson;

import Model.users.Professor;
import Model.users.Student;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;


public class Lesson {
    public static final ObservableList<Lesson> ALL_LESSONS = FXCollections.observableArrayList();
    private SimpleStringProperty name, time, day, unit, capacity, professorName ;
    private Professor professor;
    private double grade = 20;
    public ObservableList<Student> students = FXCollections.observableArrayList();

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getProfessorName() {
        return professorName.get();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Lesson(SimpleStringProperty name, SimpleStringProperty time, SimpleStringProperty day, SimpleStringProperty unit, SimpleStringProperty capacity, SimpleStringProperty professorName) {
        this.name = name;
        this.time = time;
        this.day = day;
        this.unit = unit;
        this.capacity = capacity;
        this.professorName = professorName;
    }

    public String getName() {
        return name.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getDay() {
        return day.get();
    }

    public String getUnit() {
        return unit.get();
    }

    public String getCapacity() {
        return capacity.get();
    }

    public double getSum(){
        return grade * Integer.parseInt(unit.get());
    }

    public void decreaseCapacity() {
        if (Integer.parseInt(capacity.get()) == 0)
            return;
        capacity = new SimpleStringProperty(Integer.toString(Integer.parseInt(capacity.get()) - 1));
    }

    @Override
    public String toString() {
        return name.get();
    }
}
