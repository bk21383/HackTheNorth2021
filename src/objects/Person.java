package objects;

import java.util.*;

// Person has processed "usefulData" and unprocessed "rawData"

public class Person {
    Map <String, String> usefulData;
    Set <String> rawData;
    Set <String> tags;
    Set <Integer> associates;
    String name;
    int id;

    // Constructors: construct maps for data, add initial data (name, birthday)
    // Id: supposed to be assigned by Database
    public Person() {
        usefulData = new HashMap<>();
        rawData = new HashSet<>();
        tags = new HashSet<>();
        associates = new HashSet<>();

        usefulData.put("bd", "null");
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, String birthday) {
        this(name);
        usefulData.put("bd", birthday);
    }

    public void setId(int newId) {
        id = newId;
    }

    public void addRawData(String data) {
        rawData.add(data);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getData(String key) {
        if(usefulData.containsKey(key)) {
            return usefulData.get(key);
        }
        return "";
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

    public boolean hasData(String data) {
        return usefulData.containsKey(data);
    }

    public int getId() {
        return id;
    }

    public Map<String, String> getUsefulData() {
        return usefulData;
    }

    public String getName() {
        return name;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void removeTag(String tag) {
        if(hasTag(tag)) {
            tags.remove(tag);
        }
    }

    public void addAssociate(Person newAssociate) {
        associates.add(newAssociate.getId());
        newAssociate.getAssociates().add(this.getId());
    }

    public void removeAssociate(int id) {
        associates.remove(id);
    }

    public Set<Integer> getAssociates() {
        return associates;
    }
}
