package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumber {
public static void main(String[] args) {
	List<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(10);
	list.add(3);
	list.add(9);
	list.add(6);
	list.add(7);
	list.add(7);
	list.add(1);
	list.add(8);
	list.add(5);
	list.add(2);

	System.out.println("list contains:" + list);
	Set<Integer> set = new HashSet<Integer>(list);
	System.out.println("set contains:" + set);
	List<Integer> list1 = new ArrayList<Integer>(set);
	for (int i = 0; i < list1.size(); i++) {
	int n = i + 1;
	if(n!=list1.get(i)) {
				System.out.println("The missing number is :"+n);
				break;
			}
	}
}
}
