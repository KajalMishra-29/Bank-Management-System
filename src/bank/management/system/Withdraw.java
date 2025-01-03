package bank.management.system;

import bank.management.system.JIntegerField.JIntegerTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener{
    JButton withdraw, back;
    JIntegerTextField amount;
    String pinNo;

    Withdraw(String pinNo){

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

        JLabel l1 = new JLabel("Enter the amount you want to withdraw");
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
        withdraw = new JButton(("Withdraw"));
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        img.add(withdraw);

        back = new JButton(("Back"));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        img.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw){
            String amt = amount.getText();

            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                // check if balance is available
                try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinNo+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if(balance < Integer.parseInt(amt) && ae.getSource()!=back){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }else{
                        Date date = new Date();
                        String q = "insert into bank values('"+pinNo+"','"+date+"','withdraw','"+amt+"')";
                        conn.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Rs "+amt+" withdrawal successfully");

                        setVisible(false);
                        new Transaction(pinNo);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNo);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}

