package resources;
import java.util.Date;
import java.util.Random;


public class RandomPersonGenerator {

	private Random random = new Random( );	
	private String firstName;
	private String lastName;
	private String cityOfBirth;
	private String countryOfBirth;	
	private String id;
	private Date dateOfBirth;
	/** 
	 * Generates random values for all the fields of
	 * the RandomPerson object and constructs a person
	 * with those values
	 */
	public Person personGenerator() {
		int lengthOfName = 8 + random.nextInt(17);
		byte[] bytes = new byte[lengthOfName];
		random.nextBytes(bytes);
		// make lower case letters:
		for (int j = 0; j < bytes.length; j++) {
			bytes[j] = (byte)(Math.abs(bytes[j])%26 + 97);
		}
		int r = lengthOfName/2 - 3 + random.nextInt(6);		
		String s;
		s = new String(bytes);
		firstName = Character.toUpperCase(s.charAt(0)) + 
				s.substring(1,r); 
		lastName = Character.toUpperCase(s.charAt(r)) +
				s.substring(r+1); 
		long L;
		L = Math.abs(random.nextLong())%1000000000;
		if (L < 100000000) {
			id = "0" + L;
		} else {
			id = "" + L;
		}
		long M;
		M = Math.abs(random.nextLong());
		// capital letter for readability
		Date date = new Date();
		long today = date.getTime();
		date.setTime(M % today);
		// at last instantiate the fields 
		dateOfBirth = date; 
		for (int j = 0; j < bytes.length; j++) {
			bytes[j] = (byte)(Math.abs(bytes[j])%26 + 97);
		}
		r = lengthOfName/2 - 3 + random.nextInt(6);		
		s = new String(bytes);
		cityOfBirth = Character.toUpperCase(s.charAt(0)) + 
				s.substring(1,r);
		for (int j = 0; j < bytes.length; j++) {
			bytes[j] = (byte)(Math.abs(bytes[j])%26 + 97);
		}
		r = lengthOfName/2 - 3 + random.nextInt(6);		
		s = new String(bytes);
		countryOfBirth = Character.toUpperCase(s.charAt(0)) + 
				s.substring(1,r);
		Person p;
		if(Math.random() > 0.5){
			p = new Woman(firstName, lastName, id, dateOfBirth,
					cityOfBirth, countryOfBirth);
		} else {
			p = new Man(firstName, lastName, id, dateOfBirth,
					cityOfBirth, countryOfBirth);
		}
		return p;
	}
}