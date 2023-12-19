package Main;
import javax.swing.*;
import java.awt.*;

// multithreading (Runnable interface ), inheritance properties
public class DietPlan extends JFrame implements Runnable{

    Thread t;
    DietPlan()
    {
        //Heading image
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/header.png"));
       Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       add(image);

       t = new Thread(this);
        t.start();
        //Showing frame
        setVisible(true);


        //
        int x = 1;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        for (int i = 2; i <= 600; i += 4, x += 1) {
            int xOffset = centerX - (i + x) / 2;
            int yOffset = centerY - i / 2;

            setLocation(xOffset-100, yOffset-100);
            setSize(i + 3 * x, i + x / 2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }



    }
    public void run()
    {
      try{
          Thread.sleep(5000);
          setVisible(false);

          //NextFrame
          new Login();
      } catch (Exception e){

      }
    }
    public static void main(String args[])
    {
           new DietPlan();
    }

}
