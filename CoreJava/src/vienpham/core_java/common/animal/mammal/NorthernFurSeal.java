package vienpham.core_java.common.animal.mammal;

import vienpham.core_java.common.ecosystem.EcosystemType;

public class NorthernFurSeal extends Carnivora {
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
		setType("northern fur seal"); // get this method from Animal class 
		
		MAX_AGE = 20; 
		MATURITY = 5; 
		
		BIRTH_WEIGHT = 12; 
		ADULT_FEMALE_MIN_WEIGHT = 88; 
		ADULT_FEMALE_MAX_WEIGHT = 140; 
		ADULT_MALE_MIN_WEIGHT =  386; 
		ADULT_MALE_MAX_WEIGHT = 606; 
		
		setMaxRunningSpeed(15);
		
		prey.add("oceanic fish"); 
		prey.add("squid") ;
		
		setEcosystem(EcosystemType.PELAGIC_OCEAN);
	}
	
	public NorthernFurSeal() {
		setRandomWeightByAge(); 
	}
	
	public NorthernFurSeal(int a) {
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
		if(other instanceof NorthernFurSeal) {
			result = super.equals(other);  // call mammal equals method
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	// About four months on this cycle, the pups wean from their mothers. 
	public void eat() {
	}
	
	@Override 
	/*
	 * Fur seals sleep in water most of the time in a lateralized posture on the side while they paddle with only one front flipper to maintain the position
	 */
	public void sleep() {
	}
	
	@Override 
	/*
	 *  Although they feed on fish found in the open ocean, 
	 *  they are not deep divers like northern elephant seals,
	 *  with typical dives reaching just 200 feet. 
	 *  Their maximum dive depth has been observed to reach about 600 feet.
	 */
	public void move() {	
	}
	
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
}
