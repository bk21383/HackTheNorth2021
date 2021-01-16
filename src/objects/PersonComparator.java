package objects;

import java.util.Comparator;

public class PersonComparator implements Comparator <Person> {
    String comparisonData;

    public PersonComparator(String data) {

    }

    // Sort by comparisonData, then name
    @Override
    public int compare(Person person1, Person person2) {
        int comparison = 0;

        if(person1.hasData(comparisonData) && person2.hasData(comparisonData)) {
            comparison = person1.getData(comparisonData).compareTo(person2.getData(comparisonData));
        }

        if(comparison == 0) {
            if(person1.hasData("name") && person2.hasData("name")) {
                comparison = person1.getData("name").compareTo(person2.getData("name"));
            }
        }

        if(comparison == 0) {
            comparison = Integer.compare(person1.getId(), person2.getId());
        }
        return comparison;
    }
}
