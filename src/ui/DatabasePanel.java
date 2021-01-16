package ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DatabasePanel extends JPanel {

    final int width = 800;
    final int height = 300;
    Map<String, JButton> buttonsMap;
    JPanel buttonsPanel;
    JPanel inputPanel;

    public DatabasePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));

        buttonsMap = new HashMap<String, JButton>();
        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(width / 3, height));
        createButtons();
        add(buttonsPanel);

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(2 * width / 3, height));
        createInputs();
        add(inputPanel);

    }

    private void createButtons() {
        /*
        buttonsMap.put("Add", new JButton("Add"));
        buttonsMap.put("Remove", new JButton("Remove"));
        buttonsMap.put("Find", new JButton("Find"));
        buttonsMap.put("Write", new JButton("Write"));
        for (JButton b : buttonsMap.values()) {
            buttonsPanel.add(b);
            b.setEnabled(false);
            b.addActionListener(new ButtonListener());
        }
         */
    }

    private void createInputs() {
    }


}
