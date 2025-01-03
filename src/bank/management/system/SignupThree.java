package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    String formNo;
    JRadioButton saving,fix,current,recurr;
    JCheckBox atmCard, internetBanking, mobileBanking, esAlerts, chequeBook, eStatement;
    JButton submit, cancel;
    JCheckBox agree;

    SignupThree(String formNo){
        super("APPLICATION FORM");

        this.formNo = formNo;

        setSize(859,800);
        setLayout(null);
        setLocation(360,40);
        getContentPane().setBackground(new Color(229, 217, 242));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/bank-logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,15,100,100);
        add(image);

        // application number
        JLabel applicationNo = new JLabel("APPLICATION NO. "+formNo);
        applicationNo.setBounds(300,5,600,100);
        applicationNo.setFont(new Font("Raleway", Font.BOLD,25));
        applicationNo.setForeground(Color.black);
        add(applicationNo);

        // page number
        JLabel page = new JLabel("Page 3 : ");
        page.setBounds(300,80,120,40);
        page.setFont(new Font("Thoma",Font.BOLD,25));
        page.setForeground(Color.black);
        add(page);

        // account details
        JLabel accountDetails = new JLabel("Account Details");
        accountDetails.setBounds(410,80,200,40);
        accountDetails.setFont(new Font("Thoma",Font.BOLD,25));
        accountDetails.setForeground(Color.black);
        add(accountDetails);

        // account type
        JLabel accountType = new JLabel("Account Type : ");
        accountType.setBounds(100,160,200,30);
        accountType.setFont(new Font("Thoma",Font.BOLD,18));
        accountType.setForeground(Color.black);
        add(accountType);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(100,200,200,30);
        saving.setBackground(new Color(229, 217, 242));
        saving.setFont(new Font("Thoma",Font.PLAIN,16));
        saving.setForeground(Color.BLACK);
        add(saving);

        fix = new JRadioButton("Fixed Deposit Account");
        fix.setBounds(350,200,300,30);
        fix.setBackground(new Color(229, 217, 242));
        fix.setFont(new Font("Thoma",Font.PLAIN,16));
        fix.setForeground(Color.BLACK);
        add(fix);

        current = new JRadioButton("Current Account");
        current.setBounds(100,240,200,30);
        current.setBackground(new Color(229, 217, 242));
        current.setFont(new Font("Thoma",Font.PLAIN,16));
        current.setForeground(Color.BLACK);
        add(current);

        recurr = new JRadioButton("Recurring Deposit Account");
        recurr.setBounds(350,240,300,30);
        recurr.setBackground(new Color(229, 217, 242));
        recurr.setFont(new Font("Thoma",Font.PLAIN,16));
        recurr.setForeground(Color.BLACK);
        add(recurr);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(saving);
        accountTypeGroup.add(current);
        accountTypeGroup.add(fix);
        accountTypeGroup.add(recurr);

        // card number
        JLabel cardNo = new JLabel("Card Number : ");
        cardNo.setBounds(100,320,200,30);
        cardNo.setFont(new Font("Thoma",Font.BOLD,18));
        cardNo.setForeground(Color.black);
        add(cardNo);

        JLabel l1 = new JLabel("(Your 16 digit Card Number)");
        l1.setFont(new Font("Thoma",Font.PLAIN,14));
        l1.setForeground(Color.BLACK);
        l1.setBounds(100,350,200,20);
        add(l1);

        JLabel l2 = new JLabel("XXXX-XXXX-XXXX-2910");
        l2.setFont(new Font("Thoma", Font.BOLD, 18));
        l2.setForeground(Color.BLACK);
        l2.setBounds(350,320,300,30);
        add(l2);

        JLabel l3 = new JLabel("(It would appear on ATM Card/ Cheque Book and Statement)");
        l3.setFont(new Font("Thoma", Font.PLAIN,14));
        l3.setForeground(Color.BLACK);
        l3.setBounds(350,350,500,20);
        add(l3);
        setVisible(true);

        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Thoma", Font.BOLD,18));
        pin.setForeground(Color.BLACK);
        pin.setBounds(100,390,100,30);
        add(pin);

        JLabel xxxx = new JLabel("XXXX");
        xxxx.setFont(new Font("Thoma", Font.BOLD,18));
        xxxx.setForeground(Color.BLACK);
        xxxx.setBounds(350,390,100,30);
        add(xxxx);

        JLabel l5 = new JLabel("(4-digit password)");
        l5.setFont(new Font("Thoma", Font.PLAIN,14));
        l5.setForeground(Color.BLACK);
        l5.setBounds(100,420,300,20);
        add(l5);

        // services required
        JLabel serviceReq = new JLabel("Services Required : ");
        serviceReq.setForeground(Color.BLACK);
        serviceReq.setFont(new Font("Thoma", Font.BOLD, 18));
        serviceReq.setBounds(100, 460, 200, 30);
        add(serviceReq);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(new Color(229, 217, 242));
        atmCard.setFont(new Font("Thoma", Font.PLAIN, 16));
        atmCard.setBounds(100,500,200,30);
        add(atmCard);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(new Color(229, 217, 242));
        mobileBanking.setFont(new Font("Thoma", Font.PLAIN, 16));
        mobileBanking.setBounds(350,500,200,30);
        add(mobileBanking);

        esAlerts = new JCheckBox("Email & SMS Alerts");
        esAlerts.setBackground(new Color(229, 217, 242));
        esAlerts.setFont(new Font("Thoma", Font.PLAIN, 16));
        esAlerts.setBounds(100,540,200,30);
        add(esAlerts);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(new Color(229, 217, 242));
        internetBanking.setFont(new Font("Thoma", Font.PLAIN, 16));
        internetBanking.setBounds(350,540,200,30);
        add(internetBanking);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(new Color(229, 217, 242));
        chequeBook.setFont(new Font("Thoma", Font.PLAIN, 16));
        chequeBook.setBounds(100,580,200,30);
        add(chequeBook);

        eStatement = new JCheckBox("E - Statement");
        eStatement.setBackground(new Color(229, 217, 242));
        eStatement.setFont(new Font("Thoma", Font.PLAIN, 16));
        eStatement.setBounds(350,580,200,30);
        add(eStatement);

        agree  = new JCheckBox("I here by declare that the above entered details are correct to the best of my knowledge",
                true);
        agree.setBackground(new Color(229, 217, 242));
        agree.setFont(new Font("Thoma", Font.PLAIN, 13));
        agree.setBounds(100,660,600,20);
        add(agree);

        // buttons
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Thoma",Font.BOLD,16));
        submit.setBounds(250,710,100,30);
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Thoma",Font.BOLD,16));
        cancel.setBounds(410,710,100,30);
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String accountType = "";
            if(saving.isSelected()){
                accountType = "saving account";
            }else if(fix.isSelected()){
                accountType = "fix deposit";
            }else if(current.isSelected()){
                accountType = "current account";
            }else if(recurr.isSelected()){
                accountType = "recurring deposit account";
            }

            // card number will be generated randomly
            Random ran = new Random();
            String cardNo = "" + (Math.abs(ran.nextLong() % 90000000L ) + 2929865000000000L);

            // pin number
            String pin = "" + (Math.abs(ran.nextLong() % 9000L) + 1000L);

            String services = "";
            if(atmCard.isSelected()){
                services += " ATM card ";
            }else if(internetBanking.isSelected()){
                services += " internet banking ";
            }else if(mobileBanking.isSelected()){
                services += " mobile banking ";
            }else if(esAlerts.isSelected()){
                services += " email & sms alerts ";
            }else if(chequeBook.isSelected()){
                services += " cheque book ";
            }else if(eStatement.isSelected()){
                services += "E-Statements";
            }

            // storing all these information into database
            // exception handling is necessary bcz database is an external entity
            // may give errors during run time
            try {
                // checks
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                    return;
                }else if(!agree.isSelected()){
                    JOptionPane.showMessageDialog(null, "Agree the following declaration");
                    return;
                }else {
                    Conn conn = new Conn();
                    String q = "insert into signupThree values('"+formNo+"','"+accountType+"','"+cardNo+"','"+pin+"','"+services+"')";

                    // also save card no. and pin in the login table
                    String q2 = "insert into login values('"+formNo+"','"+cardNo+"','"+pin+"')";

                    conn.statement.executeUpdate(q);
                    conn.statement.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "CARD NO : " + cardNo + "\nPIN : " + pin);
                }
                setVisible(false);
                new Deposit(pin);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(ae.getSource() == cancel){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
