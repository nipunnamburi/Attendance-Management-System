package com.attendance.controller;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Attendance;
import com.attendance.model.Student;

import java.util.List;

public class AttendanceController {

    AttendanceDAO dao = new AttendanceDAO();

    public String addStudent(String roll, String name) {
        return dao.addStudent(new Student(roll, name));
    }

    public String markAttendance(int studentId, String date, String status) {
        return dao.markAttendance(new Attendance(studentId, date, status));
    }

    public List<Student> getAllStudents() {
        return dao.getStudents();
    }

    public List<Attendance> getAttendance(int studentId) {
        return dao.getAttendance(studentId);
    }
}
