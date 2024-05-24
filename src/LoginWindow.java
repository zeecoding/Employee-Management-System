package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame implements ActionListener {

    JButton employeeButton, adminButton;
    JLabel statusLabel;

    public LoginWindow() {
        setTitle("Login");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        statusLabel = new JLabel("Are you an Employee or Administrator?");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);

        employeeButton = new JButton("Employee");
        employeeButton.addActionListener(this);

        adminButton = new JButton("Administrator");
        adminButton.addActionListener(this);

        panel.add(statusLabel);
        panel.add(employeeButton);
        panel.add(adminButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeeButton) {
            try{
            int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter your Employee ID:"));
            new EmployeeDashboard(empId);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Invalid Employee ID. Please enter a valid numeric ID.");
            }
            dispose(); // Close the login window
        } else if (e.getSource() == adminButton) {
            dispose(); // Close the login window
            new Login_user().setVisible(true);          
        }
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
