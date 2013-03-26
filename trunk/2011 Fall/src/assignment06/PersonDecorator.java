package assignment06;

import java.util.ArrayList;
import java.util.Date;

import resources.Gender;
import resources.Person;


public abstract class PersonDecorator extends Person {
	protected Person next;	

	public PersonDecorator(Person next) {
		super(); // this super() is why the protected
		// null-argument constructor was provided
		this.next = next;
	}

	public int hashCode() {
		return next.hashCode();
	}

	public String getFirstName() {
		return next.getFirstName();
	}

	public void setId(String id) {
		next.setId(id);
	}

	public String getLastName() {
		return next.getLastName();
	}

	public String getId() {
		return next.getId();
	}

	public Gender getGender() {
		return next.getGender();
	}

	public String getName() {
		return next.getName();
	}

	public Date getDateOfBirth() {
		return next.getDateOfBirth();
	}

	public String getCityOfBirth() {
		return next.getCityOfBirth();
	}

	public boolean equals(Object obj) {
		return next.equals(obj);
	}

	public String getCountryOfBirth() {
		return next.getCountryOfBirth();
	}

	public String toString() {
		return next.toString();
	}

	/**
	 * Method to find all the decorator objects of a 
	 * specific type so that, using a cast, a specific 
	 * method can be called
	 * @param className the name of the decorator type
	 * the is needed
	 * @return the list of references to the decorator 
	 * objects that are needed.
	 */
	public ArrayList<PersonDecorator> getDecoratorNamed(String className) {
		ArrayList<PersonDecorator> retVal = new ArrayList<PersonDecorator>();
		if(getClass().getSimpleName().equals(className)) {
			retVal.add(this);
		}
		if (next != null && 
				next instanceof PersonDecorator) {
			retVal.addAll(((PersonDecorator)next).getDecoratorNamed(className));
		}
		return retVal;
	}
}
