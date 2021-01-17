package ui;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonWriter;

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

        JSONObject jsonObj = new JSONObject();

        for (int i = 0; i < db.getPeopleList().size(); i++) {
            JSONObject person = new JSONObject();
            JSONArray tags = new JSONArray();
            String id = String.valueOf(db.getPeopleList().get(i).getId());
            String name = db.getPeopleList().get(i).getName();
            String bday = db.getPeopleList().get(i).getUsefulData().get("bd");

            person.put("Name", name);
            person.put("Birthday", bday);

            // Store all tags for a person
            for (String tag : db.getPeopleList().get(i).getTags()) {
                tags.put(tag);
            }

            person.put("Tags", tags);
            jsonObj.put(id, person);
        }

        //Output JSON data
        System.out.println(jsonObj.toString(2));
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
