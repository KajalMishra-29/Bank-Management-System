package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNo;
    BalanceEnquiry(String pinNo){

        this.pinNo = pinNo;

        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,1070, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        img.add(back);

        // extracting balance from database
        int balance = 0;
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinNo+"'");
            balance = 0;
            while(rs.next()){
                if(rs.getString("Type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Your current account balance is : ");
        l1.setForeground(Color.WHITE);
        l1.setBounds(180,300,400,30);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        img.add(l1);

        JLabel l2 = new JLabel(balance +" Rs");
        l2.setForeground(Color.WHITE);
        l2.setBounds(270,350,200,40);
        l2.setFont(new Font("Raleway",Font.BOLD,38));
        img.add(l2);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinNo);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
