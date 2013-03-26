package lab5;

import java.util.ArrayList;

public class Company {
	private String name;
	ArrayList<Executive> executs = new ArrayList<Executive>();
	
	public Company(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addExecus(Executive executives)
	{
		executs.add(executives);
	}
	
	public double deduceSalaryBill()
	{
		double returnValue = 0.0;
		double totalSalarys = 0.0;
		int count = 0;
		
		if (!executs.isEmpty())
		{
			for (Executive e : executs)
			{
				totalSalarys += e.getSalary();
				count++;
				if(e != null)
				{
					for (Manager m : e.getMgteam())
					{
						totalSalarys += m.getSalary();
						count++;
						if (m != null)
						{
							
						}
					}
				}
			}
		}
		
		return returnValue;
	}
}
