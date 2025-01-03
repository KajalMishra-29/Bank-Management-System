package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit , withdraw , fastCash , miniStatement , pinChange , balanceEnq , exit;
    String pinNo;

    Transaction(String pinNo){

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

        JLabel l1 = new JLabel("Please select your Transaction");
        l1.setBounds(225,300,700,45);
        img.add(l1); // to show text above image
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,17));

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        img.add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        img.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        img.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        img.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        img.add(pinChange);

        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(355,485,150,30);
        balanceEnq.addActionListener(this);
        img.add(balanceEnq);

        exit = new JButton("Exit");
        exit.setBounds(170,520,150,30);
        exit.addActionListener(this);
        img.add(exit);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNo);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pinNo);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNo);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNo);
        }else if(ae.getSource() == balanceEnq){
            setVisible(false);
            new BalanceEnquiry(pinNo);
        }else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNo);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
