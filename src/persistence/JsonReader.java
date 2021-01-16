package persistence;

// This is adapted from the demo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import objects.Database;
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
        /*
        int month = jsonObject.getInt("month");
        int year = jsonObject.getInt("year");
        Month m = new Month(month, year);
        JSONObject itemsJson = jsonObject.getJSONObject("monthItems");
        m.setMonthItems(extractLineItems(itemsJson));
        */
        return new Database();
    }

    /*
    // EFFECTS: recursively produces LineItem from jsonObject
    private LineItem extractLineItems(JSONObject jsonObject) {
        LineItem li = new LineItem(jsonObject.getString("name"), jsonObject.getInt("val"));
        JSONArray jsonArray = jsonObject.getJSONArray("subItems");
        for (Object json : jsonArray) {
            JSONObject jsonItem = (JSONObject) json;
            LineItem newItem = extractLineItems(jsonItem);
            li.addItem(newItem);
        }
        return li;
    }
     */
}
