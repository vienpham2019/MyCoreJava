package vienpham.core_java.common.animal.bird;

public class Duck extends Bird {
	
	public Duck() {
		setType("duck"); 
		MAX_AGE = 15; 
		
	}
	
/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
	// Animal method
	@Override 
	public void move() {
		super.move(); // call from bird class 
		System.out.println(getExtenedType() + " walking about the plains.");
	}
	
	// Bird methods
//	public boolean canFly() {return false;}
	public boolean canRun() {return false;}
	public boolean canSwim() {return true; }
	
}
