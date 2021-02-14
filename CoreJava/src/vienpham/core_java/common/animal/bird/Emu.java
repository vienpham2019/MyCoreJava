package vienpham.core_java.common.animal.bird;


public class Emu extends Bird {
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
		MATURITY = 3;
		MAX_AGE = 20;
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 69;
		ADULT_FEMALE_MAX_WEIGHT = 82;
		ADULT_MALE_MIN_WEIGHT = 90;
		ADULT_MALE_MAX_WEIGHT = 132;
	}

	// Constructors
	public Emu() {
		setType("emu");
	}

/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
//	Override Object methods
	@Override 
	public String toString() {
		String result = getExtenedType() + " ( Age: " + getAge() + ", Weight: " + getWeight() + " lbs )"; 
		result += ", " + sex.toString().charAt(0) + ")"; 
		return result; 
	}
	
	// Animal method
	@Override 
	public void move() {
		super.move(); // call from bird class 
		System.out.println(getExtenedType() + " walking about the plains.");
	}
	
	// Bird methods
	public boolean canFly() {return false;}
	public boolean canRun() {return true;}
	public boolean canSwim() {return false; }
}
