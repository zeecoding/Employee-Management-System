/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;
import java.sql.*;
/**
 *
 * @author nac
 */
public class conn {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            // if you change your xampp port then change here & username and password match here . 
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

