package ch.halabi.controllers;

import ch.halabi.model.Course;
import ch.halabi.model.Student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

public class MainWindowController implements Initializable {



    ArrayList<Course> courses = new ArrayList<>();

    @FXML
    private JFXToggleButton sortCoursesToggle;

    @FXML
    private JFXToggleButton sortStudentsToggle;

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
        sortCoursesToggle.setOnAction(ev -> {
            courses.sort(Comparator.comparing(Course::getName));
            listviewCourses.setItems(FXCollections.observableArrayList(courses));
        });

    }

    @FXML
    void sortStudentsByName(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        courses.add(new Course(1, "Analisi 1"));
        courses.add(new Course(2, "Analisi 2"));
        courses.add(new Course(3, "Algebra 2"));

        listviewCourses.getItems().addAll(courses);

    }
}

