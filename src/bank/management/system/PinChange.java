package bank.management.system;

import bank.management.system.JIntegerField.JIntegerPasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PinChange extends JFrame implements ActionListener {
    JIntegerPasswordField newPin, rePin;
    JButton change, back;
    String pinNo;

    PinChange(String pinNo) {

        this.pinNo = pinNo;

        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 1070, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 17));
        l1.setBounds(250, 280, 500, 35);
        img.add(l1);

        JLabel l2 = new JLabel("New Pin : ");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 17));
        l2.setBounds(165, 320, 180, 25);
        img.add(l2);

        newPin = new JIntegerPasswordField();
        newPin.setForeground(Color.BLACK);
        newPin.setFont(new Font("Raleway", Font.BOLD, 17));
        newPin.setBounds(320, 320, 180, 25);
        img.add(newPin);

        JLabel l3 = new JLabel("Re-Enter new Pin : ");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 17));
        l3.setBounds(165, 360, 180, 25);
        img.add(l3);

        rePin = new JIntegerPasswordField();
        rePin.setForeground(Color.BLACK);
        rePin.setFont(new Font("Raleway", Font.BOLD, 17));
        rePin.setBounds(320, 360, 180, 25);
        img.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        img.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
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

        } else if (ae.getSource() == change) {
            char[] pinPasswordChars = newPin.getPassword();
            String nPin = new String(pinPasswordChars);
            // Immediately clear the pinPasswordChars array for security
            Arrays.fill(pinPasswordChars, ' ');

            char[] rPasswordChars = rePin.getPassword();
            String rPin = new String(rPasswordChars);
            Arrays.fill(pinPasswordChars, ' ');

            System.out.println(nPin);
            System.out.println(rPin);
            System.out.println(pinNo);
            // checks
            if (nPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the new pin");
                return;
            }
            if (rPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please renter the new pin");
                return;
            }
            if (!nPin.equals(rPin)) {
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }

            // changing pin in database in all the tables where pin is stored
            try {
                Conn conn = new Conn();
                String q1 = "update bank set pin = '" + nPin + "' where pin = '" + pinNo + "'";
                String q2 = "update login set pin = '" + nPin + "' where pin = '" + pinNo + "'";
                String q3 = "update signupThree set pin = '" + nPin + "' where pin = '" + pinNo + "'";
                conn.statement.executeUpdate(q1);
                conn.statement.executeUpdate(q2);
                conn.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(rPin); // updated pin

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
