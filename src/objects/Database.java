package objects;

import org.json.JSONObject;
import org.json.JSONArray;

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
        if(person.getId() == 0) {
            lastId += 1;
            person.setId(lastId);
            people.put(lastId, person);
        }
        else {
            people.put(person.getId(), person);
        }
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
    public Database findPeopleWithTagsOr(List<String> tags) {
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

    public Database findPeopleWithTagsAnd(List<String> tags) {
        Database peopleWithTag = new Database();
        boolean missingTag = false;
        for(Person person : this) {
            missingTag = false;
            for(String tag : tags) {
                if(!person.hasTag(tag)) {
                    missingTag = true;
                    break;
                }
            }
            if(!missingTag) {
                peopleWithTag.addPerson(person);
            }
        }
        return peopleWithTag;
    }

    public ArrayList <Person> getPeopleList() {
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
        JSONObject jsonObj = new JSONObject();

        for (int i = 0; i < this.getPeopleList().size(); i++) {
            JSONObject person = new JSONObject();
            JSONArray tags = new JSONArray();
            String id = String.valueOf(this.getPeopleList().get(i).getId());
            String name = this.getPeopleList().get(i).getName();
            String bday = this.getPeopleList().get(i).getUsefulData().get("bd");

            person.put("Name", name);
            person.put("Birthday", bday);

            // Store all tags for a person
            for (String tag : this.getPeopleList().get(i).getTags()) {
                tags.put(tag);
            }

            person.put("Tags", tags);
            jsonObj.put(id, person);
        }

        //Output JSON data
        System.out.println(jsonObj.toString(2));

        return jsonObj;
    }

    public Person getPerson(int id) {
        return people.get(id);
    }

    public void reduceTags(List <String> tags, String newTag, boolean inclusive) {
        Database people;
        if(inclusive) {
            people = findPeopleWithTagsOr(tags);
        }
        else {
            people = findPeopleWithTagsAnd(tags);
        }
        for(Person p : people) {
            for(String tag : tags) {
                p.removeTag(tag);
            }
            p.addTag(newTag);
        }
    }

    public static List<String> toList(String list) {
        List <String> realList;
        realList = Arrays.asList(list.split(",| "));
        return realList;
    }


    public void removePerson(Person p) {
        // Remove person from all associate lists
        for(int id : p.getAssociates()) {
            people.get(id).removeAssociate(p.getId());
        }

        // Remove person from db
        people.remove(p.id, p);
    }
}
