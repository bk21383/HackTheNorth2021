package ui;

import javax.swing.*;
import java.awt.*;

public class PersonPanel extends JPanel {
    int width = 800;
    int height = 600;

    public PersonPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(45, 109, 45));
    }

}
