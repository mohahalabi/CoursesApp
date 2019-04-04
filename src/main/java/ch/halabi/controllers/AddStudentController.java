package ch.halabi.controllers;

import ch.halabi.connection.SqliteConnection;
import ch.halabi.model.Course;
import ch.halabi.model.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class AddStudentController implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXTextField surnameField;

    @FXML
    private ChoiceBox<Course> choiceBox;

    @FXML
    private Label notifLabel;

    @FXML
    private JFXButton confirmBtn;

    @FXML
    private JFXButton cancelBtn;


    @FXML
    void cancelAddingStudent(ActionEvent event) {
        Stage stage = (Stage) vbox.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAddingStudent(ActionEvent event) {

        // fare in modo che l'utente scelga il corso in cui lo studente
        // viene aggiunto, così vengono passati al database sia lo studente sia il corso

        int idStudent = ThreadLocalRandom.current().nextInt(12, Integer.MAX_VALUE);
        String name = nameField.getText();
        String surname = surnameField.getText();
        Student student = new Student(idStudent, name, surname);

        Course courseChoosed = choiceBox.getValue();

        try {
            if (courseChoosed.getPartecipanti().contains(student)) {
                notifLabel.setText("Student is already added to " + courseChoosed.getName());
            } else {
                SqliteConnection.insertStudentIntoCourse(student, courseChoosed);
                notifLabel.setText(name + " " + surname + " added to " + courseChoosed.getName());
            }
        } catch (SQLException e) {
            notifLabel.setText("Error!");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Course> courses = SqliteConnection.loadCourses();
        choiceBox.getItems().addAll(courses);
    }


}
