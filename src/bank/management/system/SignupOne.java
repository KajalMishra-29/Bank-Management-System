package bank.management.system;

import bank.management.system.JIntegerField.JIntegerTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    // generating random number
    Random rand = new Random();
    int random = Math.abs(rand.nextInt(9000)) + 1000;
    String formNum = "" + random;

    JTextField nameField;
    JTextField fatherNameField;
    JTextField emailField;
    JDateChooser dateChooser;
    JRadioButton male, female;
    JTextField addressField;
    JTextField stateField;
    JTextField cityField;
    JIntegerTextField pinCodeField;
    JRadioButton married, unmarried, others;
    JButton next;

    ButtonGroup genderGroup;
    ButtonGroup maritalGroup;

    SignupOne(){
        super("APPLICATION FORM");
        setSize(850,850);
        setLocation(360,40);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(218,255,251));

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank-logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        // application no. title
        JLabel applicationNo = new JLabel("APPLICATION  NO.  "+ formNum);
        applicationNo.setBounds(170,20,600,100);
        applicationNo.setForeground(Color.BLACK);
        applicationNo.setFont(new Font("Raleway", Font.BOLD, 45));
        add(applicationNo);

        JLabel page = new JLabel("page 1 : ");
        page.setFont(new Font("Thoma", Font.BOLD, 25));
        page.setBounds(300,120,150,40);
        page.setForeground(Color.BLACK);
        add(page);

        JLabel personalInfo = new JLabel("Personal Details");
        personalInfo.setFont(new Font("Thoma", Font.BOLD, 25));
        personalInfo.setBounds(420,120,300,40);
        personalInfo.setForeground(Color.BLACK);
        add(personalInfo);

        // name
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Thoma", Font.BOLD, 18));
        name.setBounds(100,210,100,30);
        name.setForeground(Color.BLACK);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Thoma", Font.PLAIN, 18));
        nameField.setBounds(300,210,400,30);
        nameField.setForeground(Color.BLACK);
        add(nameField);

        // father's name
        JLabel fatherName = new JLabel("Father's Name : ");
        fatherName.setFont(new Font("Thoma", Font.BOLD, 18));
        fatherName.setBounds(100,260,200,30);
        fatherName.setForeground(Color.BLACK);
        add(fatherName);

        fatherNameField = new JTextField();
        fatherNameField.setFont(new Font("Thoma", Font.PLAIN, 18));
        fatherNameField.setBounds(300,260,400,30);
        fatherNameField.setForeground(Color.BLACK);
        add(fatherNameField);

        // gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Thoma", Font.BOLD, 18));
        gender.setBounds(100,310,100,30);
        gender.setForeground(Color.BLACK);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Thoma", Font.PLAIN, 18));
        male.setBounds(300,310,100,30);
        male.setForeground(Color.BLACK);
        male.setBackground(new Color(218,255,251));
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Thoma", Font.PLAIN, 18));
        female.setBounds(450,310,100,30);
        female.setForeground(Color.BLACK);
        female.setBackground(new Color(218,255,251));
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // date of birth
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Thoma", Font.BOLD, 18));
        dob.setBounds(100,360,200,30);
        dob.setForeground(Color.BLACK);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,360,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(dateChooser);

        // email
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Thoma", Font.BOLD, 18));
        email.setBounds(100,410,100,30);
        email.setForeground(Color.BLACK);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Thoma", Font.PLAIN, 18));
        emailField.setBounds(300,410,400,30);
        emailField.setForeground(Color.BLACK);
        add(emailField);

        // marital status
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Thoma", Font.BOLD, 18));
        marital.setBounds(100,460,200,30);
        marital.setForeground(Color.BLACK);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Thoma", Font.PLAIN, 18));
        married.setBounds(300,460,100,30);
        married.setForeground(Color.BLACK);
        married.setBackground(new Color(218,255,251));
        add(married);

        unmarried =  new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Thoma", Font.PLAIN, 18));
        unmarried.setBounds(450,460,150,30);
        unmarried.setForeground(Color.BLACK);
        unmarried.setBackground(new Color(218,255,251));
        add(unmarried);

        others = new JRadioButton("Others");
        others.setFont(new Font("Thoma", Font.PLAIN, 18));
        others.setBounds(600,460,100,30);
        others.setForeground(Color.BLACK);
        others.setBackground(new Color(218,255,251));
        add(others);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(others);

        // address
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Thoma", Font.BOLD, 18));
        address.setBounds(100,510,100,30);
        address.setForeground(Color.BLACK);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Thoma", Font.PLAIN, 18));
        addressField.setBounds(300,510,400,30);
        addressField.setForeground(Color.BLACK);
        add(addressField);


        // city
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Thoma", Font.BOLD, 18));
        city.setBounds(100,560,100,30);
        city.setForeground(Color.BLACK);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Thoma", Font.PLAIN, 18));
        cityField.setBounds(300,560,400,30);
        cityField.setForeground(Color.BLACK);
        add(cityField);

        // pin code
        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Thoma", Font.BOLD, 18));
        pinCode.setBounds(100,610,100,30);
        pinCode.setForeground(Color.BLACK);
        add(pinCode);

        pinCodeField = new JIntegerTextField();
        pinCodeField.setFont(new Font("Thoma", Font.PLAIN, 18));
        pinCodeField.setBounds(300,610,400,30);
        pinCodeField.setForeground(Color.BLACK);
        add(pinCodeField);

        // state
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Thoma", Font.BOLD, 18));
        state.setBounds(100,660,100,30);
        state.setForeground(Color.BLACK);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Thoma", Font.PLAIN, 18));
        stateField.setBounds(300,660,400,30);
        stateField.setForeground(Color.BLACK);
        add(stateField);

        // button
        next = new JButton("NEXT");
        next.setFont(new Font("Thoma",Font.BOLD,18));
        next.setBounds(570,730,130,40);
        next.setFocusPainted(false);
        next.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == next){
               String formNo =  formNum;
               String name = nameField.getText().trim();
               String fName = fatherNameField.getText().trim();
               String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

               String gender = "";
               if(male.isSelected()){
                   gender = "male";
               }else if(female.isSelected()){
                   gender = "female";
               }

               String email = emailField.getText().trim();
               String marital = "";
               if(married.isSelected()){
                   marital = "married";
               }else if(unmarried.isSelected()){
                   marital = "unmarried";
               }else if(others.isSelected()){
                   marital = "others";
               }

               String address = addressField.getText().trim();
               String city = cityField.getText().trim();
               String state = stateField.getText().trim();
               String pinCode = pinCodeField.getText().trim();

               // store all this extracted data into database
                try{
                    if(name.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Name Field is required");
                        return;
                    } else if (fName.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Father's Name is required");
                        return;
                    }else if(genderGroup.getSelection() == null){
                        JOptionPane.showMessageDialog(null,"Gender is required");
                        return;
                    }else if(dob.isEmpty()){
                        JOptionPane.showMessageDialog(null,"DOB is required");
                        return;
                    }else if(email.isEmpty()){
                        JOptionPane.showMessageDialog(null,"email is required");
                        return;
                    }else if(maritalGroup.getSelection() == null){
                        JOptionPane.showMessageDialog(null,"Marital Status is required");
                        return;
                    }else if(address.isEmpty() || city.trim().isEmpty() || state.trim().isEmpty() || pinCode.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill out the required fields");
                        return;
                    }

                    // insert into database
                    else{
                        Conn conn = new Conn();
                        String q = "insert into signup values('"+formNo+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                        conn.statement.executeUpdate(q);

                        setVisible(false);
                        new SignupTwo(formNo);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
