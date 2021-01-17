package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ControlPanel extends JPanel {

    final int width = 800;
    final int height = 300;
    Map<String, JButton> buttonsMap;

    JPanel newPersonControlPanel;
    JPanel searchPanel;
    JPanel personControlPanel;
    JPanel reducePanel;
    JPanel filePanel;

    InputTextBox newAssociate;
    InputTextBox newPersonName;
    InputTextBox tagsToAdd;
    InputTextBox tagToSearch;

    InputTextBox tagsToReduce;
    InputTextBox replacementTag;


    public ControlPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));

        newPersonControlPanel = generatePanel();
        searchPanel = generatePanel();
        personControlPanel = generatePanel();
        reducePanel = generatePanel();
        filePanel = generatePanel();

        add(newPersonControlPanel);
        add(generatePanel());
        add(personControlPanel);
        add(generatePanel());
        add(searchPanel);
        add(generatePanel());
        add(reducePanel);
        add(generatePanel());
        add(filePanel);

        newPersonName = new InputTextBox("New person's name: ", 20);
        newPersonControlPanel.add(newPersonName);
        newPersonControlPanel.setLayout(new GridLayout(2, 1));
        newPersonControlPanel.add(generateButton("Add Person"));

        tagsToAdd = new InputTextBox("Tag(s) to add to current person: ", 30);
        personControlPanel.setLayout(new GridLayout(6, 1));
        personControlPanel.add(tagsToAdd);
        personControlPanel.add(generateButton("Add tag(s)"));
        personControlPanel.add(generateButton("Delete person"));

        newAssociate = new InputTextBox("New Associate's ID: ", 30);
        personControlPanel.add(newAssociate);
        personControlPanel.add(generateButton("Add Associate"));



        tagToSearch = new InputTextBox("Search tag(s): ", 30);
        searchPanel.add(tagToSearch);
        searchPanel.add(generateButton("Inclusive Search"));
        searchPanel.add(generateButton("Exclusive Search"));
        searchPanel.add(generateButton("Reset Search"));
        searchPanel.setLayout(new GridLayout(4, 1));

        tagsToReduce = new InputTextBox("Tags to reduce: ", 30);
        reducePanel.add(tagsToReduce);
        replacementTag = new InputTextBox("Replacement: ", 30);
        reducePanel.add(replacementTag);
        reducePanel.add(generateButton("Replace if any"));
        reducePanel.add(generateButton("Replace if all"));
        reducePanel.setLayout(new GridLayout(3, 1));

        filePanel.add(generateButton("Read"));
        filePanel.add(generateButton("Write"));
    }

    JPanel generatePanel() {
        JPanel pan = new JPanel();
        return pan;
    }

    JButton generateButton(String name) {
        JButton but = new JButton(name);
        but.addActionListener(new ButtonListener());
        return but;
    }




}
