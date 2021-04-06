package vienpham.core_java.lesson_10;

public class Student extends User{

	@Override 
	public void work(String s) {
		System.out.println("Student is study " + s);
	}
}
