import java.util.ArrayList;
import java.util.Scanner;

public class CreditMain
	{

		public static void main(String[] args)
			{
				long fullNumber = creditCardNumber();
				long[] unchangedNum = loadArray(fullNumber);
				long[] doubledArray = doubledArray(unchangedNum);
				addDigits(doubledArray);

			}

		public static long creditCardNumber()
			{
				Scanner userLongInput = new Scanner(System.in);

				System.out.println("What is your 16 digit credit card number?");
				long num = userLongInput.nextLong();

				return num;
			}

		public static long[] loadArray(long num)
			{
				long[] localArray = new long[16];
				for (int i = 15; i >= 0; i--)
					{
						localArray[i] = num % 10;
						num /= 10;
						// System.out.println(a[i]);
					}
				return localArray;
			}

		public static long[] doubledArray(long[] num)
			{
				for (int i = 0; i < 16; i++)
					{
						num[i] = (num[i] * 2);
					}
				return num;
			}

		public static long[] addDigits(long[] num)
			{
				for (int i = 0; i < 16; i++)
					{
						if (num[i] / 10 > 0)
							{
								int firstDigit = (int) (num[i]%10);
								num[i]/=10;
								num[i]+=firstDigit;
								
							}
					}
				return num;
				//test
			}

	}
