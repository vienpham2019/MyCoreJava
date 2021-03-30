package vienpham.core_java.common.animal.fish;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.ecosystem.EcosystemType;


public class OceanicWhitetipShark extends Fish {
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
		setType("oceanic whitetip shark"); 
		
		MATURITY = 4;
		MAX_AGE = 20;
		BIRTH_WEIGHT = 48;
		ADULT_FEMALE_MIN_WEIGHT = 205;
		ADULT_FEMALE_MAX_WEIGHT = 375;
		ADULT_MALE_MIN_WEIGHT = 100;
		ADULT_MALE_MAX_WEIGHT = 368;
		
		prey.add("herring");
		prey.add("hake");
		prey.add("cod");
		prey.add("haddock");
		prey.add("butterfish");
		prey.add("sea raven");
		prey.add("tuna");
		prey.add("shear water");
		prey.add("seal");
		prey.add("carrion"); // dead animal
		
		setEcosystem(EcosystemType.PELAGIC_OCEAN);
		setMaxSwimmingSpeed(21); 
	}

	// Constructors
	public OceanicWhitetipShark() {
		setRandomWeightByAge(); 
	}
	
	public OceanicWhitetipShark(int a) {
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
		if(other instanceof OceanicWhitetipShark) {
			result = super.equals(other);  // call fish equals method
		}
		return result; 
	}
	
	// Animal method overrides
	@Override 
	//As soon as the baby shark is born, they are ready to swim and hunt.
	public void eat() {
		if(getAge() == 0 && ( preyCaught == null || preyCaught.isEmpty() )) preyCaught = "baby tuna"; 
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
	 *  The oceanic whitetip shark is one of the shark species that never stops moving. 
	 *  Because they cannot pump water across their gills, 
	 *  they must constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.
	 */
	public void move() {	
		if(isFastSwimming()) {
			super.move();
			changeHealth(-3); 
		}else {
			System.out.println(getExtenedType() + " constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.");
			changeHealth(-1); 
		}
	}
	
	// The oceanic whitetip shark is viviparous with litters of 5 to 15 pups which are born at a length of 65 to 75 cm (26 to 30 in)
	// Overloading.  
	public List<OceanicWhitetipShark> reproduce(int number) {
		List<OceanicWhitetipShark> babys = new ArrayList<>(); 
		if(getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null; 
		}else {
			if(getAge() > MATURITY) {
				for(int i = 0 ; i < number ; i ++) {
					OceanicWhitetipShark babyShark = new OceanicWhitetipShark(); 
					if(ThreadLocalRandom.current().nextBoolean()) {
						babyShark.setSex(Sex.MALE);
					}
					babys.add(babyShark); 
				}
				return babys; 
			}	
		}
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null; 
	}

	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		// check for age 
		if(getAge() > MAX_AGE) {
			System.out.println(getExtenedType() + " is dead");
			return; 
		}
		
		// check for health 
		if(getHealth() < 0) {
			System.out.println(getExtenedType() + " is too weak to hunt: " + getHealth());
			sleep();
		}
		System.out.println(this + " is hunting with the health of " + getHealth());
		
		// find prey
		Animal target = findPrey(nearbyAnimals); 
		
		if(target != null) {
			changeHealth(-2); 
			// catch prey 
			if(catchPrey(target)) {
				nearbyAnimals.remove(target); 
				
				if(target.getWeight() > getWeight() * 0.3) changeHealth(10); 
				else changeHealth(5); 
				if(Math.random() > 0.3) grow(); 
				System.out.println(this + " health: " + getHealth());
			}
			eat(); 
			
		}
		
	}
	
	
	public Animal findPrey(List<? extends Animal> nearbyAnimals) {
		Animal target = null; 
		
		findPreyLoop: 
		for(Animal animal : nearbyAnimals) {
			for(String preyType : prey) {
				if(animal.getAge() < animal.getMaxAge()) {
					target = animal; 
					break findPreyLoop; 
				}
				if(animal.getType().contains(preyType)) {
					
					if(getAge() < MATURITY && 
					  (animal.getExtenedType().contains("baby") || animal.getExtenedType().contains("juvenile")) 
					  ){
						target = animal; 
						break findPreyLoop; 
					}
					
				}
			}
		}
		
		if(target == null) {
			System.out.println(this + " cound not found prey");
			this.preyFound = null; 
		}else {
			System.out.println(this + " selected a " + target);
			this.preyFound = target.getExtenedType(); 
		}
		return null ; 
	}
	
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
}


















