package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerControl implements Initializable {

    @FXML
    void Login(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProductRequest(MouseEvent event) {

    }

    @FXML
    void SellerRequest(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
