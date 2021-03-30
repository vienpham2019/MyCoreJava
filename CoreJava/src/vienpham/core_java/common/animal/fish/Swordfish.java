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
		if(getAge() == 0 && ( preyCaught == null || preyCaught.isEmpty() )) preyCaught = "tiny zooplankton"; 
		super.eat(); 
	}
	
	@Override 
	// sharks are able to engage in periods of deep rest while still swim but do not fall asleep in the traditional sense.
	public void sleep() {
		System.out.println(getExtenedType() + " in periods of deep rest while still swimming.");
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
	 *  Swordfish are not schooling fish. 
	 *  They swim alone or in very loose aggregations, 
	 *  separated by as much as 10 m (33 ft) from a neighboring swordfish.
	 */
	public void move() {	
		if (isFastSwimming()) {
			super.move();
			changeHealth(-3);
		} else {
			System.out.println(getExtenedType()
					+ " constantly swim forward.");
			changeHealth(-1);
		}
	}
	
	// Overload
	/*
	 * Females are able to reproduce between 4 and 5 years of age. 
	 * Depending on their size, females can produce anywhere from 1 million to 29 million eggs. 
	 */
	public List<Swordfish> reproduce(int num) {
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null;
		} else {
			if (getAge() > MATURITY) {
				List<Swordfish> babySwordfishList = new ArrayList<>(); 
					for(int i = 0 ; i < num ; i ++) {
						Swordfish babySwordfish = new Swordfish(); 
						if (Math.random() > 0.6) {
							babySwordfish.setSex(Sex.MALE);
						}
						babySwordfishList.add(babySwordfish); 
					}
				return babySwordfishList; 
			}
		}
		
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null; 
	}
	
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
}

