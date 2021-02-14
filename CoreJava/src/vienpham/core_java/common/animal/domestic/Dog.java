package vienpham.core_java.common.animal.domestic;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Pet;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.mammal.Carnivora;

public class Dog extends Carnivora implements Pet {
	
/* ************************ VARIABLES, GETTERS AND SETTERS SECTION ********************************
 * Variables with getters and setters
 * Static variables first, others organized by state
 */

//	Support Nameable interface 
	private String name; 
	public String getName() { return name; }
	public void setName(String n) { name = n; } 
	
//	Support Domesticatable interface 
	String breed = ""; 
	public String getBreed() { return breed; } 
	public void setBreed(String b) { breed = b; } 


/* ********************* CONSTRUCTORS AND INITIALZATION BLOCKS SECTION ****************************
 * Constructors and initialization blocks
 * static initialization blocks first, regular initialization blocks second
 * No argument constructor third, other constructors next
 */
	public Dog() {
		setType("dog");
		MAX_AGE = 16; 
		MATURITY = 2; 
		prey.add("table scraps");
		prey.add("a bone");
		prey.add("Blue wilderness dog food");
		prey.add("grass from the lawn.");
	}
	
	public Dog(String n) {
		this(); 
		name = n; 
	}
	
/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
// Object method Overrides
	@Override 
	public boolean equals (Object other) {
		if(this == other ) return true; 
		boolean result = false; 
		if(other instanceof Carnivora) {
			result = super.equals(other) 
					 && name.equals(((Dog)other).name)
					 && breed.equals(((Dog)other).breed); 
		}
		
		return result; 
	}
	
	@Override 
	public int hashCode() {
		int code = super.hashCode(); 
		code += name.hashCode(); 
		code ^= breed.hashCode(); 
		return code; 
	}
		
	
//	Supports Pet interface
	@Override
	public boolean hasLicense() {
		return true;
	}
	@Override
	public void beFriendly() {
		String describe = name + " the " + breed; 
		System.out.println(describe + " licks your face");
	}
	
//	Overloading 
	public Dog[] reproduce(int number) {
		Dog[] litter = new Dog[number];
		
		if(getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null; 
		}
		
		if(getAge() > MATURITY) {
			for(int i = 0; i < number ; i ++) {
				Dog baby = new Dog(); 
				if(ThreadLocalRandom.current().nextBoolean()) {
					baby.setSex(Sex.MALE);
				}
				litter[i] = baby; 
			}
		}else {
			return null; 
		}
		
		return litter; 
	}
	@Override
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}
	
}



















