package com.attendance_management_system.model;

public class Attendance {
    private int studentId;
    private String date;
    private String status;

    public Attendance(int studentId, String date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public int getStudentId() { return studentId; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}
