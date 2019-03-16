package ch.halabi.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


class Main {
    public static void main(String[] args) {
        AppLauncher.main(args);
    }
}


public class AppLauncher extends Application {


    public static void main(String[] args) {
        launch(AppLauncher.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent login = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        stage.setTitle("Logging in");
        stage.setScene(new Scene(login));
        stage.setResizable(false);
        stage.show();
    }
}
