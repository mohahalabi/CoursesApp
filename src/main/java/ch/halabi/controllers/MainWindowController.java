package ch.halabi.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

public class MainWindowController implements Initializable {

    @FXML
    private JFXToggleButton sortCoursesToggle;

    @FXML
    private JFXToggleButton sortStudentsToggle;

    @FXML
    private JFXListView<?> listviewCourses;

    @FXML
    private JFXListView<?> listviewStudents;

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
    void addStudent(ActionEvent event) {

    }

    @FXML
    void deleteCourse(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {

    }

    @FXML
    void sortCoursesByName(ActionEvent event) {

    }

    @FXML
    void sortStudentsByName(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}

