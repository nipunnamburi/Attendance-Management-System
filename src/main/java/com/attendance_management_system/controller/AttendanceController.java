package com.attendance_management_system.controller;

import java.util.List;

import com.attendance_management_system.dao.AttendanceDAO;
import com.attendance_management_system.model.Attendance;
import com.attendance_management_system.model.Student;

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
