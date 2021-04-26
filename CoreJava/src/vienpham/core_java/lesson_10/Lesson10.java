package vienpham.core_java.lesson_10;

import org.junit.Assert;

interface NumericTest{
	public abstract boolean computeTest(int n); 
}

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
		User user = new User(); 
		
		UserInterface [] userList = {student, teacher , user}; 
		for(UserInterface u : userList) {
			if(u instanceof User) u.work("on website project.");
			else if(u instanceof Teacher) u.work("Math");
			else if(u instanceof Student) u.work("English");
			else u.work("this");
		}
		
		NumericTest isEvent = (x) -> x % 2 == 0 ; 
		NumericTest isOdd = (x) -> x % 2 != 0; 
		NumericTest isNegative = (x) -> x < 0; 
		NumericTest isFibNumber = (x) -> x == fib(x); 
		
		System.out.println(isEvent.computeTest(6)); 
		System.out.println(isOdd.computeTest(5));
		System.out.println(isNegative.computeTest(2));
		System.out.println(isFibNumber.computeTest(6));
		
	}  

	public static int fib(int n) {
		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}

}
