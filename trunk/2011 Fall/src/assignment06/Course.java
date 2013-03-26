package assignment06;

public class Course 
{
	String courseNum;
	int numCredits;
	int semesterOffered;
	double gradePoints;
	
	/**
	 * Constructor of Course
	 * 
	 * @param courseNum course number
	 * @param numCredits credit of the course
	 * @param semesterOffered semester offering the course
	 * @param gradePoints grade point
	 */
	public Course(String courseNum, int numCredits, int semesterOffered, double gradePoints)
	{
		this.courseNum = courseNum;
		this.numCredits = numCredits;
		this.semesterOffered = semesterOffered;
		this.gradePoints = gradePoints;
	}
}
