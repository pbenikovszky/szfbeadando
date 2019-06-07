package controller.scenes;

import controller.db.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.autok.Auto;
import model.autok.Tulaj;

import java.sql.SQLOutput;
import java.util.List;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TulajController extends  MainController {


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private Button btnCreate;


    @FXML
    public TableView<Tulaj> tableTulajok;

    @FXML
    public TableView<Auto> tableAutok;

    //@Override
    public void initialize() {

        ObservableList tulajok = FXCollections.observableList(DBConnect.getTulajdonosok());
        tableTulajok.setItems(tulajok);
        tableTulajok.refresh();

    }

    @FXML
    @Override
    void changeToOwners(ActionEvent event) {

    }

    @FXML
    void addOwner(ActionEvent event) {
        Tulaj tulaj = new Tulaj(txtName.getText(), txtAddress.getText());
        if (DBConnect.createTulajdonos(tulaj)) {
            txtName.setText("");
            txtAddress.setText("");
        }
    }

    @FXML
    void loadCars(MouseEvent event) {
//        System.out.println(tableTulajok.getSelectionModel().getSelectedItem().getId());
//        System.out.println(tableTulajok.getSelectionModel().getSelectedItem().getNev());
        ObservableList autok = FXCollections.observableList(DBConnect.getAutoFromTulajdonos(tableTulajok.getSelectionModel().getSelectedItem().getId()));
        tableAutok.setItems(autok);
        tableAutok.refresh();
    }


}
