package week3.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
public static void main(String[] args) {
	String v="PayPal India";
	char[] c=v.toCharArray();
	
	Set<Character>charSet=new HashSet<Character>();
	Set<Character>dupCharSet=new HashSet<Character>();
	for (char a : c) {
		if (!charSet.add(a)) {
			dupCharSet.add(a);
		}
	}
	System.out.println("The Elements in array are: " + Arrays.toString(c));
	System.out.println("The Duplicte elements are: " + dupCharSet);
	System.out.println("The Non-Duplicte elements are: " + charSet);
}
}
