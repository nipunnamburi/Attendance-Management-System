package com.attendance;

import com.attendance.controller.AttendanceController;
import com.attendance.view.AttendanceView;

public class Main {
    public static void main(String[] args) {
        AttendanceController controller = new AttendanceController();
        AttendanceView view = new AttendanceView(controller);
        view.start();
    }
}
