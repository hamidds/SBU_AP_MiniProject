package Controller;

import Model.Food.Foods;
import Model.PageLoader;
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

public class FoodSettingsController implements Initializable {
    @FXML
    TableView<Foods> foodTable;
    @FXML
    TableColumn<String, String> dayCol;
    @FXML
    TableColumn<String, String> foodCol;
    @FXML
    TableColumn<String, String> priceCol;
    @FXML
    TextField day;
    @FXML
    TextField food;
    @FXML
    TextField price;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        foodCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        foodTable.setItems(Foods.ALL_FOODS);
    }

    public void addButton(ActionEvent actionEvent) {
        Foods addingFood = new Foods(new SimpleStringProperty(day.getText()), new SimpleStringProperty(food.getText()),new SimpleStringProperty(price.getText()));
//        foodTable.getItems().add(addingFood);
        Foods.ALL_FOODS.add(addingFood);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/admin-panel.fxml");
    }
}
