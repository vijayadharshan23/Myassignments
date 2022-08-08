package week1.day2;

public class Primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 22;

		for (int i = 2; i <= n-1;) {
			if (n % i == 0) {
				System.out.println(n + "is not a prime number");
			} else {
				System.out.println(n + "is a prime number");
			}
			break;
		}
	}

}
