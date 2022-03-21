package week1.day2;

import java.util.Arrays;

public class MissingElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { -5, 1, 2, 3, 4, 6, 0, -2, 7, 8, 13, 14, 16 };
		Arrays.sort(a);

		System.out.println("Array1 values are " + Arrays.toString(a));
		System.out.println("The missing elements in the array are : ");
		for (int i = 0; i < a.length - 1; i++) {
			int increment = 1;
			while (!(a[i + 1] == a[i] + increment)) {
				System.out.println(a[i] + increment);
				increment++;

			}
		}

	}

}
