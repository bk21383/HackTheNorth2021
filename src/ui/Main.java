package ui;
import persistence.JsonWriter;

import objects.*;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    static InterfaceFrame frame;
    static Database db;
    static Database originalDb;

    public static void main(String[] args) {
        generateTestData();
        originalDb = db;
        frame = new InterfaceFrame(db);

        //Send JSON data to JSON file
        optionWrite(1, 2021);
        //Read JSON data and save to db
        try {
            readDatabase(1, 2021);
        } catch (IOException e) {
            System.out.println("I/O errors with json file");
        }
    }

    public static void generateTestData() {
        db = new Database();
        Person p1 = new Person("William Chu");
        Person p2 = new Person("Amy Wang");
        Person p3 = new Person("Jennifer Grinberg");
        Person p4 = new Person("Emily Branch");
        db.addPerson(p1);
        db.addPerson(p2);
        db.addPerson(p3);
        db.addPerson(p4);
        p1.addAssociate(p3);
        p2.addAssociate(p4);
    }

    public static void readDatabase(int monthNum, int yearNum) throws IOException {
        String file = "./json_files/" + Integer.toString(yearNum) + Integer.toString(monthNum) + ".json";
        JsonReader rd = new JsonReader(file);
        db = rd.read();
    }

    public static void optionWrite(int monthNum, int yearNum) {
        String file = "./json_files/" + Integer.toString(yearNum) + Integer.toString(monthNum) + ".json";
        JsonWriter wr = new JsonWriter(file);
        try {
            wr.write(db);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void setSelect(int id) {
        Person selected = db.getPerson(id);
        frame.pp.setSelect(selected);
        return;
    }

    public static void addPerson() {
        String name = frame.cp.newPersonName.getText();
        System.out.println(name);
        db.addPerson(new Person(name));
        redraw();
    }

    public static void addTags() {
        frame.pp.addTags(Database.toList(frame.cp.tagsToAdd.getText()));
        redraw();
    }

    public static void deletePerson() {
        db.removePerson(frame.pp.selected);
        frame.pp.selected = new Person();
        redraw();
    }

    public static void search(boolean inclusive) {
        if(inclusive) {
            db = originalDb.findPeopleWithTagsOr(Database.toList(frame.cp.tagToSearch.getText()));
        }
        else {
            db = originalDb.findPeopleWithTagsAnd(Database.toList(frame.cp.tagToSearch.getText()));
        }
        redraw();
    }

    public static void replaceIfAny() {
        db.reduceTags(Database.toList(frame.cp.tagsToReduce.getText()), frame.cp.replacementTag.getText(), true);
        redraw();
    }

    public static void replaceIfAll() {
        db.reduceTags(Database.toList(frame.cp.tagsToReduce.getText()), frame.cp.replacementTag.getText(), false);
        redraw();
    }

    public static void resetSearch() {
        db = originalDb;
        redraw();
    }

    public static void redraw() {
        frame.refreshDisplay(db);
    }

    public static void addAssociate() {
        frame.pp.selected.addAssociate(db.getPerson(Integer.valueOf(frame.cp.newAssociate.getText())));
        redraw();
    }
}
