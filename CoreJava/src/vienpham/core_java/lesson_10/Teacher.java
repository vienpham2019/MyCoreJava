package vienpham.core_java.lesson_10;

public class Teacher implements UserInterface {

	@Override 
	public void work(String s) {
		System.out.println("teacher is teaching " + s);
	}
}
