package ui;

import objects.Person;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PersonPanel extends JPanel {
    int width = 800;
    int height = 600;

    Person selected;

    JScrollPane scrollPane;
    JTextArea viewPanel;

    public PersonPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(45, 109, 45));

        selected = new Person();

        scrollPane = new JScrollPane();
        viewPanel = new JTextArea();
        scrollPane.setViewportView(viewPanel);
        add(scrollPane);
    }

    public void setSelect(Person sel) {
        selected = sel;
        displaySelectedPerson();
    }

    public void displaySelectedPerson() {
        String s = "";
        s += "ID: " + selected.getId() + "\n";
        s += "Name: " + selected.getName() + "\n\n";
        s += "Useful data: \n";
        for(String key : selected.getUsefulData().keySet()) {
            s += "\t" + key + ": " + selected.getData(key) + "\n";
        }
        s += "\n";
        s += "Tags: \n";
        for(String tag : selected.getTags()) {
            s += tag + "\n";
        }

        s += "\n";
        s += "Associates: \n";
        for (String associate : selected.getAssociates()) {
            s += associate;
        }

        viewPanel.setText(s);
    }

    public void addTags(List<String> tags) {
        for(String tag : tags) {
            selected.addTag(tag);
        }
    }
}
