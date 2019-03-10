import ch.halabi.model.Course;
import ch.halabi.model.SqliteConnection;
import ch.halabi.model.Student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    ArrayList<Course> courses;


    @FXML
    private Label signedinAsLabel;

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


    }

    @FXML
    void sortStudentsByName(ActionEvent event) {

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

