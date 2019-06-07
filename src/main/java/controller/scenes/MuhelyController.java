package controller.scenes;

import controller.db.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.szerelesek.Muhely;

public class MuhelyController extends MainController {

    @FXML
    private TableView<Muhely> tableMuhelyek;

    //@Override
    public void initialize() {

        ObservableList muhelyek = FXCollections.observableList(DBConnect.getMuhelyek());
        if (muhelyek != null) {
            tableMuhelyek.setItems(muhelyek);
            tableMuhelyek.refresh();
        }

    }


}
