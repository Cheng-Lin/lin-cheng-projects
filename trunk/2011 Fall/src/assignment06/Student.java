package assignment06;

import java.util.ArrayList;

import resources.Person;

public class Student extends PersonDecorator 
{
	private University school;
	private Majors major;
	private double gpa;
	private ArrayList<Course> coursesTaken = new ArrayList<Course>();
	private String degree;
	private boolean graduated;
	
	/**
	 * Constructor for the Student decorator
	 * @param next the linked decorator or person
	 * @param school the school for this student
	 */
	public Student(Person next, University school) {
		super(next);
		this.school = school;
	}

	public void addCourse(Course course)
	{
		coursesTaken.add(course);
	}
	
	public ArrayList<Course> getCoursesTaken()
	{
		return coursesTaken;
	}
	
	public Majors getMajor() {
		return major;
	}

	public void setMajor(Majors major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public boolean isGraduated() {
		return graduated;
	}

	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	
	// Remember that all the methods of Parent Decorator
	// are inherited
}
