package ui;

import objects.Person;

import javax.swing.*;

public class SinglePersonDisplay extends JTextPane {
    Person person;

    public SinglePersonDisplay(Person p){
        super();
        person = p;

        String s = "";
        for(String key : p.getUsefulData().keySet()) {
            s += key;
            s += ": ";
            s += p.getUsefulData().get(key);
            s += "\n";
        }
        setText(s);
    }
    int getId() {
        return person.getId();
    }
}
