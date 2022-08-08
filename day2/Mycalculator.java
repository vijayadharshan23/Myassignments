package week1.day2;

public class Mycalculator {
public static void main(String[] args) {
	Calculator c = new Calculator();
	System.out.println("addition:"+c.sum(1, 2, 3));
	System.out.println("subract:"+c.sub(5, 4));
	System.out.println("multiply:"+c.mul(1.53333333, 2.5555555));
	System.out.println("divide:"+c.div(10000.111111f, 50.2222f));
}
}
