package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    JButton c1 , c2 , c3 , c4 , c5 , c6 , back;
    String pinNo;

    FastCash(String pinNo){

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

        JLabel l1 = new JLabel("Select withdrawal amount");
        l1.setBounds(225,300,700,45);
        img.add(l1); // to show text above image
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,17));

        c1 = new JButton("Rs 500");
        c1.setBounds(170,415,150,30);
        c1.addActionListener(this);
        img.add(c1);

        c2 = new JButton("Rs 1000");
        c2.setBounds(355,415,150,30);
        c2.addActionListener(this);
        img.add(c2);

        c3 = new JButton("Rs 1500");
        c3.setBounds(170,450,150,30);
        c3.addActionListener(this);
        img.add(c3);

        c4 = new JButton("Rs 2000");
        c4.setBounds(355,450,150,30);
        c4.addActionListener(this);
        img.add(c4);

        c5 = new JButton("Rs 5000");
        c5.setBounds(170,485,150,30);
        c5.addActionListener(this);
        img.add(c5);

        c6 = new JButton("Rs 10000");
        c6.setBounds(355,485,150,30);
        c6.addActionListener(this);
        img.add(c6);

        back = new JButton("Back");
        back.setBounds(170,520,150,30);
        back.addActionListener(this);
        img.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNo);
        }else{
            String amt = ((JButton)ae.getSource()).getText(); // Rs 500
            amt = amt.substring(3);

            try{
                Conn conn = new Conn();
                // check if balance is available
                ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinNo+"'");
                int balance = 0;
                while(rs.next()){ // loop the returned rows
                    if(rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{ // withdrawal
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(balance < Integer.parseInt(amt) && ae.getSource()!=back){
                    // withdrawal not possible if balance < amount
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }else{
                    // withdraw
                    Date date = new Date();
                    String q = "Insert into bank values('"+pinNo+"','"+date+"','withdraw','"+amt+"')";
                    conn.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs "+amt+" Debited Successfully");

                    setVisible(false);
                    new Transaction(pinNo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

