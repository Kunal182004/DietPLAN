package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Page  extends JFrame implements ActionListener{

    Page()
    {
        setSize(1550,850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/header1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        JMenuBar mb = new JMenuBar();


        // Create an empty panel to push the menus to the top right side
        JPanel emptyPanel = new JPanel();
        emptyPanel.setOpaque(false);
        mb.add(Box.createHorizontalGlue()); // Push menus to the right
        mb.add(emptyPanel);

        JMenu MakeDiet = new JMenu(" Make Diet");
        MakeDiet.setForeground(Color.BLUE);
        MakeDiet.setSize(250,250);

        mb.add(MakeDiet);

        JMenuItem VEG = new JMenuItem("Vegetarian");
        VEG.setBackground(Color.WHITE);
        VEG.addActionListener(this);
        MakeDiet.add(VEG);


        JMenuItem NONVEG = new JMenuItem("Non Vegetarian ");
       NONVEG.setBackground(Color.WHITE);
        NONVEG.addActionListener(this);
        MakeDiet.add(NONVEG);

        JMenuItem VEGAN = new JMenuItem(" Vegan ");
       VEGAN.setBackground(Color.WHITE);
        VEGAN.addActionListener(this);
        MakeDiet.add(VEGAN);





        //utility

        JMenu tools = new JMenu(" Tools ");
     tools.setForeground(Color.RED);

        mb.add(tools);

        JMenuItem notepad = new JMenuItem("Note Pad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        tools.add(notepad);


        JMenuItem Calc = new JMenuItem("Calculator");
        Calc.setBackground(Color.WHITE);
        Calc.addActionListener(this);
        tools.add(Calc);


        //EXIT

        JMenu exit = new JMenu(" Exit ");
        exit.setForeground(Color.BLUE);

        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);



        // Increase the text height and set it to bold
        Font menuFont = new Font("Arial", Font.BOLD, 20); // You can adjust the size and style as needed
        MakeDiet.setFont(menuFont);
        tools.setFont(menuFont);
        exit.setFont(menuFont);
        setJMenuBar(mb);

        setVisible(true);
    }

  public void actionPerformed(ActionEvent ae)
  {
      String msg = ae.getActionCommand();
      if(msg.equals("Vegetarian"))
      {

         new Details();

      }
      else if(msg.equals("Non Vegetarian "))
      {
          new Details();

      }
      else if(msg.equals(" Vegan "))
      {
          new Details();

      }

      else if(msg.equals("Exit"))
      {
          setVisible(false);
      } else if (msg.equals("Calculator"))
      {
          try {
               Runtime.getRuntime().exec("Calc.exe");
          } catch (Exception e){

          }


      }else if (msg.equals("Note Pad"))
      {
          try {
              Runtime.getRuntime().exec("notepad.exe");
          } catch (Exception e){

          }


      }

  }


    public static void main(String args[])
    {

        new Page();
    }
}
