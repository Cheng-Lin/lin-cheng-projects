package lab5;

import java.util.ArrayList;

public class Executive extends Manager{
	ArrayList<Manager> mgTeam;

	public Executive(Person self, double salary, Company company,
			String department, ArrayList<Employee> team,
			ArrayList<Manager> mgTeam) {
		super(self, salary, company, department, team);
		this.mgTeam = mgTeam;
	}
	
	public ArrayList<Manager> getMgteam()
	{
		return mgTeam;
	}
}
