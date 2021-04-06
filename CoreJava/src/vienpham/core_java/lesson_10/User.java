package vienpham.core_java.lesson_10;

public class User extends People {
	
	@Override
	public void work(String s) {
		System.out.println("user is working " + s);
	}
}
