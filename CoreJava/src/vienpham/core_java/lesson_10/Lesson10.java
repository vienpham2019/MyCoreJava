package vienpham.core_java.lesson_10;

import org.junit.Assert;

public class Lesson10 {

	public static void main(String[] args) {

		// Lesson 10 - Functional Programming
//		FunctionalProgramming learnFunctionalProgramming = new FunctionalProgramming();
//		learnFunctionalProgramming.inClassWork();

//		Assert.assertEquals(0, fib(0));
//		Assert.assertEquals(1, fib(1));
//		Assert.assertEquals(1, fib(2));
//		Assert.assertEquals(2, fib(3));
//		Assert.assertEquals(3, fib(4));
//		Assert.assertEquals(5, fib(5));
		
		Student student = new Student(); 
		Teacher teacher = new Teacher(); 
		
		User [] userList = {student, teacher}; 
		for(User u : userList) {
			u.work("this");
		}
		
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}

}
