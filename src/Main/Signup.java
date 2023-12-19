package Main;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener {
   JButton create ,back;
   JTextField username;
   JPasswordField password;
    Signup()
    {
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(20,30,650,300);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2)," Create Account ",TitledBorder.LEADING,TitledBorder.TOP,null));
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);


        JLabel heading = new JLabel(" Create Account");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);

        JLabel lblusername = new JLabel(" Username");
      lblusername.setBounds(100,100,140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260,100,150,20);
        panel.add(username);



        JLabel lblpassword = new JLabel(" Password");
        lblpassword.setBounds(100,140,140,20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblpassword);

       password = new JPasswordField();
        password.setBounds(260,140,150,20);
        panel.add(password);


        create = new JButton(" Create ");
       create.setBackground(Color.BLACK);
       create.setForeground(Color.WHITE);
       create.setBounds(160,200,120,35);
       create.addActionListener(this);
       panel.add(create);


        back = new JButton(" Back ");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,200,120,35);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/header.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,250,250);
        panel.add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()== create)
       {
            String susername = username.getText();
           String upassword = password.getText();

           try
           {
             Conn c = new Conn();
             String query = "insert into login values('"+susername+"','"+upassword+"')";

             c.s.executeUpdate(query);

             JOptionPane.showMessageDialog(null,"Account Created Successfully ");
             setVisible(false);
             new Login();


           } catch (Exception e)
           {
               e.printStackTrace();
           }

       } else if (ae.getSource()== back) {

           setVisible(false);
           new Login();

       }
    }
    public static void main(String args[])
    {
       new Signup();

    }
}
