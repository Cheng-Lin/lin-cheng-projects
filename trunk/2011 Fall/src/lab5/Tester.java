package lab5;

import java.util.ArrayList;

public class Tester 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Company company = new Company("Mega-Dynamics");
		
		ArrayList<Employee> emplo1 = new ArrayList<Employee>();
		emplo1.add(new Employee(new Person("Ben Smith"), 10000, company));
		emplo1.add(new Employee(new Person("Alx Smith"), 10000, company));
		
		ArrayList<Employee> emplo2 = new ArrayList<Employee>();
		emplo2.add(new Employee(new Person("Kate Smith"), 10000, company));
		emplo2.add(new Employee(new Person("Marry Smith"), 10000, company));
		
		ArrayList<Manager>  managers = new ArrayList<Manager>();
		managers.add(new Manager(new Person("Jack Smith"), 100000, company, "CS Department", emplo1));
		managers.add(new Manager(new Person("Jacob Smith"), 100000, company, "CoE Department", emplo2));
	
		ArrayList<Employee> team = new ArrayList<Employee>();
		emplo1.add(new Employee(new Person("Andy Smith"), 10000, company));
		emplo1.add(new Employee(new Person("Tim Smith"), 10000, company));
		
		Executive executive = new Executive(new Person("John Smith"), 1000000.00, company,
					"Tech Department", team, managers);
		
		company.addExecus(executive);
	}
}
