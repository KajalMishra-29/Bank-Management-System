package bank.management.system.JIntegerField;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JIntegerTextField extends JTextField {

    // constructor
    public JIntegerTextField(){
        super();

        // add a key Listener to restrict input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char ch = evt.getKeyChar();

                // if the typed character is not digit, consume the evenet
                if(!Character.isDigit(ch)){
                    evt.consume(); // Prevent the character from being typed
                }
            }
        });
    }
}


// The method addKeyListener is used to attach a KeyListener
// to a component like a JTextField, JButton, or any other swing component

//textField.addKeyListener(new KeyAdapter() {
//    @Override
//    public void keyTyped(KeyEvent e) {
//        // Handle the key typed event here
//    }
//});

// KeyAdapter is an adapter class that provides
// empty implementations of the KeyListener interface methods

// Instead of implementing every method from the KeyListener
// interface, KeyAdapter allows you to focus only on the method you need.

// Less Code: You don’t need to implement unused methods
// like keyPressed or keyReleased if you're only interested in keyTyped