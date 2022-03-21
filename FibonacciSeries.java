package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inputRange = -1;
		int last = 0;
		int lastBefore = 0;
		int output;

		if (inputRange == 0) {
			System.out.println("Fibonacci Series for the range of " + inputRange + " is 0");
		} else if (inputRange < 0) {
			System.out.println("Fibonacci Series for negative is not applicable");
		} else {
			System.out.println("Fibonacci Series for the range of " + inputRange + " is");
			for (int i = 0; i < inputRange; i++) {
				if (i == 0) {
					output = i;
					last = i;
					lastBefore = i;
				} else if (i == 1) {
					output = i;
					last = i;
				} else {
					output = lastBefore + last;
					lastBefore = last;
					last = output;
				}
				System.out.println(output);

			}
		}

	}

}
