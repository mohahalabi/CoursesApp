package ch.halabi.model;

import java.sql.*;

public class SqliteConnection {


    private static final String DATA_PATH = "jdbc:sqlite:data-base/course_student.sqlite";


    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATA_PATH);
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void main(String[] args) {
        if (getConnection() != null) {
            System.out.println("Success!");
        }


        if (isValidLogin("admin", "admin"))
            System.out.println("Success Login!");

    }


    public static void insertCourse(int id, String name) throws SQLException {

        String sql = "INSERT INTO Course (id,name) VALUES(?,?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
        }

    }


    public static void insertStudent(int id, String name, String surname) throws SQLException {

        String sql = "INSERT INTO Course (id,name,surname) VALUES(?,?,?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.executeUpdate();
        }

    }

    public static boolean isValidLogin(String username, String password) {

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            return false;
        }
    }


}
