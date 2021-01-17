package ui;

import objects.Person;

import javax.swing.*;

public class SinglePersonDisplay extends JTextPane {
    Person person;

    public SinglePersonDisplay(Person p){
        super();
        addMouseListener(new ClickSelector());
        person = p;

        String s = "";
        s += Integer.toString(p.getId()) + ": " + p.getName();
        setText(s);
    }
    int getId() {
        return person.getId();
    }
}
