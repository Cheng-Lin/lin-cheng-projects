package resources;

import java.util.Date;

public class Man extends Person {

	@Override
	public Gender getGender() {
		return Gender.MALE;
	}

	public Man(String firstName, String lastName, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	public Man(String firstName, String lastName, String id, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, id, dateOfBirth, cityOfBirth, countryOfBirth);
	}

}
