package controller.scenes;

import controller.db.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SzerelokController extends MainController {

    @FXML
    private TableView<?> tableSzerelok;

    //@Override
    public void initialize() {

        ObservableList szerelok = FXCollections.observableList(DBConnect.getSzerelok());
        if (szerelok != null) {
            tableSzerelok.setItems(szerelok);
            tableSzerelok.refresh();
        }

    }

}
