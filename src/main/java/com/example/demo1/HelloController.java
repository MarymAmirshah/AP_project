package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    void controlPanel(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("panel.fxml"));
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void productList(MouseEvent event) {

    }
}