package ui;
import objects.*;

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

    public static void setSelect(int id) {
        return;
    }
}
