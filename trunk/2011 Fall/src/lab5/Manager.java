package lab5;

import java.util.ArrayList;

public class Manager extends Employee{
	private String department;
	ArrayList<Employee> team;
	
	public Manager(Person self, double salary, Company company,
			String department, ArrayList<Employee> team) {
		super(self, salary, company);
		this.department = department;
		this.team = team;
	}
	
	public ArrayList<Employee> getTeam()
	{
		return team;
	}
}
