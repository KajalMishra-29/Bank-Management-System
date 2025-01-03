package bank.management.system;

import bank.management.system.JIntegerField.JIntegerTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit, back;
    JIntegerTextField amount;
    String pinNo;

    Deposit(String pinNo){

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

        JLabel l1 = new JLabel("Enter the amount you want to deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 17));
        l1.setBounds(170,300,400,20);
        img.add(l1);

        amount = new JIntegerTextField();
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,30);
        img.add(amount);

        // buttons
        deposit = new JButton(("Deposit"));
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        img.add(deposit);

        back = new JButton(("Back"));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        img.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                String q = "insert into bank values('"+pinNo+"','"+date+"','deposit','"+amt+"')";
                try {
                    Conn conn = new Conn();
                    conn.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs "+amt+" deposited successfully");
                    setVisible(false);
                    new Transaction(pinNo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNo);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
