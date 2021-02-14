/*
 * Top level classes can only have public or default of access 
 * 
 * The only non-access modifiers you can use on top level classes are: 
 * 	final = class can't extended ( like String ) 
 * 	abstract - class MUST be extended in order to be used 
 * 	strictfp - follows IEEE 745 for floating point  
 */

package vienpham.core_java.lesson_02;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;

public class Classes {
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		allClassesExtendObject(); 
		creatingAnimals(); 
		
		System.out.println();
	}
	
	private void allClassesExtendObject() {
		System.out.println("1. All classes extend Object and inherit Object methods.");
		Object obj = new Animal(); 
		Object obj2 = obj; 
		Object obj3 = new Animal(); 
		
		Animal animal = new Animal(); 
		animal.setAge(12); 
		animal.setWeight(50);
		obj2 = animal;
		
//		Object methods: 
		System.out.println("obj.toString(): " + obj.toString());
		System.out.println("obj.getClass(): " + obj.getClass());
		System.out.println("obj.hashCode(): " + obj.hashCode());
		
		System.out.println("obj2.toString(): " + obj2.toString());
		System.out.println("obj3.toString(): " + obj3.toString());
		
		System.out.println("obj.equals(obj2): " + obj.equals(obj2));
		System.out.println("obj.equals(obj3): " + obj.equals(obj3));
	}
	
	private void creatingAnimals() {
		System.out.println("2. Creating more Animal classes.");
		System.out.println("Animal count = " + Animal.getCount());
		
		Animal unknowAnimal = new Animal(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		Elephant dumbo = new Elephant();
		System.out.println("Animal count = " + Animal.getCount());
		
		Monkey george = new Monkey(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		Bear teddy = new Bear(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		Tuna cleo = new Tuna(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		Lion nala = new Lion(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		Horse nio = new Horse(); 
		System.out.println("Animal count = " + Animal.getCount());
		
		
		Animal[] zoo = {dumbo , george , teddy , cleo , nala , nio}; 
		
		for(int i = 0 ; i < zoo.length ; i ++) {
//			System.out.println uses the 'toString' method for objects
			System.out.println(zoo[i]);
			zoo[i].eat(); 
			zoo[i].move();
			zoo[i].sleep();
			System.out.println();
		}
		
	}
}
