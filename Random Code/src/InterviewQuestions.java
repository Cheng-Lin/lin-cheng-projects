import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class InterviewQuestions 
{
	public static int findKthMax(int[][] nList, int k) 
	{
		if (nList == null || nList.length == 0) {
			return 0;
		}
		
		PriorityQueue<Entry<Integer, Integer>> listPair 
				= new PriorityQueue<Entry<Integer, Integer>>(nList.length, 
				(Entry<Integer, Integer> i, Entry<Integer, Integer> j) 
				-> j.getKey().compareTo(i.getKey()));
		
		int[] indexList = new int[nList.length];
		for (int i = 0; i < nList.length; i++) 
		{
			if (nList[i] == null || nList[i].length == 0) {
				indexList[i] = -1;
			} else {
				indexList[i] = nList[i].length - 1;
				listPair.add(new SimpleEntry<Integer, Integer>(
						nList[i][indexList[i]], i));
				--indexList[i];
			}
		}
		
		int kthMax = 0;
		for (int i = 0; i < k && listPair.size() > 0; ++i) 
		{
			Entry<Integer, Integer> e = listPair.poll();
			kthMax = e.getKey();
			int listIndex = e.getValue();
			int numIndex = indexList[listIndex];
			
			if (numIndex != -1) {
				listPair.add(new SimpleEntry<Integer, Integer>(
						nList[listIndex][numIndex], listIndex));
				--indexList[listIndex];
			}
		}
		
		return kthMax;
	}
	
	public static void main(String[] args)
	{
		int[][] nList = {{15, 18, 20, 21}, {}, {4, 6, 19}};
		System.out.println(findKthMax(nList, 8));
	}
}
