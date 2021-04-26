package vienpham.core_java.lesson_10;

public class User implements UserInterface {
	
	@Override
	public void work(String s) {
		System.out.println("user is working " + s);
	}
}
