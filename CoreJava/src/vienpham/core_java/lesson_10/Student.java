package vienpham.core_java.lesson_10;

public class Student implements UserInterface {

	@Override 
	public void work(String s) {
		System.out.println("Student is study " + s);
	}
}
