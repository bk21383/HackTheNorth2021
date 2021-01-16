package ui;

import objects.Database;

import javax.swing.*;
import java.awt.*;

// frame for components
public class InterfaceFrame extends JFrame {
    PersonPanel pp;
    DatabasePanel dp;

    // generates frame, control panel, view panel. makes visible
    public InterfaceFrame(Database db) {
        super("Frame");
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pp = new PersonPanel();
        add(pp);
        dp = new DatabasePanel(db);
        add(dp);

        pack();
        centreOnScreen();
        setVisible(true);
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    // EFFECTS: refreshes vp
    public void refreshDisplay() {
    }
}
