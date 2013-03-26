package lab5;

public class Employee {
	private Person self;
	private double salary;
	private Company company;
	
	public Employee(Person self, double salary, Company company) {
		this.self = self;
		this.salary = salary;
		this.company = company;
	}
	
	public double getSalary()
	{
		return salary;
	}
}
