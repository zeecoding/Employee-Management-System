package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeDashboard extends JFrame implements ActionListener {

    JButton viewAttendanceButton, leaveApplicationButton;
    JLabel empIdLabel;
    int empId;

    public EmployeeDashboard(int empId) {
        this.empId = empId;

        setTitle("Employee Dashboard");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        empIdLabel = new JLabel("Employee ID: " + empId);
        empIdLabel.setHorizontalAlignment(JLabel.CENTER);

        viewAttendanceButton = new JButton("View Attendance");
        viewAttendanceButton.addActionListener(this);

        leaveApplicationButton = new JButton("Leave Application");
        leaveApplicationButton.addActionListener(this);

        panel.add(empIdLabel);
        panel.add(viewAttendanceButton);
        panel.add(leaveApplicationButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAttendanceButton) {
            // Code to display attendance
            dispose();
            new Attendanceview().setVisible(true);
        } else if (e.getSource() == leaveApplicationButton) {
            // Open leave application form
            new LeaveApplicationForm();
        }
    }
}
