package assignment06;

import java.util.EnumMap;
import java.util.Map;

/**
 * Representation of a University with its set
 * of majors
 * @author CS 140
 *
 */
public class University {
	private String name;
	/**
	 * The list of majors offered by this university
	 * with their codes
	 */
	public Map<Majors, Integer> programCode = new EnumMap<Majors, Integer>(Majors.class); 
	
	/**
	 * Constructor for the university
	 * @param name name of the university
	 */
	public University(String name) {
		this.name = name;
	}

	/** 
	 * Adds the major<-->code relation to the programCode map.
	 * @param major a major from the list of majors
	 * @param code the code for that major
	 */
	public void addMajorCode(Majors major, int code) {
		programCode.put(major, code);
	}
}
