package ch.halabi.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;

import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Connection conn ;

    @FXML
    private JFXButton cancelLoginBtn;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField usernameField;


    @FXML
    void cancelLogin(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}
