package vienpham.core_java.common.animal.fish;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.marine_mammal.NorthernFurSeal;
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
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println(this + " health: " + getHealth() + "\n");
	}
	
	@Override 
	/*
	 *  The oceanic whitetip shark is one of the shark species that never stops moving. 
	 *  Because they cannot pump water across their gills, 
	 *  they must constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.
	 */
	public void move() {	
		if (isFastSwimming()) {
			super.move();
			changeHealth(-3);
		} else {
			System.out.println(getExtenedType()
					+ " constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.");
			changeHealth(-1);
		}
	}
	
	//Overloading 
	//The female can release a large amount of eggs, sometimes releasing 2.6 million eggs per spawning
	public List<AtlanticBluefinTuna> reproduce(int num) {
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null;
		} else {
			if (getAge() > MATURITY) {
				List<AtlanticBluefinTuna> tunaBabyList = new ArrayList<>(); 
					for(int i = 0 ; i < num ; i ++) {
						AtlanticBluefinTuna tunaBaby = new AtlanticBluefinTuna(); 
						if (Math.random() > 0.6) {
							tunaBaby.setSex(Sex.MALE);
						}
						tunaBabyList.add(tunaBaby); 
					}
				return tunaBabyList; 
			}
		}
		
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null; 
	}
	
}





