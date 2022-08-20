package week3.day1;

public class Students {
	public void getStudentInfo(int id) {
	System.out.println("ID of the studend:"+id);
}
public void getStudentInfo(int id,String name) {
		System.out.println("ID of the studend:"+id+"name of the studend:"+name);
}
public void getStudentInfo(String email,long number) {
	System.out.println("email of the studend:"+email+"number of the studend:"+number);
}
public static void main(String[] args) {
	Students s = new Students();
	s.getStudentInfo(16107);
	s.getStudentInfo(16107, "Dharshan");
	s.getStudentInfo("16me107@ritrjpm.ac.in", 9876543210L);
}
}
