package vienpham.core_java.common.animal.mammal;

import java.util.List;

import vienpham.core_java.common.animal.Animal;

public abstract class Mammal extends Animal {
//*********************************** VARIABLES SECTION ***********************************
	
	private int maxRunningSpeed = 1; 
	protected void setMaxRunningSpeed(int speed ) { 
		if(speed > 1) {
			maxRunningSpeed = speed; 
		}
	}
	
	private transient boolean running = false; 
	public boolean isRunning() { return running; } 
	public void setRunning (boolean in) { 
		running = in; 
	}

//*********************************** CONSTRUCTOR SECTION ***********************************
	
	public Mammal() {
		setType("unknow mammal");
	}

//*********************************** METHOD SECTION ***********************************
	
//	Mammal methods 
	public int getRunningSpeed() {
		int speed; 
		
		if(getHealth() > 4) speed = maxRunningSpeed; 
		else if(getHealth() > 3) speed = (int) (maxRunningSpeed * 0.9); 
		else if(getHealth() > 1) speed = (int) (maxRunningSpeed * 0.8); 
		else if(getHealth() > -1) speed = (int) (maxRunningSpeed * 0.7); 
		else if(getHealth() > -2) speed = (int) (maxRunningSpeed * 0.6); 
		else if(getHealth() > -4) speed = (int) (maxRunningSpeed * 0.5);
		else if(getHealth() > -6) speed = (int) (maxRunningSpeed * 0.3); 
		else if(getHealth() > -8) speed = (int) (maxRunningSpeed * 0.1); 
		else speed = 1; 
		
		return speed; 
	}
	
//	Object Override method 
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof Mammal) {
			result = super.equals(other) // call animal equals method
						&& maxRunningSpeed == ((Mammal)other).maxRunningSpeed; 
		}
		return result; 
	}
	
	@Override 
	public int hashCode() {
		int code = super.hashCode(); 
		code ^= maxRunningSpeed * 12;
		return code; 
	}
	
//	Animal method override 
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " run at max seed " + maxRunningSpeed + " mph.");
	}

                  
}












