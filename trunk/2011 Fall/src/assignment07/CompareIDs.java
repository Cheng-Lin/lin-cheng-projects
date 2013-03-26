package assignment07;

import java.util.Comparator;
import resources.Person;

public class CompareIDs implements Comparator<Person> {

	/**
	 * Compare people's id and ignore the case
	 * @param obj1 Person 1 that's going to get compared with another person
	 * @param obj2 Person 2 the Person 1 going to compare to
	 * @return difference between person 1's id and person 2's id
	 */
	@Override
	public int compare(Person obj1, Person obj2) {
		return obj1.getId().compareToIgnoreCase(obj2.getId());
	}

}