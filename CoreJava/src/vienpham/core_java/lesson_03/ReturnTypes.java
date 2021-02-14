package vienpham.core_java.lesson_03;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.domestic.Dog;
import vienpham.core_java.common.animal.mammal.*;

public class ReturnTypes {
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		testEnumSex(); 
		nullReturnAreOk(); 
		covariantReturns();
		returningArrays();  
		System.out.println("================================================================================================================");
		
	}

	private void testEnumSex() {
		System.out.println("1. Test the Sex enum");

		Animal animal = new Animal();
		System.out.println(animal);
		animal.setSex(Sex.MALE);
		animal.grow(); 
		System.out.println(animal);
		System.out.println();
		
		Elephant elephant = new Elephant(); 
		elephant.setSex(Sex.MALE);
		elephant.setAge(15); 
		elephant.setWeight(1300); 
		System.out.println(elephant);
		
		System.out.println();

	}

	private void nullReturnAreOk() {
		System.out.println("2. null is valid return value");
		
		Animal baby; 
		Lion leo = new Lion(6, 700 , Sex.MALE);
		leo.reproduce(); 
		baby = ((Lion)leo).reproduce();
		System.out.println(baby);
		
		Lion elsa = new Lion(5 , 600 , Sex.FEMALE); 
		elsa.grow();
		elsa.reproduce(); 
		baby = ((Lion)elsa).reproduce(); 
		System.out.println(baby);
		
		System.out.println();
	}

	private void covariantReturns() {
		System.out.println("3. Covariant returns are allowed in overring methods");
		
		Elephant baby; 
		Elephant elmore = new Elephant(17);
		elmore.setSex(Sex.MALE); 
		baby = elmore.reproduce(); 
		System.out.println(baby);
		
		Elephant ellie = new Elephant(15); 
		baby = ellie.reproduce(); 
		System.out.println("baby = " + baby);
		
		ellie.grow();
		baby = ellie.reproduce(); 
		System.out.println("baby = " + baby);
		
		System.out.println();	
		
	}
	
	private void returningArrays() {
		System.out.println("4. Arrays are valid return types");
		
		Dog[] newLitter; 
		Dog mother = new Dog(); 
		mother.setAge(4);
		newLitter = mother.reproduce(6);
		
		for(Dog d : newLitter) {
			System.out.println(d);
		}
		
		System.out.println();

	}
	
	
}
