package Employee;

import java.awt.*;
import javax.swing.*;
import java.lang.Package;
import java.awt.event.*;

class Front_Page implements ActionListener{
    JFrame f; 
    JLabel id,l1;
    JButton b;

    Front_Page(){
 
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setForeground(new Color( 0,0,0));
    	b.setBackground(new Color(204, 255, 255));
        b.setFont(new Font("Tahoma", Font.BOLD, 25));

        

        b.setBounds(475,600,400,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        

        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(90,50);

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b){
        f.setVisible(false);
        Login_user loginUser = new Login_user();
        loginUser.setVisible(true);
    }
}

    public static void main(String[] arg){
        Front_Page f = new Front_Page();
    }
}