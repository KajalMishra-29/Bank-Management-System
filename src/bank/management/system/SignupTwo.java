package bank.management.system;

import bank.management.system.JIntegerField.JIntegerTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    String formNo;
    JComboBox<String> religionOptions, categoryOptions, incomeOptions, educationOptions, occupationOptions;
    JTextField panNoField;
    JIntegerTextField adharNoField;
    JRadioButton seniorYes, seniorNo, existingAccYes, existingAccNo;
    ButtonGroup seniorCitizenGroup, existingAccGroup;
    JButton next;

    SignupTwo(String num){
        super("APPLICATION FORM");

        setSize(850,750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(360,80);
        getContentPane().setBackground(new Color(224, 229, 206));


        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank-logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,20,100,100);
        add(image);

        // form number
        this.formNo = num;
        JLabel applicationNo = new JLabel("APPLICATION  NO.  "+ formNo);
        applicationNo.setBounds(300,5,600,100);
        applicationNo.setForeground(Color.BLACK);
        applicationNo.setFont(new Font("Raleway", Font.BOLD, 25));
        add(applicationNo);


        // page 2 : Additional Details
        JLabel page = new JLabel("page 2 : ");
        page.setFont(new Font("Thoma", Font.BOLD, 25));
        page.setBounds(300,80,120,40);
        page.setForeground(Color.BLACK);
        add(page);

        JLabel personalInfo = new JLabel("Additional Details");
        personalInfo.setFont(new Font("Thoma", Font.BOLD, 25));
        personalInfo.setBounds(410,80,300,40);
        personalInfo.setForeground(Color.BLACK);
        add(personalInfo);

        // religion
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Thoma", Font.BOLD, 18));
        religion.setBounds(100,160,150,30);
        religion.setForeground(Color.BLACK);
        add(religion);

        String[] religions = {"Hindu","Muslim","Sikh","Christian","Jain","Buddhism","Other"};
        religionOptions = new JComboBox<>(religions);
        religionOptions.setSelectedIndex(0);
        religionOptions.setBounds(300,160,400,30);
        religionOptions.setForeground(Color.BLACK);
        religionOptions.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(religionOptions);

        // category
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Thoma", Font.BOLD, 18));
        category.setBounds(100,210,150,30);
        category.setForeground(Color.BLACK);
        add(category);

        String[] categories = {"General","OBC","SC","ST","EWS","Other"};
        categoryOptions = new JComboBox<>(categories);
        categoryOptions.setSelectedIndex(0);
        categoryOptions.setBounds(300,210,400,30);
        categoryOptions.setForeground(Color.BLACK);
        categoryOptions.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(categoryOptions);

        // Income
        JLabel AnnualIncome = new JLabel("Annual Income : ");
        AnnualIncome.setFont(new Font("Thoma", Font.BOLD, 18));
        AnnualIncome.setBounds(100,260,150,30);
        AnnualIncome.setForeground(Color.BLACK);
        add(AnnualIncome);

        String[] incomes = {"Null","<1,50,000","1,50,000 - 3,50,000","3,50,000 - 7,00,000","7,00,000 - 10,00,000","> 10,00,000", "> 20,00,000",">50,00,000",">1,00,00,000"};
        incomeOptions = new JComboBox<>(incomes);
        incomeOptions.setSelectedIndex(0);
        incomeOptions.setBounds(300,260,400,30);
        incomeOptions.setForeground(Color.BLACK);
        incomeOptions.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(incomeOptions);

        // educational
        JLabel education = new JLabel("Education : ");
        education.setFont(new Font("Thoma", Font.BOLD, 18));
        education.setBounds(100,310,150,30);
        education.setForeground(Color.BLACK);
        add(education);

        String[] educations = {"Graduate","School(pursuing)","Graduation(Pursuing)","Post-Graduate","Doctorate","Lawyer", "Others"};
        educationOptions = new JComboBox<>(educations);
        educationOptions.setSelectedIndex(0);
        educationOptions.setBounds(300,310,400,30);
        educationOptions.setForeground(Color.BLACK);
        educationOptions.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(educationOptions);

        // occupation
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Thoma", Font.BOLD, 18));
        occupation.setBounds(100,360,150,30);
        occupation.setForeground(Color.BLACK);
        add(occupation);

        String[] occupations = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationOptions = new JComboBox<>(occupations);
        occupationOptions.setSelectedIndex(0);
        occupationOptions.setBounds(300,360,400,30);
        occupationOptions.setForeground(Color.BLACK);
        occupationOptions.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(occupationOptions);

        // occupation
        JLabel panNo = new JLabel("PAN Number : ");
        panNo.setFont(new Font("Thoma", Font.BOLD, 18));
        panNo.setBounds(100,410,150,30);
        panNo.setForeground(Color.BLACK);
        add(panNo);

        panNoField = new JTextField();
        panNoField.setFont(new Font("Thoma", Font.PLAIN, 18));
        panNoField.setBounds(300,410,400,30);
        panNoField.setForeground(Color.BLACK);
        add(panNoField);

        // Aadhaar card number
        JLabel adharNo = new JLabel("Aadhar Number : ");
        adharNo.setFont(new Font("Thoma", Font.BOLD, 18));
        adharNo.setBounds(100,460,200,30);
        adharNo.setForeground(Color.BLACK);
        add(adharNo);

        adharNoField = new JIntegerTextField();
        adharNoField.setFont(new Font("Thoma", Font.PLAIN, 18));
        adharNoField.setBounds(300,460,400,30);
        adharNoField.setForeground(Color.BLACK);
        add(adharNoField);

        // Senior citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Thoma", Font.BOLD, 18));
        seniorCitizen.setBounds(100,510,200,30);
        seniorCitizen.setForeground(Color.BLACK);
        add(seniorCitizen);

        seniorYes = new JRadioButton("YES");
        seniorYes.setFont(new Font("Thoma", Font.PLAIN, 18));
        seniorYes.setBounds(300, 510, 200, 30);
        seniorYes.setForeground(Color.BLACK);
        seniorYes.setBackground(new Color(224, 229, 206));
        add(seniorYes);

        seniorNo = new JRadioButton("NO");
        seniorNo.setFont(new Font("Thoma", Font.PLAIN, 18));
        seniorNo.setBounds(500, 510, 200, 30);
        seniorNo.setForeground(Color.BLACK);
        seniorNo.setBackground(new Color(224, 229, 206));
        add(seniorNo);

        seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorYes);
        seniorCitizenGroup.add(seniorNo);

        // Existing aaccount
        JLabel existingAcc = new JLabel("Existing Account : ");
        existingAcc.setFont(new Font("Thoma", Font.BOLD, 18));
        existingAcc.setBounds(100,560,200,30);
        existingAcc.setForeground(Color.BLACK);
        add(existingAcc);

        existingAccYes = new JRadioButton("YES");
        existingAccYes.setFont(new Font("Thoma", Font.PLAIN, 18));
        existingAccYes.setBounds(300, 560, 200, 30);
        existingAccYes.setForeground(Color.BLACK);
        existingAccYes.setBackground(new Color(224, 229, 206));
        add(existingAccYes);

        existingAccNo = new JRadioButton("NO");
        existingAccNo.setFont(new Font("Thoma", Font.PLAIN, 18));
        existingAccNo.setBounds(500, 560, 200, 30);
        existingAccNo.setForeground(Color.BLACK);
        existingAccNo.setBackground(new Color(224, 229, 206));
        add(existingAccNo);

        existingAccGroup = new ButtonGroup();
        existingAccGroup.add(existingAccYes);
        existingAccGroup.add(existingAccNo);

        // button
        next = new JButton("NEXT");
        next.setFont(new Font("Thoma",Font.BOLD,18));
        next.setBounds(570,630,130,40);
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
        // extracting data

        String religion = (String)religionOptions.getSelectedItem();
        String category = (String)categoryOptions.getSelectedItem();
        String income = (String)incomeOptions.getSelectedItem();
        String education = (String)educationOptions.getSelectedItem();
        String occupation = (String)occupationOptions.getSelectedItem();
        String pan = panNoField.getText();
        String aadhar = adharNoField.getText();

        String senior_citizen = null;
        if(seniorYes.isSelected()){
            senior_citizen = "yes";
        }else{
            senior_citizen = "no";
        }

        String existingAcc = null;
        if(existingAccYes.isSelected()){
            existingAcc = "yes";
        }else{
            existingAcc = "no";
        }

        // storing data
        try{
            if(panNoField.getText().equals("") || adharNoField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill the required fields");
            }else{
                // form connection
                Conn conn = new Conn();
                // query
                String q = "insert into SignupTwo values('"+formNo+"' , '"+religion+"' , '"+category+"' , '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"' , '"+senior_citizen+"' , '"+existingAcc+"')";
                // executing the query
                conn.statement.executeUpdate(q);

                setVisible(false);
                new SignupThree(formNo);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
