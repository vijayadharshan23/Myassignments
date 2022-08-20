package week3.day1;

public class AxisBank extends BankInfo{
	public void deposit() {
		System.out.println("deposit: 500");
	}
	public static void main(String[] args) {
		AxisBank a = new AxisBank();
		BankInfo b = new BankInfo();
		b.deposit();
		a.deposit();
		a.fixed();
		a.saving();
	}
}
