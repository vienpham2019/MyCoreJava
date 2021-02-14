package vienpham.core_java.common.animal.bird;


public class Parrot extends Bird {
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
		MATURITY = 2;
		MAX_AGE = 100;
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 10;
		ADULT_FEMALE_MAX_WEIGHT = 15;
		ADULT_MALE_MIN_WEIGHT = 12;
		ADULT_MALE_MAX_WEIGHT = 18;
	}

	// Constructors
	public Parrot() {
		setType("parrot");
		food = BirdFood.SEEDS;
		
	}

/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Bird methods
		public boolean canFly() {return false;}
		public boolean canRun() {return true;}
		public boolean canSwim() {return false; }
	// Support interface
	
}
