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

    public void addPerson(Person person) {
        lastId += 1;
        person.setId(lastId);
        people.add(person);
    }

    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public Database findPeopleWithTag(String tag) {
        Database peopleWithTag = new Database();
        for(Person person : this) {
            if(person.hasTag(tag)) {
                peopleWithTag.addPerson(person);
            }
        }
        return peopleWithTag;
    }

    public Database findPeopleWIthTags(List<String> tags) {
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

}
