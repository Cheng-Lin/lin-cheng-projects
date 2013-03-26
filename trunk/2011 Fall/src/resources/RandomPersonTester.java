package resources;

import javax.swing.JOptionPane;

public class RandomPersonTester {

	public void tester1(Person[] people) {
		//year, (month-1), day, hour, minute, second
		RandomPersonGenerator rpg = new RandomPersonGenerator();  
		StringBuilder bldr = new StringBuilder();
		for(int i = 0; i < people.length; i++) {
			people[i] = rpg.personGenerator();
			bldr.append(people[i]);
			bldr.append('\n');
		}
		JOptionPane.showMessageDialog(null,bldr);		
	}

	public void tester2(Person[] people) {
		StringBuilder bldr = new StringBuilder();
		for(int i = 0; i < people.length; i++) {
			/*
			 * @param firstName the first name of the person
			 * @param lastName the last name of the person
			 * @param dateOfBirth the date of birth of the person
			 * @param cityOfBirth the city where the person was born
			 * @param countryOfBirth the country where the person was born
			 */
			String[] birthPlace = NamesResource.getRandomBirthPlace();
			if(Math.random() > 0.5) {
				people[i] = new Woman(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			} else {
				people[i] = new Man(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			}
			bldr.append(people[i]);
			bldr.append('\n');
		}
		JOptionPane.showMessageDialog(null,bldr);		
	}
	public static void main(String[] args) {
		RandomPersonTester test = new RandomPersonTester();
		test.tester1(new Person[10]);
		test.tester2(new Person[20]);
	}
}
