import java.util.Scanner;

public class FraudPrevention 
{
	private static final int DEAL_ID = 0;
	private static final int EMAIL = 1;
	private static final int STREET = 2;
	private static final int ZIP = 3;
	private static final int CREDIT_NUM = 4;
	private static final int ORIGINAL = 5;

	public static void main(String[] args) 
	{
		try {
			Scanner input = new Scanner(System.in);
			String[][] list = new String[input.nextInt()][6];
			boolean[] result = new boolean[list.length];

			input.nextLine();
			list[0][ORIGINAL] = input.nextLine();
			int index1 = list[0][ORIGINAL].indexOf(',');
			int index2 = list[0][ORIGINAL].indexOf(',', index1 + 1);
			list[0][DEAL_ID] = list[0][ORIGINAL].substring(index1 + 1, index2);

			for (int i = 1; i < list.length; i++)
			{
				list[i][ORIGINAL] = input.nextLine();
				index1 = list[i][ORIGINAL].indexOf(',');
				index2 = list[i][ORIGINAL].indexOf(',', index1 + 1);
				list[i][DEAL_ID] = list[i][ORIGINAL].substring(index1 + 1, index2);

				for (int j = i - 1; j >= 0; j--)
				{
					if (list[i][DEAL_ID].length() == list[j][DEAL_ID].length() && list[j][DEAL_ID].equals(list[i][DEAL_ID]))
					{
						if (list[i][CREDIT_NUM] == null)
						{
							index1 = list[i][ORIGINAL].lastIndexOf(',');
							list[i][CREDIT_NUM] = list[i][ORIGINAL].substring(index1 + 1);
						}
						if (list[j][CREDIT_NUM] == null)
						{
							index1 = list[j][ORIGINAL].lastIndexOf(',');
							list[j][CREDIT_NUM] = list[j][ORIGINAL].substring(index1 + 1);
						}

						if (!list[i][CREDIT_NUM].equals(list[j][CREDIT_NUM]))
						{	
							if (list[i][EMAIL] == null)
							{
								index1 = list[i][ORIGINAL].indexOf(',', index2 + 1);
								list[i][EMAIL] = list[i][ORIGINAL].substring(index2 + 1, index1);
								list[i][EMAIL] = eMailReformat(list[i][EMAIL]);
							}
							if (list[j][EMAIL] == null)
							{
								index2 = list[j][ORIGINAL].indexOf(',');
								index1 = list[j][ORIGINAL].indexOf(',', index2 + 1);
								index2 = list[j][ORIGINAL].indexOf(',', index1 + 1);
								list[j][EMAIL] = list[j][ORIGINAL].substring(index1 + 1, index2);
								list[j][EMAIL] = eMailReformat(list[j][EMAIL]);
							}

							if (list[i][EMAIL].length() == list[j][EMAIL].length() && list[i][EMAIL].equals(list[j][EMAIL])) {
								result[i] = result[j] = true;
							} else {
								if (list[i][ZIP] == null)
								{
									index1 = list[i][ORIGINAL].lastIndexOf(',');
									index2 = list[i][ORIGINAL].lastIndexOf(',', index1 - 1);
									list[i][ZIP] = list[i][ORIGINAL].substring(index2 + 1, index1);
								}
								if (list[j][ZIP] == null)
								{
									index1 = list[j][ORIGINAL].lastIndexOf(',');
									index2 = list[j][ORIGINAL].lastIndexOf(',', index1 - 1);
									list[j][ZIP] = list[j][ORIGINAL].substring(index2 + 1, index1);
								}

								if (list[i][ZIP].equals(list[j][ZIP]))
								{
									if (list[i][STREET] == null)
									{
										index1 = list[i][ORIGINAL].indexOf(',');
										index2 = list[i][ORIGINAL].indexOf(',', index1 + 1);
										index1 = list[i][ORIGINAL].indexOf(',', index2 + 1);
										index2 = list[i][ORIGINAL].indexOf(',', index1 + 1);
										list[i][STREET] = list[i][ORIGINAL].substring(index1 + 1, index2);
										list[i][STREET] = streetReformat(list[i][STREET]);
									}
									if (list[j][STREET] == null)
									{
										index1 = list[j][ORIGINAL].indexOf(',');
										index2 = list[j][ORIGINAL].indexOf(',', index1 + 1);
										index1 = list[j][ORIGINAL].indexOf(',', index2 + 1);
										index2 = list[j][ORIGINAL].indexOf(',', index1 + 1);
										list[j][STREET] = list[j][ORIGINAL].substring(index1 + 1, index2);
										list[j][STREET] = streetReformat(list[j][STREET]);
									}

									if (list[i][STREET].length() == list[j][STREET].length() && list[i][STREET].equals(list[j][STREET]))
										result[i] = result[j] = true;
								}
							}
						}
					}
				}

			}

			boolean first = true;
			for (int i = 0; i < result.length; i++)
			{
				if (result[i])
				{
					if (!first) {
						System.out.print("," + (i + 1));
					} else {
						System.out.print((i + 1));
						first = false;
					}
				}
			}

			input.close();
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	private static String eMailReformat(String email)
	{
		int index3 = email.indexOf('+');
		int index4 = email.indexOf('@');
		if (index3 != -1) {
			//list[i][EMIAL] = list[i][EMAIL].replaceFirst(list[i][EMAIL].substring(index3, index4), "");
			email = email.substring(0, index3) + email.substring(index4);
		}

		index3 = email.indexOf('.');
		while (index3 < index4)
		{
			//list[i][EMAIL] = list[i][EMAIL].replaceFirst(list[i][EMAIL].substring(index3, index3 + 1), "");
			email = email.substring(0, index3) + email.substring(index3 + 1);
			index3 = email.indexOf('.');
		}

		return email;
	}

	private static String streetReformat(String street)
	{
		if (street.charAt(street.length() - 1) == '.')
		{
			int index = street.length() - 3;
			String str = street.substring(index);
			if (str.equals("St.")) {
				street = street.substring(0, index) + "Street";
			} else {
				//else if (str.equals("Rd."))
				street = street.substring(0, index) + "Road";
			}
		}

		return street;
	}
}
