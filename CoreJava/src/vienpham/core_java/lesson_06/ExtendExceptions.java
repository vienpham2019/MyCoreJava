package vienpham.core_java.lesson_06;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.mammal.*;

public class ExtendExceptions {

	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
		testAgeException();
		
		System.out.println("===================================================================\n\n");
	}

	private void testAgeException() {
		
		try {
			Animal a = new Animal(200, Sex.FEMALE);
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		} 
		
		try {
			Lion leo = new Lion(200 , 300 , Sex.MALE);
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		} 
	
		
		
	}


}
