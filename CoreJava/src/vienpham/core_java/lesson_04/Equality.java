package vienpham.core_java.lesson_04;

import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.bird.BirdFood;
import vienpham.core_java.common.animal.mammal.*;

public class Equality {

	public Equality() {
		// TODO Auto-generated constructor stub
	}
	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		primitiveEquality();
		referenceQuality(); 
//		emumEquality();

		System.out.println("================================================================================================================\n\n");
	}

	private void primitiveEquality() {
		int x = 7; 
		int y = 7; 
		// Test for equality is the double equal 
		System.out.println(x == y);
		
		// Test for inequality is the bag equal 
		System.out.println(x != y);
		
		// Primitives support equality of all numeric types 
		double dy = 7.0; 
		System.out.println(x == dy);
		
		System.out.println(y != dy);
	}
	
	private void emumEquality() {
		System.out.println("2. Enum equality: /n");
		BirdFood foodType = BirdFood.UNKNOW; 
		System.out.println(foodType == BirdFood.FRUIT);
		System.out.println(foodType == BirdFood.UNKNOW);
		
	}
	
	private void referenceQuality() {
		System.out.println("3. Reference equality: \n");
		Elephant el1 = new Elephant();
//		el1.setAge(5); 
//		el1.setWeight(500);
//		el1.setSex(Sex.MALE);
		Elephant el2 = new Elephant();
		System.out.println(el1);
		System.out.println(el2);
		
		System.out.println(el1 == el2);
		System.out.println(el1.equals(el2));
	}

}
