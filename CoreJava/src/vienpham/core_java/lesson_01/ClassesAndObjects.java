package vienpham.core_java.lesson_01;

import vienpham.core_java.lesson_01.exercises.Cat;
import vienpham.core_java.lesson_01.exercises.Dog;

public class ClassesAndObjects {
	public void inClassWork() {
		Dog d = new Dog("Shotgun" , 8);
		d.bark();
		d.getInfo(); 
		
		d.weight = 17; 
		d.name = "Sprout"; 
		d.bark(); 
		d.getInfo(); 
		
		System.out.println();
		Cat c = new Cat("Machinegun" , 12); 
		c.getInfo(); 
		c.sound(); 
	}
}
