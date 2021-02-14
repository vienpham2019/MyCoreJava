/*
 * Interfaces are like 100% abstract classes and are a contract:
 * 		A Java Interface can contain only method declarations and public static
 * 		final constants and doesn't contain their implementation. The classes
 * 		which implement the Interface must provide the method definition for all the methods present.
 *
 * 		An interface is also used in situation when a class needs to extend more
 * 		than one class. In java its not possible to have multiple inheritance of
 * 		classes. An interface can be used when it is required to implement more than one interfaces.
 * 
 * Interface Rules
 *		1. Interface methods are implicitly public and abstract (Java 8: unless declared default or static)
 *		2. All variables defined in an interface must be public, static and final (constants)
 *		3. Interface methods cannot be final, strictfp or native
 *		4. An interface can extend one or more other interfaces
 *		5. An interface cannot extend anything but another interface
 *		6. An interface cannot implement anything (interface or class)
 *		7. An interface must be declared with the keyword interface
 *		8. Interface types can be used polymorphically
 *
 */

package vienpham.core_java.lesson_02;

import vienpham.core_java.common.animal.domestic.Cat;
import vienpham.core_java.common.animal.domestic.Dog;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;

public class Interfaces {
	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		testPetInterface();
		testCarnivora(); 
		
//		* Student Exercise: make Fish implement Carnivore and test it in a method in this class 
		
		System.out.println("================================================================================================================\n\n");
	}
	
	private void testCarnivora() {
		System.out.println("2. Test the CarnivorousFish.");
		
		Lion simba = new Lion(); 
		simba.hunt(); 
		
		Dog shotgun = new Dog();
		shotgun.setName("Shotgun");
		shotgun.hunt(); 
		
		Cat lucy = new Cat(); 
		lucy.setName("Lucy");
		lucy.hunt(); 
		
		Swordfish fish= new Swordfish(); 
		fish.hunt();
		
		Tuna tuna= new Tuna(); 
		tuna.hunt();
		
		Whiteshark shark = new Whiteshark(); 
		shark.hunt(); 
	}
	
	private void testPetInterface() {
		System.out.println("1. Test the Pet interface.");
		
		Dog aDog = new Dog();
		aDog.setName("Lassie");
		aDog.setBreed("Collie");
		System.out.println("Name: " + aDog.getName() + ", Breed: " + aDog.getBreed());
		aDog.beFriendly();
		System.out.println();
		
		Cat aCat = new Cat(); 
		aCat.setName("Lassie");
		aCat.setBreed("Collie");
		System.out.println("Name: " + aCat.getName() + ", Breed: " + aCat.getBreed());
		aCat.beFriendly();
		System.out.println();
		
		Horse aHorse = new Horse(); 
		aHorse.setName("Shadowfax");
		aHorse.setBreed("Collie");
		System.out.println("Name: " + aHorse.getName() + ", Breed: " + aHorse.getBreed());
		
	}
	
}
