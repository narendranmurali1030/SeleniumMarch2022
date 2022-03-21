package week1.day2;

import java.util.Arrays;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 6, 9, 1, 5, 8, 2 };
		int[] b = { 6, 9, 7, 0, 5, 3 };

		System.out.println("Array1 values are " + Arrays.toString(a));
		System.out.println("Array2 values are " + Arrays.toString(b));
		System.out.println("Output for Array1 Intersection Array2 is : ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);
				}

			}

		}
	}
}
