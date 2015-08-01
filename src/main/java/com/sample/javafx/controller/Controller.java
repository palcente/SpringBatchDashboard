package com.sample.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text actiontarget;

    public void handleButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }
}
