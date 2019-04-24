package Model.users;

import Model.Food.Foods;
import Model.Lesson.Lesson;
import Model.library.Book;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Student extends Users {
    public static final List<Student> ALL_STUDENTS = new ArrayList<>();
    public final List<Foods> foods = new ArrayList<>();
    public final ObservableList<Book> books = FXCollections.observableArrayList();
    public final ObservableList<Lesson> lessons = FXCollections.observableArrayList();
    private double mark;
    private int credit;
    public SimpleStringProperty name ;

    public void setCredit(int credit) {
        this.credit = credit;
    }

    private String cardNumber, cardPassword;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String username) {
        super(username);
    }

    public double getMark() {
        return mark;
    }

    public long getCredit() {
        return credit;
    }

    public String getName() {
        this.name = new SimpleStringProperty(this.toString());
        return name.get();
    }

    public double markCalculator() {
        double sum = 0;
        int units = 0;
        for (int i = 0; i < lessons.size(); i++) {
            sum += lessons.get(i).getSum();
            units += Integer.parseInt(lessons.get(i).getUnit());
        }
        this.mark = sum / units;
        return this.mark;
    }

}
