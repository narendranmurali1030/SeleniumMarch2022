package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 2;
		boolean flag = true;

		if (number <= 1) {
			System.out.println("Given number is either 1 or less than 1. Hence it is not a prime number");
		} else {
			for (int i = 2; i < number; i++) {
				if ((number % i) == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(number + " is a Prime Number");
			} else {
				System.out.println(number + " is not a Prime Number");
			}
		}

	}

}
