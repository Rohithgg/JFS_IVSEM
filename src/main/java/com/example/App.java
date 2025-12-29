package com.example;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // Instantiate the DAO for Student operations
        StudentDAO dao = new StudentDAO();

        try {
            // --- 1. Add Student ---
            // Student object uses: name, email, major (String), gpa (double)
            Student s1 = new Student("Alice Johnson", "alice@university.edu", "Computer Science", 3.85);
            Student s2 = new Student("Bob Smith", "bob@university.edu", "Electrical Engineering", 3.52);
            
            dao.addStudent(s1);
            dao.addStudent(s2);
            System.out.println("--- Students Added Successfully ---");

            // --- 2. Fetch All Students ---
            System.out.println("\n--- All Students Before Update/Delete ---");
            List<Student> students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }
            
            // Assuming Alice (s1) got ID 1 from the database (need to fetch to know the ID for sure)
            // Let's assume the first student retrieved is the one we want to update.
            if (!students.isEmpty()) {
                Student studentToUpdate = students.get(0);
                
                // --- 3. Update Student ---
                studentToUpdate.setMajor("Data Science");
                studentToUpdate.setGpa(3.95);
                dao.updateStudent(studentToUpdate);
                System.out.println("\n--- Student Updated Successfully (ID: " + studentToUpdate.getId() + ") ---");
            }
            
            // --- 4. Fetch All Students After Update ---
            System.out.println("\n--- All Students After Update ---");
            students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }
            
            // --- 5. Delete Student ---
            // Assuming the second student (s2, Bob) got ID 2, let's try to delete it.
            // CAUTION: The IDs depend on your database state. This example assumes IDs 1 and 2.
            if (students.size() > 1) {
                 dao.deleteStudent(students.get(1).getId());
                 System.out.println("\n--- Student Deleted Successfully (ID: " + students.get(1).getId() + ") ---");
            }

            // --- 6. Fetch All Students After Delete ---
            System.out.println("\n--- All Students After Delete ---");
            students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.err.println("An error occurred during database operations:");
            e.printStackTrace(System.err);
        }
    }
}