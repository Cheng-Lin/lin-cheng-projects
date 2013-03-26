package from011to020;

public class Problem017 
{
	public static void main(String[] args) 
	{
		int target = 1000;
		int[] oneToNineteen = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
		int result = 0;

		if (target > 19)
		{
			int onethSum = 0;
			for (int i = 0; i < 9; i++)	{
				onethSum += oneToNineteen[i];
			}

			result = onethSum;
			for (int i = 9; i < oneToNineteen.length; i++) {
				result += oneToNineteen[i];
			}

			int[] tenth = {6, 6, 5, 5, 5, 7, 6, 6};
			if (target > 99)
			{
				int and = 3;
				int hundred = 7;
				int[] beyond = {8, 7, 7, 8, 11, 11, 10};

				for (int i = 0; i < tenth.length; i++) {
					result += tenth[i] * 10 + onethSum;
				}
				int tenthSum = result;

				int temp = target / 100;
				int hundredLimit = temp % 10;
				for (int i = 0; i < hundredLimit - 1; i++) {
					result += (oneToNineteen[i] + hundred + and) * 100 - 3 + tenthSum;
				}
				int underHundred = target % 100;
				if (hundredLimit > 0) {
					result += (oneToNineteen[hundredLimit - 1] * underHundred);
				}

				temp = target / 1000;
				if (temp > 0)
				{
					int hundredthSum = tenthSum;
					for (int i = 0; i < 9; i++)	{
						hundredthSum += (oneToNineteen[i] + hundred + and) * 100 - 3 + tenthSum; 
					}
					result = hundredthSum + 3 + 8;
					int thousandLimit = temp % 1000;
					for (int i = 0; i < thousandLimit - 1; i++)
					{

					}
				}
			}

			int temp = target % 100;
			int tenthLimit = temp / 10;
			for (int i = 0; i < tenthLimit - 2; i++) {
				result += tenth[i] * 10 + onethSum;
			}

			if (tenthLimit > 0) 
			{
				int onethLimit = temp % 10;
				result += tenth[tenthLimit - 2] * (onethLimit + 1);
				for (int i = 0; i < onethLimit; i++) {
					result += oneToNineteen[i];
				}
			}
		}
		else
		{
			for (int i = 0; i < target; i++) {
				result += oneToNineteen[i];
			}
		}

		System.out.println(result);
	}
}
