package ui;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickSelector implements MouseListener {

    public ClickSelector() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    // MODIFIES: selectedItem in Main
    // EFFECTS: selects clicked-on item
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source instanceof SinglePersonDisplay) {
            SinglePersonDisplay pressed = (SinglePersonDisplay) source;
            Main.setSelect(pressed.getId());
        }

    }

    public void mouseReleased(MouseEvent e) {


    }

    public void mouseExited(MouseEvent e) {

    }
}
