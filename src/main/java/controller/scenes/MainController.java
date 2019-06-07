package controller.scenes;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private GridPane buttonsGrid;

    @FXML
    private Button btnRepairs;

    @FXML
    private Button btnCars;

    @FXML
    private Button btnOwners;

    @FXML
    private Button btnMechanics;

    @FXML
    private Button btnShops;

    @FXML
    void changeToCars(ActionEvent event) {
        loadScene("sceneAutok.fxml");
    }

    @FXML
    void changeToMechanics(ActionEvent event) {
        loadScene("sceneSzerelok.fxml");
    }

    @FXML
    void changeToOwners(ActionEvent event) {
        loadScene("sceneTulajok.fxml");
    }

    @FXML
    void changeToRepairs(ActionEvent event) {
        loadScene("sceneSzerelesek.fxml");
    }

    @FXML
    void changeToShops(ActionEvent event) {
        loadScene("sceneMuhelyek.fxml");
    }

    private void loadScene(String sceneFileName) {
        Stage stage = (Stage) btnCars.getScene().getWindow();
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + sceneFileName));
            root = loader.load();

            stage.setTitle("Bekő Tóni autószerelő műhelyek");
            stage.setScene(new Scene(root, 1000, 625));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
