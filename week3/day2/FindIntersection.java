package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a1 = { 3, 2, 11, 4, 6, 7 };
		int[] b1 = { 1, 2, 8, 4, 9, 7 };
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		for(int a:a1) {
			list.add(a);
		}
		for(int b:b1) {
			list1.add(b);
		}
		System.out.println("The number in list: " +list);
		System.out.println("The number in list1: " +list1);
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list1.size(); j++) {
				if(list.get(i)==list1.get(j)) {
					System.out.println("The intersecting number is: " +list.get(i));
				}
			}
		}
	}

}
