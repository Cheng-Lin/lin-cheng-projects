package assignment07;

import java.util.Arrays;

import resources.Man;
import resources.NamesResource;
import resources.Person;
import resources.Woman;

public class TestCompare {
	public static void main(String[] arg)
	{
		Person[] people = new Person[100];
		for(int i = 0; i < people.length; i++) {
			String[] birthPlace = NamesResource.getRandomBirthPlace();
			if(Math.random() > 0.5) {
				people[i] = new Woman(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			} else {
				people[i] = new Man(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			}

		}
		
		for (Person p : people)	{
			System.out.println(p.toString());
		}
		Arrays.sort(people, new CompareLastName());
		System.out.println("---------------------------------------");
		
		for (Person p : people)	{
			System.out.println(p.toString());
		}
		Arrays.sort(people, new CompareIDs());
		System.out.println("---------------------------------------");
		
		for (Person p : people)	{
			System.out.println(p.toString());
		}
		Arrays.sort(people, new CompareBirthDates());
		System.out.println("---------------------------------------");
		
		for (Person p : people)	{
			System.out.println(p.toString());
		}
		Arrays.sort(people, new CompareBirthCountry());
		System.out.println("---------------------------------------");
		
		for (Person p : people)	{
			System.out.println(p.toString());
		}
	}
}
