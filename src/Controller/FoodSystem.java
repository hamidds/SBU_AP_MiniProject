package Controller;

import Model.Food.Foods;
import Model.PageLoader;
import Model.users.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodSystem implements Initializable {
    @FXML
    TableView<Foods> foodTable;
    @FXML
    TableColumn<String, String> dayCol;
    @FXML
    TableColumn<String, String> foodCol;
    @FXML
    TableColumn<String, String> priceCol;
    @FXML
    Label credit, price;
    Student obj = (Student) LogedInUser.getLoggedInUser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        foodCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        foodTable.setItems(Foods.ALL_FOODS);
        credit.setText("Credit : " + obj.getCredit());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new PageLoader().Load("../View/students-panel.fxml");
    }

    public void foodReserve(ActionEvent actionEvent) {
        if (affordable()) {
            obj.foods.add(foodTable.getSelectionModel().getSelectedItem());
        } else {
            Alert notEnough = new Alert(Alert.AlertType.INFORMATION, "You don't have enough money!");
            notEnough.showAndWait();
        }
    }

    private boolean affordable() {
        int calculatedPrice = 0;
        ObservableList<Foods> selectedItems = foodTable.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItems.size(); i++) {
            calculatedPrice += selectedItems.get(i).getPrice_int();
        }
        return obj.getCredit() > calculatedPrice;
    }

}
