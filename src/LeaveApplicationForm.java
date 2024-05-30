package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LeaveApplicationForm extends JFrame implements ActionListener {

    JLabel empIdLabel, leaveTypeLabel, startDateLabel, endDateLabel, reasonLabel;
    JTextField empIdField, leaveTypeField, startDateField, endDateField;
    JTextArea reasonArea;
    JButton submitButton, resetButton;
    conn connection; // Instance of the conn class for database connection

    public LeaveApplicationForm() {
        setTitle("Leave Application Form");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connection = new conn(); // Initialize the conn instance

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        empIdLabel = new JLabel("Employee ID:");
        empIdField = new JTextField();
        leaveTypeLabel = new JLabel("Leave Type:");
        leaveTypeField = new JTextField();
        startDateLabel = new JLabel("Start Date (YYYY-MM-DD):");
        startDateField = new JTextField();
        endDateLabel = new JLabel("End Date (YYYY-MM-DD):");
        endDateField = new JTextField();
        reasonLabel = new JLabel("Reason:");
        reasonArea = new JTextArea();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        panel.add(empIdLabel);
        panel.add(empIdField);
        panel.add(leaveTypeLabel);
        panel.add(leaveTypeField);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(endDateLabel);
        panel.add(endDateField);
        panel.add(reasonLabel);
        panel.add(reasonArea);
        panel.add(submitButton);
        panel.add(resetButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitLeaveApplication();
        } else if (e.getSource() == resetButton) {
            resetForm();
        }
    }

    private void submitLeaveApplication() {
        int empId;
        try {
            empId = Integer.parseInt(empIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID");
            return;
        }
        
        String leaveType = leaveTypeField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String reason = reasonArea.getText();

        if (leaveType.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || reason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
            return;
        }

        try {
            String sql = "INSERT INTO LeaveApplications (EmployeeID, LeaveType, StartDate, EndDate, Reason) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.c.prepareStatement(sql);
            pstmt.setInt(1, empId);
            pstmt.setString(2, leaveType);
            pstmt.setString(3, startDate);
            pstmt.setString(4, endDate);
            pstmt.setString(5, reason);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Leave application submitted successfully");
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to submit leave application");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void resetForm() {
        empIdField.setText("");
        leaveTypeField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        reasonArea.setText("");
    }

    public static void main(String[] args) {
        new LeaveApplicationForm();
    }
}
