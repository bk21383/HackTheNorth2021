package objects;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.*;

public class Database implements Iterable<Person> {
    Map<Integer, Person> people;
    int lastId;

    public Database() {
        people = new HashMap<Integer, Person>();
    }

    // adds a person and assigns them a unique ID
    public void addPerson(Person person) {
        lastId += 1;
        person.setId(lastId);
        people.put(lastId, person);
    }

    // requried for foreach loops
    public Iterator<Person> iterator() {
        return people.values().iterator();
    }

    // produces a database of people with the given tag
    public Database findPeopleWithTag(String tag) {
        Database peopleWithTag = new Database();
        for(Person person : this) {
            if(person.hasTag(tag)) {
                peopleWithTag.addPerson(person);
            }
        }
        return peopleWithTag;
    }

    // produces database of people with the given tags. no person appears twice.
    public Database findPeopleWithTags(List<String> tags) {
        Database peopleWithTag = new Database();
        boolean addedPerson = false;
        for(Person person : this) {
            for(String tag : tags) {
                if(person.hasTag(tag)) {
                    peopleWithTag.addPerson(person);
                    break;
                }
            }
        }
        return peopleWithTag;
    }

    public List <Person> getPeopleList() {
        return new ArrayList<Person>(people.values());
    }

    // Sorts list by given key
    // Afterwards: sorts by name and id
    public List <Person> sortByData(String data) {
        PersonComparator comparator = new PersonComparator(data);
        List <Person> personList = getPeopleList();
        personList.sort(comparator);
        return personList;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        return json;
    }
}
