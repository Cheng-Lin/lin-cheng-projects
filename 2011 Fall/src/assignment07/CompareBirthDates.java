package assignment07;

import java.util.Comparator;
import resources.Person;

public class CompareBirthDates implements Comparator<Person> {

	/**
	 * Compare people's birthday and ignore the case
	 * @param obj1 Person 1 that's going to get compared with another person
	 * @param obj2 Person 2 the Person 1 going to compare to
	 * @return difference between person 1's birthday and person 2's birthday
	 */
	@Override
	public int compare(Person obj1, Person obj2) {
		return obj1.getDateOfBirth().compareTo(obj2.getDateOfBirth());
	}

}