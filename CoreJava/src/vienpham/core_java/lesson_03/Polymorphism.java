package vienpham.core_java.lesson_03;

import java.util.List;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.fish.*;

/*
 * * Polymorphism - changing the behavior of our subclasses. Allows you to treat
 * 		different objects in the same way even if they were created from different
 * 		classes and exhibit different behaviors.
 *
 * We override instance methods to implement polymorphic behavior
 *
 * Rules for overriding a method (from p 108-9)
 *   1. The argument list must be exactly the same as the overridden method
 *   2. The return type must be the same or a subclass of the return type in
 *      the overridden method
 *   3. The access level can't be more restrictive, but can be less restrictive
 *   4. Overridden method must be visible (not private)
 *   5. Overridden method can't be final or static
 *   (more overriding rules regarding exceptions in chapter 5)
 */

public class Polymorphism {

	public Polymorphism() {}
	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
//		studyPolymorphism();
		createYourOwnAnimal();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void studyPolymorphism() {
		List<Animal> zoo = (List<Animal>) new RandomAnimalBuilder().build(10);
		
		for(Animal a : zoo) {
			a.eat(); 
			a.move(); 
			a.sleep();
			if(a instanceof Carnivore) {
				((Carnivore)a).hunt();
			}
			System.out.println();
		}
	}
	

	private void createYourOwnAnimal() {
		Animal genericAnimal = new Animal(3); 
		Whiteshark genericShark = new Whiteshark(); 
		genericShark.setAge(20);
		genericShark.setRandomWeightByAge();
		genericShark.hunt();
		System.out.println();
		
		System.out.println(genericAnimal);
		System.out.println(genericShark);
		
		genericAnimal.eat(); 
		genericShark.eat();
		System.out.println();
		
		genericAnimal.move();
		genericShark.move(); 
		System.out.println();
		
		genericAnimal.sleep();
		genericShark.sleep(); 
		System.out.println();
		
	}
	
	

}
