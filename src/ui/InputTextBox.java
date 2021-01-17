package ui;

import javax.swing.*;
import java.awt.*;

// labelled text pane
public class InputTextBox extends JPanel {
    JLabel label;
    JTextPane text;

    // EFFECTS: builds label and text box on panel
    InputTextBox(String label, int width) {
        super();
        setLayout(new GridLayout(2, 1));
        this.label = new JLabel(label);
        setPreferredSize(new Dimension(60, 40));
        add(this.label);
        text = new JTextPane();
        text.setPreferredSize(new Dimension(width, 20));
        add(text);
    }


    String getText() {
        return text.getText();
    }
}
