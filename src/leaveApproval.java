package Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class leaveApproval extends JFrame implements ActionListener {

    JTable table;
    JButton approveButton, rejectButton, backButton;
    DefaultTableModel model;
    conn connection; // Declare an instance of the conn class for database connection

    public leaveApproval() {
        // Set up the frame
        setTitle("Leave Approval");
        setLayout(new BorderLayout());
        setSize(800, 600);
        setLocation(300, 100);

        connection = new conn(); // Initialize the conn instance

        // Create the table model and JTable
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Set up table columns
        model.addColumn("LeaveID");
        model.addColumn("EmployeeID");
        model.addColumn("LeaveType");
        model.addColumn("StartDate");
        model.addColumn("EndDate");
        model.addColumn("Reason");
        model.addColumn("ApplicationDate");
        model.addColumn("Status");

        // Load leave applications from the database
        loadLeaveApplications();

        // Create buttons
        approveButton = new JButton("Approve");
        rejectButton = new JButton("Reject");
        backButton = new JButton("Back");

        // Add action listeners
        approveButton.addActionListener(this);
        rejectButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add components to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadLeaveApplications() {
        ResultSet rs = null;
        try {
            // Execute the query
            rs = connection.s.executeQuery("SELECT * FROM LeaveApplications WHERE Status = 'pending'");

            // Load data into the table model
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("LeaveID"),
                        rs.getInt("EmployeeID"),
                        rs.getString("LeaveType"),
                        rs.getDate("StartDate"),
                        rs.getDate("EndDate"),
                        rs.getString("Reason"),
                        rs.getTimestamp("ApplicationDate"),
                        rs.getString("Status")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet
            try {
                if (rs != null) rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == approveButton) {
            updateLeaveStatus("approved");
        } else if (ae.getSource() == rejectButton) {
            updateLeaveStatus("rejected");
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Home();
        }
    }

    private void updateLeaveStatus(String status) {
    int selectedRow = table.getSelectedRow();
    if (selectedRow >= 0) {
        int leaveID = (int) table.getValueAt(selectedRow, 0);
        try {
            String comments = JOptionPane.showInputDialog("Enter comments:");
            if (comments == null) {
                // User canceled input, do nothing
                return;
            }
            
            // Update the leave status
            String updateLeaveSQL = "UPDATE LeaveApplications SET Status = ?, ApprovalDate = CURRENT_TIMESTAMP WHERE LeaveID = ?";
            PreparedStatement pstmtUpdateLeave = connection.c.prepareStatement(updateLeaveSQL);
            pstmtUpdateLeave.setString(1, status);
            pstmtUpdateLeave.setInt(2, leaveID);
            pstmtUpdateLeave.executeUpdate();

            // Insert into LeaveApprovals table
            String insertApprovalSQL = "INSERT INTO LeaveApprovals (LeaveID, ApprovalStatus, Comments) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsertApproval = connection.c.prepareStatement(insertApprovalSQL);
            pstmtInsertApproval.setInt(1, leaveID);
            pstmtInsertApproval.setString(2, status);
            pstmtInsertApproval.setString(3, comments);
            pstmtInsertApproval.executeUpdate();

            // Remove the row from the table
            model.removeRow(selectedRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a leave application to " + status);
    }
}


    public static void main(String[] args) {
        new leaveApproval();
    }
}
