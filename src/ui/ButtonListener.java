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
            String label = but.getText();
            if(label.equals("Add Person")) {
                Main.addPerson();
            }

            else if(label.equals("Add tag(s)")) {
                Main.addTags();
            }

            else if(label.equals("Delete person")) {
                Main.deletePerson();
            }

            else if(label.equals("Inclusive Search")) {
                Main.search(true);
            }

            else if(label.equals("Exclusive Search")) {
                Main.search(false);
            }

            else if(label.equals("Replace if any")) {
                Main.replaceIfAny();
            }

            else if(label.equals("Replace if all")) {
                Main.replaceIfAll();
            }

            else if(label.equals("Reset Search")) {
                Main.resetSearch();
            }

            else if(label.equals("Add Associate")) {
                Main.addAssociate();
            }

        }
    }
}
