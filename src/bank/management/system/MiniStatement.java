package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    JButton close;
    String pinNo;

    MiniStatement(String pinNo){
        this.pinNo = pinNo;

        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel bankName = new JLabel("Bank of India");
        bankName.setBounds(150,40,100,20);
        add(bankName);

        JLabel cardNo = new JLabel();
        cardNo.setBounds(20,80,300,20);
        add(cardNo);

        close = new JButton("CLOSE");
        close.setBounds(270,540,90,30);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setBorderPainted(false);
        close.setFocusable(false);
        close.setFont(new Font("Raleway",Font.BOLD,14));
        close.addActionListener(this);
        add(close);


        try{
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from login where pin = '"+pinNo+"'");
            while(rs.next()){
                String num = rs.getString("card_no").substring(0,4)+"XXXXXXXX"+rs.getString("card_no").substring(12);
                cardNo.setText("Card Number : "+ num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinNo+"' ORDER BY date DESC LIMIT 5");
            while(rs.next()){
                mini.setText(
                        mini.getText() + "<html>" + rs.getString("date")
                                +"&nbsp;&nbsp;&nbsp;&nbsp;"+
                                rs.getString("type")
                                +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                                rs.getString("amount")
                                + "<br><br>"
                        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinNo+"'");
            int bal = 0;
            while(rs.next()){ // loop the returned rows
                if(rs.getString("type").equals("deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{ // withdrawal
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account balance is Rs "+bal);


        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close){
            setVisible(false);
            new Transaction(pinNo);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
