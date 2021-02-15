package vienpham.core_java.common.animal.marine_mammal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class NorthernFurSeal extends MarineMammal {
/* ************************ VARIABLES, GETTERS AND SETTERS SECTION ********************************
 * Variables with getters and setters
 * Static variables first, others organized by state
 */
	private boolean isSwimming = false;
	public boolean getIsSwimming(){return isSwimming; }
	public void setIsSwimming(boolean inS){ isSwimming = inS; } 

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
		
		setMaxSwimmingSpeed(15); 
		
		prey.add("tuna"); 
		prey.add("rockfish"); 
		prey.add("herring"); 
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
		if (getAge() == 0 && (preyCaught == null || preyCaught.isEmpty()) && Math.random() > 0.4 )
			preyCaught = "baby tuna";
		super.eat();
	}
	
	@Override 
	/*
	 * Fur seals sleep in water most of the time in a lateralized posture on the side while they paddle with only one front flipper to maintain the position
	 */
	public void sleep() {
		System.out.println(getExtenedType() + " sleep in water most of the time in a lateralized posture on the side while they paddle with only one front flipper to maintain the position.");
		while (getHealth() < 4) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changeHealth(1);
		}
		System.out.println(getHealth() + "\n");
	}
	
	@Override 
	/*
	 *  Although they feed on fish found in the open ocean, 
	 *  they are not deep divers like northern elephant seals,
	 *  with typical dives reaching just 200 feet. 
	 *  Their maximum dive depth has been observed to reach about 600 feet.
	 */
	public void move() {
		if (isFastSwimming()) {
			super.move();
			changeHealth(-3);
		} else {
			//Fur seals may swim by themselves or gather in small groups.
			double posibleOnLand = 0.6; 
			if(getAge() < 2) posibleOnLand += 0.1; 
			if(Math.random() > posibleOnLand) {
				setIsSwimming(false); 
				System.out.println(getExtenedType() + " move slowly on land.");
			}else {
				setIsSwimming(true); 
				System.out.println(getExtenedType() + " swim gather in small groups.");
			}
			changeHealth(-1);
		}
	}
	
	@Override 
	/*
	 * 	Males fast during the breeding season, and can lose 20 percent of their body weight during the 3 – 4 month period. 
	 *	Females return to the rookeries in late June to late July and give birth to a single pup, with most pups born in early July. 
	 * 	Northern fur seals mate on land usually within 11 day of giving birth.
	 */
	public NorthernFurSeal reproduce() {
		
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null;
		} else {
			if (getAge() > MATURITY) {
					NorthernFurSeal babySeal = new NorthernFurSeal();
					if (Math.random() > 0.6) {
						babySeal.setSex(Sex.MALE);
					}
				return babySeal;
			}
		}
		
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null;
	}

	
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
}
