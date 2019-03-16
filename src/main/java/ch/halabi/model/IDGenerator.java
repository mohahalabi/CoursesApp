package ch.halabi.model;

import java.sql.SQLException;

public class IDGenerator {


    private static int id_student;
    private static int id_course;

    static {
        try {
            id_student = SqliteConnection.countRowsOfTable("Student");
            id_course = SqliteConnection.countRowsOfTable("Course");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int generateStudentID() {
        return ++id_student;
    }

    public static int generateCourseID() {
        return ++id_course;
    }

}
