package assignment02;

public class QuestionAssig2bTester 
{
	public static void main(String[] args) 
	{
		QuestionAssig2b dataTester = new QuestionAssig2b();
		
		dataTester.readFloatArray();
		dataTester.analyzeArray();
		
		System.out.println("The maximum is: " + dataTester.getMax());
		System.out.println("The minimum is: " + dataTester.getMin());
		System.out.println("The average is: " + dataTester.getAverage());
	}
}
