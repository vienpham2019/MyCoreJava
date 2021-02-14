package vienpham.core_java.common.animal.fish;

import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class AtlanticBluefinTuna extends Fish {
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
		setType("atlantic bluefin tuna");
		MATURITY = 8;
		MAX_AGE = 35;
		BIRTH_WEIGHT = 4;
		ADULT_FEMALE_MIN_WEIGHT = 496;
		ADULT_FEMALE_MAX_WEIGHT = 1497;
		ADULT_MALE_MIN_WEIGHT = 551;
		ADULT_MALE_MAX_WEIGHT = 2000;
		
		setMaxSwimmingSpeed(48); 
		
		prey.add("sardines"); 
		prey.add("herring"); 
		prey.add("maxkerel"); 
		prey.add("squid"); 
		prey.add("crustaceans"); 
		
		setEcosystem(EcosystemType.PELAGIC_OCEAN);

	}

	// Constructors
	public AtlanticBluefinTuna() {
		setRandomWeightByAge(); 
	}
	
	public AtlanticBluefinTuna(int a) {
		setAge(a); 
		setWeight(setRandomWeightByAge(a));
	}

/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
	// Object method overrides
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof AtlanticBluefinTuna) {
			result = super.equals(other);  // call fish equals method
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	/*
	 * At a young age, they eat tiny zooplankton, 
	 * and their prey increases in size as they do. 
	 * As adults, they eat fairly large bony fishes and invertebrates.
	 */
	public void eat() {
		if(getAge() == 0 && ( preyCaught == null || preyCaught.isEmpty() )) preyCaught = "baby tuna"; 
		super.eat(); 
	}
	
	@Override 
	/*
	 * Tuna don't have eyelids, so their eyes are always open.
	 * Their can able to engage in periods of deep rest while still swim
	 */
	public void sleep() {
		System.out.println(getExtenedType() + " in periods of deep rest while still swimming with eyeys open.");
	}
	
	@Override 
	/*
	 *  The oceanic whitetip shark is one of the shark species that never stops moving. 
	 *  Because they cannot pump water across their gills, 
	 *  they must constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.
	 */
	public void move() {	
	}
	
	//Overloading 
	//The female can release a large amount of eggs, sometimes releasing 2.6 million eggs per spawning
	public AtlanticBluefinTuna reproduce() {
		return new AtlanticBluefinTuna(); 
	}

	@Override
	public void hunt(List<? extends Animal> target) {
		// TODO Auto-generated method stub
		
	}
	
}





