/*
 * Reference Variables:
 *		Upcast - Up the inheritance tree to a more general type
 *		Downcast - Down the inheritance tree to a more specific type
 *
 * primitive casting - converts primitives from one type to another
 * 		implicit - conversion happens automatically
 * 		explicit - must write the cast in parenthesis
 * 		widening - going from smaller to larger datatype (can be implicit)
 * 		narrowing - going from larger to smaller datatype (must be explicit)
 */

package vienpham.core_java.lesson_03;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.domestic.Cat;
import vienpham.core_java.common.animal.domestic.Dog;
import vienpham.core_java.common.animal.mammal.*;

public class VariableCasting {

	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		castReferenceVariables();
		castPrimitives(); 
		System.out.println("================================================================================================================");
		
	}
	
	private void castReferenceVariables() {
		System.out.println("1. Casting reference variables");
		
//		Up-casting going up the inheritance tree from a specific type to a more general type: 
		Dog d = new Dog(); 
		Carnivore carn = d; 
		Animal anim = d; 
		Mammal mamm = d; 
		
		Cat c = new Cat(); 
		carn = c; 
		anim = c; 
		mamm = c; 
		
		Horse h = new Horse(); 
//		carn = h; 
		anim = h;
		mamm = h; 
		
//		Down-casting is going from a general type a more specific type 
		anim = new Lion(); 
		carn = (Carnivore)anim; // Down-casing must be explicit
		
//		anim = c; 
		anim = d; 
		
		if(anim instanceof Dog) {
			d = (Dog) anim; 
			d.beFriendly(); // this is the same code as the code below 		
			((Dog)anim).beFriendly();
		}
		
		System.out.println();
		
		animalHospital(new Lion());
		animalHospital(new Cat());
		animalHospital(new Horse());


	}
	
	private void animalHospital(Animal a) {
//		These casts are all down-casts
		if(a instanceof Pet) {
			((Pet)a).beFriendly();
		}
		
		if(a instanceof Carnivore) {
			((Carnivore)a).hunt(); 
		}
		
		if(a instanceof Horse) {
			((Horse)a).eat();
		}
	}
	
	private void castPrimitives () {
		System.out.println("2. Casting primitives");
		byte b = 5; 
		short s = 50; 
		int i = 500; 
		long lng = 5000; 
		float f = 50_000.0f;
		double d = 500_000.0; 
		
		double test; 
		test = s; 
		System.out.println("test = " + test);
		
		long test2; 
		test2 = i;  // up-casting 
		test2 = (long)d; // down-casting MUST be explicit
		System.out.println("test2 = " + test2);
		
		byte testByte = 0; 
		testByte = (byte)i; 
		System.out.println("testByte = " + testByte);
		
	}

}



















