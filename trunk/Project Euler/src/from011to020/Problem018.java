package from011to020;

import java.io.*;
import java.util.*;

public class Problem018 
{
	public static int maxSum(ArrayList<int[]> triangle, int index, int level)
	{
		if (triangle.size() - 2 == level) 
		{
			int left = triangle.get(level + 1)[index];
			int right = triangle.get(level + 1)[index + 1];
			return triangle.get(level)[index] + ((left > right) ? left : right);
		} else {
			int leftResult = triangle.get(level)[index] + maxSum(triangle, index, level + 1);
			int rightResult = triangle.get(level)[index] + maxSum(triangle, index + 1, level + 1);
			return (leftResult > rightResult) ? leftResult : rightResult;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<int[]> triangle = new ArrayList<int[]>();
		File file = new File("problem\\from011to020\\Problem018.txt");

		try {
			Scanner fin = new Scanner(file);
			
			int count = 1;
			while (fin.hasNextLine())
			{
				triangle.add(new int[count]);
				
				for (int i = 0; i < count; i++) {
					triangle.get(count - 1)[i] = fin.nextInt();
				}
				
				count++;
			}
			
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(maxSum(triangle, 0, 0));
	}
}
