package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Database connection details (assuming the same database for students)
    private static final String URL = "jdbc:mysql://localhost:3306/skillnext_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change this

    // Add student
    public void addStudent(Student student) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // SQL updated for 'student' table, replacing 'salary' with 'major' and 'gpa'
            String sql = "INSERT INTO student (name, email, major, gpa) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMajor()); // New field
            stmt.setDouble(4, student.getGpa());   // New field
            stmt.executeUpdate();
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            // SQL updated for 'student' table
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMajor(rs.getString("major")); // New field
                s.setGpa(rs.getDouble("gpa"));     // New field
                list.add(s);
            }
        }
        return list;
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // SQL updated for 'student' table
            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Update student
    public void updateStudent(Student student) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // SQL updated for 'student' table, replacing 'salary' with 'major' and 'gpa'
            String sql = "UPDATE student SET name=?, email=?, major=?, gpa=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMajor()); // New field
            stmt.setDouble(4, student.getGpa());   // New field
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        }
    }
}