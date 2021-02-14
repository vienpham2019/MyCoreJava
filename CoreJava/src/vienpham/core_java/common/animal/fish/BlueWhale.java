package vienpham.core_java.common.animal.fish;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;

public class BlueWhale extends Fish {
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
		MATURITY = 10;
		MAX_AGE = 90;
		BIRTH_WEIGHT = 200;
		ADULT_FEMALE_MIN_WEIGHT = 200000;
		ADULT_FEMALE_MAX_WEIGHT = 224000; // lb
		ADULT_MALE_MIN_WEIGHT = 17700;
		ADULT_MALE_MAX_WEIGHT = 224000;
		
		setType("blue whale");
		
		prey.add("krill"); 
		prey.add("crustaceans"); 
		prey.add("small fish"); 
		
		setWeight(BIRTH_WEIGHT);
		
		setMaxSwimmingSpeed(31); 
	}

	// Constructors
	public BlueWhale() {}
	
	public BlueWhale(int a) {
		setWeight(setRandomWeightByAge(a));
	}
	
	public BlueWhale(int a , int w, Sex s) {
		this(a); 
		setWeight(w); 
		setSex(s); 
	}

/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " swim forward by flexing their tails up and down.");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " while swimming slowly next to another animal or in a group, or floating on the surface (often called logging)");
	}
	
	@Override 
	public BlueWhale reproduce() {
		if(getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null; 
		}
		
		if(getAge() > MATURITY) {
			BlueWhale babyBlueWhale = new BlueWhale(); 
			if(ThreadLocalRandom.current().nextBoolean()) {
				babyBlueWhale.setSex(Sex.MALE);
			}
			return babyBlueWhale; 
		}else {
			System.out.println("Female " + getExtenedType() + " is not old enought.");
			return null; 
		}
	}

	@Override
	public void hunt(List<? extends Animal> target) {
		// TODO Auto-generated method stub
		
	}
}
