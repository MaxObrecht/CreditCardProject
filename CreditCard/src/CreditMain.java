import java.util.ArrayList;
import java.util.Scanner;

public class CreditMain
	{
		static ArrayList<Long> aList = new ArrayList<Long>();

		public static void main(String[] args)
			{
				int count = 0;
				while (count < 100)
					{
						long fullNumber = randomCreditCardNumber();
						long[] unchangedNum = loadArray(fullNumber);
						long[] doubledArray = doubledArray(unchangedNum);
						long[] addedDigits = addDigits(doubledArray);
						divisibleByTen(addedDigits);
						boolean list = list(addedDigits);

						if (list)
							{
								count++;
							}
					}
				
//				long fullNumber = creditCardNumber();
//				long[] unchangedNum = loadArray(fullNumber);
//				long[] doubledArray = doubledArray(unchangedNum);
//				long[] addedDigits = addDigits(doubledArray);
//				divisibleByTen(addedDigits);

			}

		public static long creditCardNumber()
			{
				Scanner userLongInput = new Scanner(System.in);

				System.out.println("What is your 16 digit credit card number?");
				long num = userLongInput.nextLong();

				return num;
			}

		public static long randomCreditCardNumber()
			{
				long count = 1;
				long num = 0;
				for (int i = 0; i < 16; i++)
					{
						long digit = ((int) (Math.random() * 9) + 1) * count;
						digit--;
						num += digit;
						count *= 10;
					}
				aList.add(num);
				return num;
			}

		public static long[] loadArray(long num)
			{
				long[] localArray = new long[16];
				for (int i = 15; i >= 0; i--)
					{
						localArray[i] = num % 10;
						num /= 10;
						// System.out.println(localArray[i]);
					}
				return localArray;
			}

		public static long[] doubledArray(long[] num)
			{
				for (int i = 0; i < 16; i += 2)
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
								int firstDigit = (int) (num[i] % 10);
								num[i] /= 10;
								num[i] += firstDigit;
								// System.out.println(num[i]);
							}
					}
				return num;
			}

		public static long[] divisibleByTen(long[] num)
			{
				int sum = 0;
				for (int i = 15; i >= 0; i--)
					{
						sum += num[i];
						//System.out.println("sum is " + sum);
					}

				if (sum % 10 == 0)
					{
						System.out.println("works");
						return num;
					}
				else
					{
						System.out.println("not");
						return null;
					}
			}

		public static boolean list(long[] num)
			{
				if (num != null)
					{
						System.out.println(aList.get(aList.size() - 1));
						return true;
					}
				else
					{
						aList.remove(aList.size());
						return false;
					}
			}

	}
