package objects;

import java.util.*;

// Person has processed "usefulData" and unprocessed "rawData"

public class Person {
    Map <String, String> usefulData;
    Set <String> rawData;
    Set <String> tags;

    // Constructors: construct maps for data, add initial data (name, birthday)
    public Person() {
        usefulData = new HashMap<>();
        rawData = new HashSet<>();
        tags = new HashSet<>();

        usefulData.put("name", "null");
        usefulData.put("bd", "null");
    }

    public Person(String name) {
        this();
        usefulData.put("name", name);
    }

    public Person(String name, String birthday) {
        this(name);
        usefulData.put("bd", birthday);
    }

    public void addRawData(String data) {
        rawData.add(data);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    // Checks if rawData contains an element of a given list. If so, adds a given tag.
    public void addTagFromRawData(List<String> rawTags, String tag) {
        for(String oldTag : rawTags) {
            if(rawData.contains(oldTag)) {
                tags.add(tag);
            }
        }
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }
}
