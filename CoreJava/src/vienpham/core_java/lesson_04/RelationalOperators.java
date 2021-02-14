package vienpham.core_java.lesson_04;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.mammal.*;

public class RelationalOperators {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		testRelationalOperators();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void testRelationalOperators() {
		System.out.println("1. Relational operators");
		
		int x = 9; 
		long y = 9; 
		System.out.println("x < y: " + (x < y));
		System.out.println("x <= y: " + (x <= y));
		System.out.println("x > y: " + (x > y));
		System.out.println("x >= y: " + (x >= y));
		
		Animal aRef = new Lion(); 
		if(aRef instanceof Carnivore) {
			((Carnivore) aRef).hunt();
		}else {
			System.out.println("aRef is not an Carnivore.");
		}
	}

}
