package com.attendance_management_system.view;

import java.util.List;
import java.util.Scanner;

import com.attendance_management_system.controller.AttendanceController;
import com.attendance_management_system.model.Attendance;
import com.attendance_management_system.model.Student;

public class AttendanceView {

    AttendanceController controller;
    Scanner sc = new Scanner(System.in);

    public AttendanceView(AttendanceController controller) {
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Attendance Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Students");
            System.out.println("4. View Attendance");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: markAttendance(); break;
                case 3: viewStudents(); break;
                case 4: viewAttendance(); break;
                case 5: return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println(controller.addStudent(roll, name));
    }

    private void markAttendance() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter Status (Present/Absent): ");
        String status = sc.nextLine();

        System.out.println(controller.markAttendance(id, date, status));
    }

    private void viewStudents() {
        List<Student> list = controller.getAllStudents();
        System.out.println("\n---- Students ----");
        for (Student s : list) {
            System.out.println(s.getId() + " | " + s.getRollNo() + " | " + s.getName());
        }
    }

    private void viewAttendance() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        List<Attendance> list = controller.getAttendance(id);
        System.out.println("\n---- Attendance ----");
        for (Attendance a : list) {
            System.out.println(a.getDate() + " | " + a.getStatus());
        }
    }
}
