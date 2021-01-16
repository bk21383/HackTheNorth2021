package ui;

import objects.Database;
import objects.Person;
import objects.PersonComparator;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DatabasePanel extends JPanel {

    final int width = 800;
    final int height = 300;
    Map<String, JButton> buttonsMap;
    JPanel buttonsPanel;
    JPanel inputPanel;
    JScrollPane scrollPane;
    JPanel listPeople;

    public DatabasePanel(Database db) {
        super();
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(width, height));

        scrollPane = new JScrollPane();
        listPeople = new JPanel();
        listPeople.setLayout(new BoxLayout(listPeople, BoxLayout.Y_AXIS));
        add(scrollPane);
        scrollPane.setViewportView(listPeople);

        List<Person> peopleList = db.getPeopleList();
        peopleList.sort(new PersonComparator("name"));
        loadData(peopleList);

        /*
        buttonsMap = new HashMap<String, JButton>();
        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(width / 3, height));
        createButtons();
        add(buttonsPanel);

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(2 * width / 3, height));
        createInputs();
        add(inputPanel);
         */

    }

    public void loadData(List <Person> people) {
        for(Person p : people) {
            addPersonData(p);
        }
    }

    public void addPersonData(Person p) {
        SinglePersonDisplay personTextBox = new SinglePersonDisplay(p);
        personTextBox.setVisible(true);
        listPeople.add(personTextBox);
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
