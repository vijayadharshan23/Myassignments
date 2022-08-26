package week3.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		
		int[] data = { 4, 3, 6, 8, 29, 1, 2, 4, 7, 8 };

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();

		for (int a : data) {
			if (!set.add(a)) {
				set2.add(a);
			}
		}
		System.out.println("The  numbers are: " + Arrays.toString(data));
		System.out.println("The Duplicate numbers are: " + set2);

	}

}
