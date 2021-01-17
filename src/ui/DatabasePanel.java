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
        listPeople.setLayout(new FlowLayout());
        add(scrollPane);
        scrollPane.setViewportView(listPeople);

        List<Person> peopleList = db.getPeopleList();
        peopleList.sort(new PersonComparator("name"));
        loadData(peopleList);

    }

    public void clear() {
        listPeople.removeAll();
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


    public void redraw(List<Person> people) {
        System.out.println("Test");
        clear();
        loadData(people);
    }
}
