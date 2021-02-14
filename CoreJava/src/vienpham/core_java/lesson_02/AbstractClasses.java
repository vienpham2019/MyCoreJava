/*
* Abstract class - a class that must be sub-classed to be used
 * 1. A class may contain one or more abstract methods which have to be implemented by a sub class(es).
 * 2. An abstract class can contain non abstract (concrete) methods. If you want to add a new method that applies to all subclasses, the method can simply be implemented in the abstract class.
 * 3. An abstract class definition begins with the keyword "abstract" keyword followed by Class definition.
 * 4. Abstract classes are useful in a situation when some general methods should be implemented and other specialized behavior should be implemented by subclasses.
 */

package vienpham.core_java.lesson_02;

import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.mammal.*;

public class AbstractClasses {
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		testAbstractMethod(); 
//		testAbstractBird();
		
		testAbstractRaptor(); 
//		testAbstractMammal(); 
		
		System.out.println("================================================================================================================\n\n");
	}
	
	private void testAbstractMethod() {
		System.out.println("1. if a class has abstract methods, the class must be abstract");
		
//		Bird newBird = new Bird(); 
		
	}
	
	private void testAbstractBird() {
		System.out.println("2. Abstract methods must be implemented in the first concrete class");
		
		Bird bird1 = new Emu(); 
		bird1.move();
		
		Bird bird2 = new Duck(); 
		bird2.move();
		
		Bird bird3 = new Hawk(); 
		bird3.move();
	}
	
	private void testAbstractRaptor() {
		System.out.println("3a. Abstract methods MAY be implemented in abstract class");
		
		Raptor raptor1 = new Hawk(); 
		System.out.println("Can swim ? " + raptor1.canSwim());
		
		System.out.println("\n3b. You don't have to implement abstract method in abstract classes");
		System.out.println("Can run ? " + raptor1.canRun());
		raptor1.move();
	}

	private void testAbstractMammal() {
		Lion scar = new Lion(6);
		System.out.println(scar);
		System.out.println(scar.getRunningSpeed());
		scar.setHealth((byte) 0);
		System.out.println(scar.getRunningSpeed());
		scar.setHealth((byte) -5);
		System.out.println(scar.getRunningSpeed());
		
	}
	
	
}
