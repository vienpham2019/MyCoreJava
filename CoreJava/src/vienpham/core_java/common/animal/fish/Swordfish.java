package vienpham.core_java.common.animal.fish;

import java.util.*;

import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class Swordfish extends Fish{
	
/* ************************ VARIABLES, GETTERS AND SETTERS SECTION ********************************
 * Variables with getters and setters
 * Static variables first, others organized by state
 */


/* ********************* CONSTRUCTORS AND INITIALZATION BLOCKS SECTION ****************************
 * Constructors and initialization blocks
 * static initialization blocks first, regular initialization blocks second
 * No argument constructor third, other constructors next
 */
	{
//		System.out.println("In Swordfish initialization block");
		setType("swordfish"); // get this method from Animal class 
		
		MATURITY = 5;
		MAX_AGE = 14;
		BIRTH_WEIGHT = 117;
		ADULT_FEMALE_MIN_WEIGHT = 220;
		ADULT_FEMALE_MAX_WEIGHT = 1433;
		ADULT_MALE_MIN_WEIGHT = 461;
		ADULT_MALE_MAX_WEIGHT = 1400;
		
		prey.add("squid");
		prey.add("kibble");
		prey.add("gecko");
		prey.add("hake"); 
		prey.add("octopus"); 
		prey.add("bluefish");
		prey.add("herring");
		prey.add("zooplankton");
		
		setEcosystem(EcosystemType.PELAGIC_OCEAN);
		
		setMaxSwimmingSpeed(68); 
	}
	public Swordfish() {
		setRandomWeightByAge(); 
	}

	public Swordfish(int a) {
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
		if(other instanceof Swordfish) {
			result = super.equals(other);  // call fish equals method
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	// At a young age, they eat tiny zooplankton, and their prey increases in size as they do.
	public void eat() {
	}
	
	@Override 
	public void sleep() {
	}
	
	@Override 
	/*
	 *  Swordfish are not schooling fish. 
	 *  They swim alone or in very loose aggregations, 
	 *  separated by as much as 10 m (33 ft) from a neighboring swordfish.
	 */
	public void move() {	
	}
	
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
}

