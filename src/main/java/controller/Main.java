package controller;

import controller.db.DBConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



//        Username: YHdeFHFcaM
//        Database name: YHdeFHFcaM
//        Password: veK2EU1w0H
//        Server: remotemysql.com
//        Port: 3306
//        These are the username and password to log in to your database and phpMyAdmin

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sceneSzerelesek.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Bekő Tóni autószerelő műhelyek");
        primaryStage.setScene(new Scene(root, 1000, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        DBConnect.emf.close();
    }
}
