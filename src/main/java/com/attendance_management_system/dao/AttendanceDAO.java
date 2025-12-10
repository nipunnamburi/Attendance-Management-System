package com.attendance_management_system.dao;

import com.attendance_management_system.model.Attendance;
import com.attendance_management_system.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    Connection con = DBConnection.getConnection();

    public String addStudent(Student student) {
        try {
            String sql = "INSERT INTO students(roll_no, name) VALUES(?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student.getRollNo());
            pst.setString(2, student.getName());
            pst.executeUpdate();
            return "Student added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding student.";
        }
    }

    public String markAttendance(Attendance att) {
        try {
            String sql = "INSERT INTO attendance_records(student_id, date, status) VALUES(?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, att.getStudentId());
            pst.setString(2, att.getDate());
            pst.setString(3, att.getStatus());
            pst.executeUpdate();
            return "Attendance marked successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error marking attendance.";
        }
    }

    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("roll_no"), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Attendance> getAttendance(int studentId) {
        List<Attendance> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM attendance_records WHERE student_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt("student_id"),
                        rs.getString("date"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
