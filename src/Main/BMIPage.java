package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIPage extends JFrame {
    private JTextField weightField, heightField;
    private JLabel resultLabel, dietImageLabel;

    public BMIPage() {
        // Set up the JFrame
        setTitle("BMI Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        weightField = new JTextField(10);
        heightField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate BMI");
        resultLabel = new JLabel("");
        dietImageLabel = new JLabel();

        // Add components to input panel
        inputPanel.add(new JLabel("Weight (kg):"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Height (m):"));
        inputPanel.add(heightField);

        // Add input panel to the frame
        add(inputPanel, BorderLayout.NORTH);

        // Add action listener to calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        // Add calculate button and result label to the frame
        add(calculateButton, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        add(dietImageLabel, BorderLayout.WEST);

        setVisible(true);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height * height);

            String result;
            if (bmi < 18.5) {
                result = "Underweight";
                dietImageLabel.setIcon(new ImageIcon("icons/abc4.png"));
            } else if (bmi < 24.9) {
                result = "Normal Weight";
                dietImageLabel.setIcon(new ImageIcon("icons/user.jpg"));
            } else if (bmi < 29.9) {
                result = "Overweight";
                dietImageLabel.setIcon(new ImageIcon("icons/update.png"));
            } else {
                result = "Obese";
                dietImageLabel.setIcon(new ImageIcon("icons/viewcustomer.jpg"));
            }

            resultLabel.setText("BMI: " + String.format("%.2f", bmi) + " - " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid weight and height values.");
            dietImageLabel.setIcon(null);
        }
    }


    /*
    public void displayDietPlanImage(String bmiCategory) {
        // Load and display diet plan image based on the BMI category.
        // You can use an image panel or label to display the image.
        // Here's a simplified example of how to set an image to a JLabel:

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/salad.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        add(image);
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("icons/salad" + bmiCategory + ".jpg");
        imagePanel.removeAll(); // Clear previous image
        imagePanel.add(new JLabel(imageIcon));
        imagePanel.revalidate();
        imagePanel.repaint();

    }
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMIPage();
            }
        });
    }
}
