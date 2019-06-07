package controller.scenes;

import controller.db.DBConnect;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.szerelesek.Szereles;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SzerelesekController extends MainController {

    @FXML
    private TableView<Szereles> tableSzerelesek;

    //@Override
    public void initialize() {

        ObservableList szerelesek = FXCollections.observableList(DBConnect.getSzerelesek());
        if (szerelesek != null) {
            tableSzerelesek.setItems(szerelesek);
            tableSzerelesek.refresh();
        }

    }

}
