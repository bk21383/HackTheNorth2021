package objects;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Database implements Iterable<Person> {
    List<Person> people;
    int lastId;

    public Database() {
        people = new ArrayList<>();
    }

    // adds a person and assigns them a unique ID
    public void addPerson(Person person) {
        lastId += 1;
        person.setId(lastId);
        people.add(person);
    }

    // requried for foreach loops
    public Iterator<Person> iterator() {
        return people.iterator();
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

    // Sorts list by given key
    // Afterwards: sorts by name and id
    public void sortByData(String data) {
        PersonComparator comparator = new PersonComparator(data);
        people.sort(comparator);
    }

}
