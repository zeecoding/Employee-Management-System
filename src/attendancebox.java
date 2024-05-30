

package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class attendancebox implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b5,b6;

    attendancebox(){
        f=new JFrame(" Attendance Management ");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);
        
        
        b1=new JButton("Fill Attendance");
        b1.setBounds(420,60,210,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);
        
        b2=new JButton("View Attendance");
        b2.setBounds( 420,120,210,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);
      
        b5=new JButton(" BACK ");
        b5.setBounds(420,200,100,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);


        b6=new JButton(" EXIT ");
        b6.setBounds(530,200,100,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        b6.setForeground(Color.red);
        l1.add(b6);
        
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(400,200);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Attendance();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
          new Attendanceview().setVisible(true);
        }
        
        if(ae.getSource()==b5){
            f.setVisible(false);
             new Home(); 
        }
        
        if(ae.getSource()==b6){
            f.setVisible(false);
           System.exit(0);
        }
        }

    public static void main(String[ ] arg){
         new attendancebox();
    }
}