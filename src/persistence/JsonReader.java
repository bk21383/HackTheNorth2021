package persistence;

// This is adapted from the demo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import objects.Database;
import objects.Person;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: returns month from this's file. Throws IOException if file not found.
    public Database read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDatabase(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // returns Month from jsonObject
    private Database parseDatabase(JSONObject jsonObject) {
        Database newDB = new Database();
        for (int i = 1; i <= jsonObject.length(); i++) {
            JSONObject personJSON = jsonObject.getJSONObject(Integer.toString(i));
            JSONArray tags = personJSON.getJSONArray("Tags");
            JSONArray associates = personJSON.getJSONArray("Associates");
            Person person = new Person(personJSON.getString("Name"));
            newDB.addPerson(person);

            for (int j = 0; j < tags.length(); j++) {
                person.addTag(tags.getString(j));
            }

            for (int j = 0; j < associates.length(); j++) {
                if(newDB.getPeople().containsKey(associates.getInt(j))) {
                    person.addAssociate(newDB.getPerson(associates.getInt(j)));
                }
            }
        }

        return newDB;
    }

}
