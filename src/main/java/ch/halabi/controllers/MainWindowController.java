package ch.halabi.controllers;

import ch.halabi.model.Course;
import ch.halabi.connection.SqliteConnection;
import ch.halabi.model.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    ArrayList<Course> courses;


    @FXML
    private Label signedinAsLabel;

    @FXML
    private JFXTextField searchCourseField;

    @FXML
    private JFXTextField searchStudentField;

    @FXML
    private JFXListView<Course> listviewCourses;

    @FXML
    private JFXListView<Student> listviewStudents;

    @FXML
    private JFXButton addCourseBtn;

    @FXML
    private JFXButton deleteCourseBtn;

    @FXML
    private JFXButton addStudentBtn;

    @FXML
    private JFXButton deleteStudentBtn;


    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void addStudent(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddStudentWindow.fxml"));

        Parent addStudentWindow = loader.load();

        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Add new Student");
        addStudentStage.setScene(new Scene(addStudentWindow));
        addStudentStage.setResizable(false);
        addStudentStage.showAndWait();

    }

    @FXML
    void deleteCourse(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {
        Course course = listviewCourses.getSelectionModel().getSelectedItem();
        Student student = listviewStudents.getSelectionModel().getSelectedItem();
        try {
            SqliteConnection.deleteStudente(student.getId(), course.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchCourse(KeyEvent event) {
        for (Course course : listviewCourses.getItems()) {
            if (course.getName().toLowerCase().startsWith(searchCourseField.getText().toLowerCase())) {
                listviewCourses.getSelectionModel().select(course);
            }
        }

    }

    @FXML
    void searchStudent(KeyEvent event) {
        for (Student student : listviewStudents.getItems()) {
            if (student.getName().toLowerCase().startsWith(searchStudentField.getText().toLowerCase())) {
                listviewStudents.getSelectionModel().select(student);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        courses = SqliteConnection.loadCourses();
        listviewCourses.getItems().addAll(courses);

        listviewCourses.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            Course course = listviewCourses.getSelectionModel().getSelectedItem();
            ArrayList<Student> studentsEnrolled = SqliteConnection.loadEnrolledStudents(course);
            listviewStudents.setItems(FXCollections.observableArrayList(studentsEnrolled));

        });

    }

    public Label getSignedinAsLabel() {
        return signedinAsLabel;
    }
}

