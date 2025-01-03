package bank.management.system.JIntegerField;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JIntegerPasswordField extends JPasswordField {
    public JIntegerPasswordField(){
        super();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char ch = evt.getKeyChar();
                if(!Character.isDigit(ch)){
                    evt.consume();
                }
            }
        });
    }
}
