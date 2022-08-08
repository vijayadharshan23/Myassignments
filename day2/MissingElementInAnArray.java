package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {
	public static void main(String[] args) {

		int[] arr = { 0,1, 2, 3, 4, 7, 6, 8 };
		Arrays.sort(arr);
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] != i) {
				System.out.println("The missing number is:" + i);
				break;
			}

		}

	}

}
