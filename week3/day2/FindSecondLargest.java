package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };

		Set<Integer> set = new TreeSet<Integer>();

		for (int v : data) {
			set.add(v);
		}

		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println("The List contains:" + list);

		int a = (list.size() - 2);
		list.get(a);
		System.out.println("Second largest number is:" + list.get(a));

	}
}
