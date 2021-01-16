package ui;
import objects.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    static InterfaceFrame frame;
    static Database db;

    public static void main(String[] args) {
        generateTestData();
        frame = new InterfaceFrame(db);
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
    }

    public static void readDatabase(int monthNum, int yearNum) throws IOException {
        String file = "./data/" + Integer.toString(yearNum) + Integer.toString(monthNum) + ".json";
        JsonReader rd = new JsonReader(file);
        db = rd.read();
    }

    public static void optionWrite() {
        /*
        String file = "./data/" + Integer.toString(month.getYear())
                + Integer.toString(month.getMonth()) + ".json";
        JsonWriter wr = new JsonWriter(file);
        try {
            wr.write(month);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
         */
    }

    public static void setSelect(int id) {
        return;
    }
}
