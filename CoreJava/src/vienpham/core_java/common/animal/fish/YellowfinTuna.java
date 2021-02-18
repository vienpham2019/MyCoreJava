package vienpham.core_java.common.animal.fish;

import java.util.ArrayList;
import java.util.List;

import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class YellowfinTuna extends Fish {
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
		setType("yellowfin tuna"); 
		
		MATURITY = 2;
		MAX_AGE = 18;
		BIRTH_WEIGHT = 31;
		ADULT_FEMALE_MIN_WEIGHT = 300;
		ADULT_FEMALE_MAX_WEIGHT = 400;
		ADULT_MALE_MIN_WEIGHT = 300;
		ADULT_MALE_MAX_WEIGHT = 400;
		
		prey.add("small fish");
		prey.add("squid");
		prey.add("crustacean");
		
		setEcosystem(EcosystemType.PELAGIC_OCEAN);
		
		setMaxSwimmingSpeed(50); 
	}

	public YellowfinTuna() {
		setRandomWeightByAge(); 
	}
	
	public YellowfinTuna(int a) {
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
		if(other instanceof YellowfinTuna) {
			result = super.equals(other);  // call fish equals method 
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	/*
	 * Image result for how young yellowfin tuna eat
	 * At a young age, they eat tiny zooplankton, and their prey increases in size as they do. 
	 * As adults, they eat fairly large bony fishes and squids.
	 */
	public void eat() {
		if(getAge() == 0 && ( preyCaught == null || preyCaught.isEmpty() )) preyCaught = "tiny zooplankton"; 
		super.eat(); 
	}
	
	@Override 
	/*
	 * Tuna don't have eyelids, so their eyes are always open.
	 * Their can able to engage in periods of deep rest while still swim
	 */
	public void sleep() {
		System.out.println(this + " in periods of deep rest while still swim.");
	}
	
	@Override 
	/*
	 * The tunas lack the ability to do so while stopped, 
	 * so they must continuously swim forward with their mouths open to keep their blood oxygenated. 
	 */
	public void move(){
		if(isFastSwimming()) {
			super.move();
			System.out.println(getExtenedType() + " swimming for its life!!!");
			changeHealth(-3); 
		}else {
			System.out.println(getExtenedType() + " continuously swim forward with their mouths open to keep their blood oxygenated.");
			changeHealth(-1); 
		}
	}
	
	public List<YellowfinTuna> reproduce(int num) {
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null;
		} else {
			if (getAge() > MATURITY) {
				List<YellowfinTuna> babyTunaList = new ArrayList<>(); 
					for(int i = 0 ; i < num ; i ++) {
						YellowfinTuna tunaBaby = new YellowfinTuna(); 
						if (Math.random() > 0.6) {
							tunaBaby.setSex(Sex.MALE);
						}
						babyTunaList.add(tunaBaby); 
					}
				return babyTunaList; 
			}
		}
		
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null; 
	}
	
	
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
}
