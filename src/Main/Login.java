package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login  extends JFrame implements ActionListener{

    JButton Login,Cancel,Register;
    JTextField  tfusername;
    JPasswordField  tfpassword;


    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);




        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

         Login = new JButton("login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        Login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(Login);



        Cancel = new JButton("Cancel");
        Cancel.setBounds(100,180,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(Cancel);



       Register = new JButton("Register");
      Register.setBounds(180,140,120,30);
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.WHITE);
        Register.addActionListener(this);
        Register.setFont(new Font("Tahoma",Font.BOLD,15));
        add(Register);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,5,200,200);
        add(image);



        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()== Login)
       {
           String susername = tfusername.getText();
           String spassword = tfpassword.getText();

           try
           {
              Conn c = new Conn();
              String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' ";

              ResultSet rs = c.s.executeQuery(query);


              if(rs.next())
              {
                 setVisible(false);
                 new Page();

              } else {
                  JOptionPane.showMessageDialog(null," Invalid Login");
                  tfusername.setText("");
                  tfpassword.setText("");
              }
           } catch (Exception e)
           {
               e.printStackTrace();
           }


       }
       else if(ae.getSource()== Cancel)
       {
        setVisible(false);
       }
       else if(ae.getSource()== Register)
       {
           setVisible(false);
           new Signup();
       }

    }

    public static void main(String args[])
    {
        new Login();
    }


}


