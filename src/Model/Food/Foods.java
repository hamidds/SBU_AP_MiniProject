package Model.Food;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

public class Foods {
    public static final ObservableList<Foods> ALL_FOODS = FXCollections.observableArrayList();
    private SimpleStringProperty name, day, price;

    public Foods( SimpleStringProperty day,SimpleStringProperty name, SimpleStringProperty price) {
        this.name = name;
        this.day = day;
        this.price = price;
    }

    public String getName() {
        return name.get();
    }

    public String getDay() {
        return day.get();
    }

    public int getPrice_int(){
        return Integer.parseInt(price.get());
    }

    public String getPrice() { return price.get(); }


}
