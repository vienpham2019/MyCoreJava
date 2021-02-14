package vienpham.core_java.common.animal.bird;

import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.mammal.Mammal;

public abstract class Bird extends Animal {
	
//	***************************** VARIABLES, GETTER AND SETTER SECTION *******************
	
	protected BirdFood food; 
	public String getFood() {
		return food.toString().toLowerCase(); 
	}
	
//	***************************** CONSTRUCTORS AND INITIALIZATION BLOCKS SECTION *******************

	public Bird() {
		setType("unknown bird"); 
	}
	
//	***************************** METHODS SECTION *******************

//	Object Override method 
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof Bird) {
			result = super.equals(other)
					&& food == ((Bird)other).food;
		}
		return result; 
	}
	
	// Animal method
	@Override 
	public void move() {
		if(canFly()) {
			System.out.println(getExtenedType() + " flying!");
		}else if(canRun()) {
			System.out.println(getExtenedType() + " running!");
		}else if (canSwim()) {
			System.out.println(getExtenedType() + " swimming!");
		}else {
			throw new RuntimeException("Bird can't fly, run or swim: implement the correct behavior in your class");
		}
	}

	
	// Bird methods
	public boolean canFly() {return true; }
	public abstract boolean canRun();
	public abstract boolean canSwim();
}
