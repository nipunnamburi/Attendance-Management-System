package com.attendance_management_system;

import com.attendance_management_system.controller.AttendanceController;
import com.attendance_management_system.view.AttendanceView;

public class Main {
    public static void main(String[] args) {
        AttendanceController controller = new AttendanceController();
        AttendanceView view = new AttendanceView(controller);
        view.start();
    }
}
