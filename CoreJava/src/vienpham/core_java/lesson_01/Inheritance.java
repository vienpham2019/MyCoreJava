package vienpham.core_java.lesson_01;

import vienpham.core_java.lesson_01.exercises.Animal;
import vienpham.core_java.lesson_01.exercises.Cat;
import vienpham.core_java.lesson_01.exercises.Dog;

public class Inheritance {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClasswork()");
		
		Dog myDog = new Dog("Lucky" , 12); 
		myDog.sleep();
		
		Cat myCat = new Cat("Ketty" , 20); 
		myCat.sleep();
		
		System.out.println(Animal.getCount());
		
		
		System.out.println();
	}
}
