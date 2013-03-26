package assignment06;

import java.util.Date;
import resources.*;

public class Tester {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Person testPerson = new Man("James", "Soul", "123456", new Date(1993, 3, 30),
				"Chicago", "USA");

		University bcc = new University("BCC");
		testPerson = new Student(testPerson, bcc);
		((Student)testPerson).setDegree("AS");
		((Student)testPerson).setGraduated(true);
		
		University bu = new University("Binghamton University");
		testPerson = new Student(testPerson, bu);
		((Student)testPerson).setMajor(Majors.COMPUTER_SCIENCE);
		((Student)testPerson).setDegree("BS");
		((Student)testPerson).setGraduated(true);
		
		University sunysb = new University("Stony Brook");
		testPerson = new Student(testPerson, sunysb);
		((Student)testPerson).setDegree("PhD");
		((Student)testPerson).setGraduated(false);
	}
}
