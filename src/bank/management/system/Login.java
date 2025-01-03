package bank.management.system;

import bank.management.system.JIntegerField.JIntegerPasswordField;
import bank.management.system.JIntegerField.JIntegerTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel title;
    JLabel cardNo;
    JLabel pin;
    JIntegerTextField cardNoField;
    JIntegerPasswordField pinField;
    JButton signIn;
    JButton clear;
    JButton signUp;

    Login(){
        super("Bank Management System");
        setSize(850,480);
        setLocation(350,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // getContentPane().setBackground(new Color(231,251,230));
        getContentPane().setBackground(Color.WHITE);

        // bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank-logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(150,10,100,100);
        add(image);

        // bottom image
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);

        JLabel image2 = new JLabel(ii3);
        image2.setBounds(690,350,100,100);
        add(image2);

        // title
        title = new JLabel("BANK OF INDIA");
        title.setForeground(Color.BLACK);
        title.setBounds(300, 10,500,100);
        title.setFont(new Font("Thoma",Font.BOLD,45));
        add(title);

        // card number
        cardNo = new JLabel("Card No : ");
        cardNo.setBounds(150,150,200,40);
        cardNo.setForeground(Color.BLACK);
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardNo);

        cardNoField = new JIntegerTextField();
        cardNoField.setBounds(330,150,300,40);
        cardNoField.setForeground(Color.BLACK);
        cardNoField.setFont(new Font("Raleway",Font.PLAIN,18));
        add(cardNoField);

        // password
        pin = new JLabel("PIN : ");
        pin.setBounds(150,210,200,40);
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        pinField = new JIntegerPasswordField();
        pinField.setBounds(330,210,300,40);
        pinField.setForeground(Color.BLACK);
        pinField.setFont(new Font("Raleway",Font.PLAIN,18));
        add(pinField);

        // buttons
        // signIn
        signIn = new JButton("SIGN IN");
        signIn.setForeground(Color.WHITE);
        signIn.setFont(new Font("Thoma",Font.BOLD,18));
        signIn.setBackground(Color.BLACK);
        signIn.setBounds(330,300,140,40);
        signIn.setFocusPainted(false);
        signIn.setFocusable(false);
        signIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        signIn.addActionListener(this);
        add(signIn);

        // clear
        clear = new JButton("CLEAR");
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Thoma",Font.BOLD,18));
        clear.setBackground(Color.BLACK);
        clear.setBounds(490,300,140,40);
        clear.setFocusPainted(false);
        clear.setFocusable(false);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        clear.addActionListener(this);
        add(clear);

        // signUp
        signUp = new JButton("SIGN UP");
        signUp.setFont(new Font("Thoma",Font.BOLD,18));
        signUp.setBounds(400,370,140,40);
        signUp.setFocusPainted(false);
        signUp.setFocusable(false);
        signUp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        signUp.addActionListener(this);
        add(signUp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == clear){
                cardNoField.setText("");
                pinField.setText("");
            }else if(e.getSource() == signIn){
                Conn conn = new Conn();

                String cardNo = cardNoField.getText();
                String pinNo = pinField.getText();

                // empty cardNo or pin
                if(cardNo.equals("")){
                    JOptionPane.showMessageDialog(null,"Card Number is required");
                    return;
                } else if (pinNo.equals("")) {
                    JOptionPane.showMessageDialog(null,"PIN is required");
                    return;
                }

                String q = "select * from login where card_no = '"+cardNo+"' and pin = '"+pinNo+"'";
                try{
                    ResultSet rs = conn.statement.executeQuery(q);
                    if(rs.next()){ // if rs has some data -> user login successfully
                        setVisible(false); // close login frame
                        new Transaction(pinNo);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect CardNo or PIN");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }

            }else if(e.getSource() == signUp){
                setVisible(false);
                new SignupOne();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
