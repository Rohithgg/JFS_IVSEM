package com.example;

public class Student {
    private int id;
    private String name;
    private String email;
    private String major; // Changed from salary
    private double gpa;   // Changed from salary (type changed from double to double, but represents GPA)

    // Constructors
    public Student() {}
    public Student(String name, String email, String major, double gpa) {
        this.name = name;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", major=" + major + ", gpa=" + gpa + "]";
    }
}