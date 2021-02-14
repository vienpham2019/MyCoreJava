package vienpham.core_java.lesson_03;

import java.util.List;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.mammal.*;

public class Overloading {
	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		simpleOverloading(); 
//		testElephantWeight(); 
		testRandomAnimal();		
		System.out.println("================================================================================================================\n\n");
	}
	
	private void simpleOverloading () {
		System.out.println("1. Overloading in the same class.");
		
		Animal a1 = new Animal(); 
		a1.setAge(1);
		a1.setRandomWeightByAge();
		System.out.println(a1);
		
		Animal a2 = new Animal(); 
		a2.setAge(1); 
//		a2.setRandomWeightByAge(100 , 150 , 125 , 200 , 10);
//		System.out.println(a2);
//		a2.setSex(Sex.MALE); 
//		a2.setRandomWeightByAge(100 , 150 , 125 , 200 , 10);
//		System.out.println(a2);
//		System.out.println();
		
		a1.setAge(20);
		a1.setRandomWeightByAge();
		System.out.println(a1);
		
//		a2.setAge(20); 
//		a2.setRandomWeightByAge(100 , 150 , 125 , 200 , 10);
//		System.out.println(a2);
//		a2.setSex(Sex.MALE); 
//		a2.setRandomWeightByAge(100 , 150 , 125 , 200 , 10);
//		System.out.println(a2);
		System.out.println();
	}
	
	private void testElephantWeight() {
		System.out.println("2. Test elephant weight.\n\n");
		
//		Test the birth weight
		Elephant el = new Elephant(); 
		el.setRandomWeightByAge();
		System.out.println(el);
		
//		Test the boundary 
		el.grow(); 
		System.out.println(el);
		
//		Test the weight at MATURITY 
		el.setAge(14);
		el.setRandomWeightByAge();
		System.out.println(el);
		
		el.grow(); 
		System.out.println(el);
		
		el.grow(); 
		System.out.println(el);
		
		System.out.println();
		
		Elephant el2 = new Elephant(); 
		el2.setSex(Sex.MALE);
		
//		Test the boundary 
		el2.grow(); 
		System.out.println(el2);
		
//		Test the weight at MATURITY 
		el2.setAge(14);
		el2.setRandomWeightByAge();
		System.out.println(el2);
		
		el2.grow(); 
		System.out.println(el2);
		
		el2.grow(); 
		System.out.println(el2);
		
		
//		Lion
		System.out.println();
		
		Lion lion = new Lion(); 
		lion.setSex(Sex.MALE);
		
//		Test the boundary 
		lion.grow(); 
		System.out.println(lion);
		
//		Test the weight at MATURITY 
		lion.setAge(14);
		lion.setRandomWeightByAge();
		System.out.println(lion);
		
		lion.grow(); 
		System.out.println(lion);
		
		lion.grow(); 
		System.out.println(lion);
		
	}
	
	private void testRandomAnimal() {
		List<Animal> animals = (List<Animal>) new RandomAnimalBuilder().build(6); 
		for(Animal a : animals) {
			System.out.println(a);
			a.grow(); 
			System.out.println(a);
			
			System.out.println();
		}
	}
	
}





















