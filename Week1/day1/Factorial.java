package week1.day1;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 1;
		int output = 1;

		if (number == 0) {
			System.out.println("Factorial of " + number + " is : " + 0);
		} else if (number < 0) {
			System.out.println("Factorial of " + number + " is not allowed because it is a negative number");
		} else {
			for (int i = number; i > 0; i--) {
				output = i * output;
			}
			System.out.println("Factorial of " + number + " is : " + output);
		}

	}

}
