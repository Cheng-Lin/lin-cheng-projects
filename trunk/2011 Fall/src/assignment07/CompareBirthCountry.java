package assignment07;

import java.util.Comparator;
import resources.Person;

public class CompareBirthCountry implements Comparator<Person> {

	/**
	 * Compare people's country of origin and ignore the case
	 * @param obj1 Person 1 that's going to get compared with another person
	 * @param obj2 Person 2 the Person 1 going to compare to
	 * @return difference between person 1's home country and person 2's home country
	 */
	@Override
	public int compare(Person obj1, Person obj2) {
		return obj1.getCountryOfBirth().compareToIgnoreCase(obj2.getCountryOfBirth());
	}

}