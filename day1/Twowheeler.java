package week1.day1;

public class Twowheeler {
	
	int noOfWheels = 4;
	short noOfMirros = 2;
	long chassisNumber = 45000000000l;
	boolean isPunctured = false;
	String bikeName = "RX100";
	double runningKM = 23.33;
	public static void main(String[] args) {
		Twowheeler t = new Twowheeler();
		System.out.println(t.noOfWheels);
		System.out.println(t.noOfMirros);
		System.out.println(t.chassisNumber);
		System.out.println(t.isPunctured);
		System.out.println(t.bikeName);
		System.out.println(t.runningKM);
	}
}
  