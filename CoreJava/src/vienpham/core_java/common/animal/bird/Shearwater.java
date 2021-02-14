package vienpham.core_java.common.animal.bird;

import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.fish.YellowfinTuna;

public class Shearwater extends Raptor {
/* ************************ VARIABLES, GETTERS AND SETTERS SECTION ********************************
 * Variables with getters and setters
 * Static variables first, others organized by state
 */


/* ********************* CONSTRUCTORS AND INITIALZATION BLOCKS SECTION ****************************
 * Constructors and initialization blocks
 * static initialization blocks first, regular initialization blocks second
 * No argument constructor third, other constructors next
 */

	{ // Initialization block runs after the call to super()
		MATURITY = 8;
		MAX_AGE = 15;
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 2;
		ADULT_FEMALE_MAX_WEIGHT = 3;
		ADULT_MALE_MIN_WEIGHT = 2;
		ADULT_MALE_MAX_WEIGHT = 3;
		
		prey.add("crustaceans");
		prey.add("fish");
		prey.add("cephaloponds");
		prey.add("salps");
		
		setType("shear water");
	}

	// Constructors
	public Shearwater() {
		setRandomWeightByAge(); 
	}
	
	public Shearwater(int a) {
		setAge(a); 
		setWeight(setRandomWeightByAge(a));
	}

/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof Shearwater) {
			result = super.equals(other);  // call bird equals method
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	/*
	 * The Manx shearwater feeds on small fish (herrings, sprats, and sand eels), 
	 * crustaceans, cephalopods, and surface offal. 
	 */
	public void eat() {
	}
	
	@Override 
	public void sleep() {
	}
	
	@Override 
	public void move() {	
	}	
	
	
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	@Override 
	public boolean canFly() {return true;}
	@Override 
	public boolean canRun() {return true;}
	@Override 
	public boolean canSwim() {return true; }

	@Override
	public void hunt(List<? extends Animal> target) {
		// TODO Auto-generated method stub
		
	}
	
	// Support interface
	
}
