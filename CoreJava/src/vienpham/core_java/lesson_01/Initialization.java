
/*
 * Local variables declared in a method are NOT automatically initialized 
 * 
 * Instance variables declared at the class level without the static keyword
 * Class variables declared at the class level with the static keyword
 */


package vienpham.core_java.lesson_01;

import vienpham.core_java.lesson_01.exercises.Dog;

public class Initialization {
	Dog topDog; 
	int instantInt; 
	double instantDouble; 
	boolean instantBoolean; 
	char instantChar; 
	
	
	public void inClassWork() {
		System.out.println();
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		Local variables are  not initialized 
		int x; 
//		SYstem.out.println(x) 
//		int z = x + 5
		
		Dog aDog; 
//		System.out.println(aDog);
		
//		Reference variables that are at the class level are automatically initialized to default value 
		System.out.println(topDog);  // print out null
		System.out.println(instantInt); // print out 0
		System.out.println(instantDouble); // print out 0.0
		System.out.println(instantBoolean); // print out false 
		System.out.println(instantChar); // print out empty space 
		
//		Arrays, even local arrays are initialized using default values
		int[] nums = new int[4] ; 
		
		for(int i = 0 ; i < nums.length ; i ++) {
			System.out.println("index " + i + " = " + nums[i]);
		}
		
		Dog[] pets = new Dog[4]; 
		for(int i = 0 ; i < pets.length ; i ++) {
			System.out.println(pets[i]);
		}
		
		
	}
}
