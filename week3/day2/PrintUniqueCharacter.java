package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String v = "vijayadharshan";
		char[] a = v.toCharArray();

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			
		}
		System.out.println(set);
	}
}
