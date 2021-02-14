package vienpham.core_java.common.animal.mammal;

public class Monkey extends Mammal {
//*********************************** VARIABLES SECTION ***********************************
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	
	public Monkey() {
		setType("monkey"); // get this method from Animal class 
		MAX_AGE = 20; 
		MATURITY = 4; 
		setMaxRunningSpeed(34);
	}

//*********************************** METHOD SECTION ***********************************
//	Class Animal overrides
	@Override 
	public void eat() {
		System.out.println(getExtenedType() + " eating a banana!");
	}
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " swinging from branch to branch!");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping in a tree!");
	}
}
