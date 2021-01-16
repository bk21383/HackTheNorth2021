package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// calls method when button is pressed
public class ButtonListener implements ActionListener  {

    // MODIFIES: Month, frame
    // EFFECTS: when any button is pressed, runs appropriate method
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton but = (JButton) source;
            // TODO: COMPLETE
        }
    }
}
