package vienpham.core_java.common.animal.cephalopod;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;

public class OegopsidaSquid extends Cephalopod {
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
		
		setType("oegopsida squid");
				
	}

	// Constructors
	public OegopsidaSquid() {}
	

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
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}
}
