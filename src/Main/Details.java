package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import javax.swing.text.*;


public class Details extends JFrame implements ActionListener {
   JTextField tfAge, tfWeight,tfHeight;
   JButton calc,cancel;
   PlainDocument doc,dop,dok;
    JComboBox<String> bloodGroupComboBox,genderComboBox;



    Details()
    {
        setSize(1000,750);
        setLocation(250,30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/data.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);


        JLabel heading = new JLabel("BODY DETAILS :");
        heading.setBounds(100,50,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


       JLabel lblgender = new JLabel("Gender ");
       lblgender.setBounds(135,150,100,50);
        lblgender.setFont(new Font("serif",Font.BOLD,20));
        add(lblgender);

        String[] genderOptions = {"Male", "Female"};
        genderComboBox = new JComboBox<>(genderOptions);
        genderComboBox.setBounds(300, 160, 150, 27);// Adjust the size as needed
        genderComboBox.setBackground(Color.WHITE);
        genderComboBox.addActionListener(this);
        add(genderComboBox);

        JLabel lblAge = new JLabel(" Age (in Years) ");
        lblAge.setBounds(130,190,200,50);
        lblAge.setFont(new Font("serif",Font.BOLD,20));
        add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(300,205,150,27);
        tfAge.addActionListener(this);
        add(tfAge);

        doc = (PlainDocument) tfAge.getDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });



        JLabel lblWeight = new JLabel(" Weight(in Kg) ");
        lblWeight.setBounds(130,230,200,50);
        lblWeight.setFont(new Font("serif",Font.BOLD,20));
        add(lblWeight);

        tfWeight = new JTextField();
        tfWeight.setBounds(300,245,150,27);
        tfWeight.addActionListener(this);
        add(tfWeight);


        dop = (PlainDocument) tfWeight.getDocument();

        dop.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        JLabel lblHeight = new JLabel(" Height(in cm) ");
        lblHeight.setBounds(130,270,200,50);
        lblHeight.setFont(new Font("serif",Font.BOLD,20));
        add(lblHeight);

        tfHeight = new JTextField();
        tfHeight.setBounds(300,285,150,27);
        tfHeight.addActionListener(this);
        add(tfHeight);


        dok = (PlainDocument) tfHeight.getDocument();

        dok.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        JLabel lblgroup = new JLabel("Blood Group");
        lblgroup.setBounds(130, 310, 200, 50);
        lblgroup.setFont(new Font("serif", Font.BOLD, 20));
        add(lblgroup);

        String[] bloodGroupOptions = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        bloodGroupComboBox = new JComboBox<>(bloodGroupOptions);
        bloodGroupComboBox.setBounds(300, 325, 150, 27);
        bloodGroupComboBox.setBackground(Color.WHITE);
        bloodGroupComboBox.addActionListener(this);
        add(bloodGroupComboBox);


        calc = new JButton("Calculate BMI and get Diet ");
        calc.setBounds(400, 510, 500, 50);
        calc.setFont(new Font("serif", Font.BOLD, 20));
        calc.addActionListener(this);
        add(calc);


        cancel = new JButton("Cancel");
        cancel.setBounds(150, 510, 200, 50);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        cancel.addActionListener(this);
        add(cancel);



        add(image);
        setVisible(true);





    }








    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calc) {
            String gender = (String) genderComboBox.getSelectedItem();
            int age = Integer.parseInt(tfAge.getText());
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText());
            String bloodGroup = String.valueOf(bloodGroupComboBox.getSelectedItem());

            // Calculate BMI
            double bmi = calculateBMI(weight, height);

            // Determine BMI category
            String bmiCategory = determineBMICategory(bmi);

            // Create a new frame to display BMI and diet plan image
            JFrame resultFrame = new JFrame("BMI Result and Diet Plan");
            resultFrame.setSize(1000, 750);
            resultFrame.setLocation(250, 30);
            resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel resultPanel = new JPanel();
            resultPanel.setLayout(new FlowLayout());

            JLabel resultLabel = new JLabel("Your BMI is: " + bmi + " (" + bmiCategory + " category)");
            resultLabel.setFont(new Font("serif", Font.BOLD, 20));
            resultPanel.add(resultLabel);

            // Display diet plan image based on BMI category
            JLabel dietImageLabel = new JLabel("Diet Plan:");
            ImageIcon dietImage;

            if (bmiCategory.equals("Underweight")) {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gain.png"));
                Image i2 = i1.getImage().getScaledInstance(930, 700,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                resultPanel.add(image);
            } else if (bmiCategory.equals("Normal Weight")) {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gain.png"));
                Image i2 = i1.getImage().getScaledInstance(1550,700,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                resultPanel.add(image);
            } else if (bmiCategory.equals("Overweight")) {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/veg.jpg"));
                Image i2 = i1.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                resultPanel.add(image);
            } else {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/veg.jpg"));
                Image i2 = i1.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                resultPanel.add(image);
            }


            resultFrame.add(resultPanel);
            resultFrame.setVisible(true);
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }



    public double calculateBMI(double weight, double height) {
        // Calculate BMI using the formula: BMI = weight (kg) / (height (m) * height (m)
        double bmi = weight * 10000 / (height * height);

        // Format BMI to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(bmi));
    }


    public String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }



    public static void main(String args[])
    {
        SwingUtilities.invokeLater(() -> {
            new Details();
        });
    }

}
