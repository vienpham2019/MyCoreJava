package vienpham.core_java.common.animal.bird;

import java.util.List;

import vienpham.core_java.common.animal.Animal;

public class Hawk extends Raptor {

	public Hawk() {
		setType("hawk"); 
		MAX_AGE = 12; 
		MATURITY = 2;
		prey.add("mouse"); 
		prey.add("squirrel");
		prey.add("turtle");
	}
	
	
/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
//	Animal overrides method 
	public void move() {
		super.move();
		System.out.println(getExtenedType() + " soaring on the ");
	}
	
	// Bird methods
	public boolean canSwim() {return false; }

}
