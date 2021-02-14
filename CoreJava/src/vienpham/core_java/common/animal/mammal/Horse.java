package vienpham.core_java.common.animal.mammal;

import vienpham.core_java.common.Nameable;
import vienpham.core_java.common.animal.Domesticatable;

public class Horse extends Mammal implements Nameable , Domesticatable {
//*********************************** VARIABLES SECTION ***********************************
	
//	Support Nameable interface 
	private String name; 
	public String getName() { return name; }
	public void setName(String n) { name = n; } 
	
//	Support Domesticatable interface 
	String breed; 
	public String getBreed() { return breed; } 
	public void setBreed(String b) { breed = b; } 
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	
	public Horse() {
		setType("horse"); // get this method from Animal class 
		MAX_AGE = 30; 
		MATURITY = 6; 
	}

//*********************************** METHOD SECTION ***********************************
//	Class Animal overrides
	@Override 
	public void eat() {
		System.out.println(getExtenedType() + " eating some hay !");
	}
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " running across the plains!");
	}
	
	
}
