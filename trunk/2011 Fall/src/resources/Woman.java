package resources;

import java.util.Date;

public class Woman extends Person {

	public Woman(String firstName, String lastName, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	public Woman(String firstName, String lastName, String id,
			Date dateOfBirth, String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, id, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	@Override
	public Gender getGender() {
		return Gender.FEMALE;
	}

}
