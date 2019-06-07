package controller.scenes;

import controller.db.DBConnect;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.autok.Auto;
import model.autok.Tulaj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutokController extends MainController {

    @FXML
    private TableView<?> tableAutok;

    @FXML
    private TextField txtRendszam;

    @FXML
    private TextField txtTipus;

    @FXML
    private ComboBox cbTulajok;

    @FXML
    private Button btnCreate;

    private Map<Integer, String> tulajMap;

    private Integer selectedID;

    @FXML
    void addAuto(ActionEvent event) {
        if (selectedID == 0)
            return;

        Auto ujAuto = new Auto(txtRendszam.getText(), txtTipus.getText(), selectedID);
        DBConnect.createAuto(ujAuto);
    }


    //@Override
    public void initialize() {
        selectedID = 0;
        ObservableList autok = FXCollections.observableList(DBConnect.getAutok());
        if (autok != null) {
            tableAutok.setItems(autok);
            tableAutok.refresh();
        }

//        List<String> tulajNevek = DBConnect.getTulajdonosMap();
        tulajMap = DBConnect.getTulajdonosMap();
        List<String> tulajNevek = new ArrayList<>(tulajMap.values());
        cbTulajok.getItems().addAll(tulajNevek.stream().sorted().collect(Collectors.toList()));

        cbTulajok.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                selectedID = DBConnect.getTulajID(ov.getValue().toString());
                System.out.println(selectedID);
            }
        });


    }


}
