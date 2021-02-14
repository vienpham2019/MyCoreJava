package vienpham.core_java.common.animal.fish;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Carnivore;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.mammal.Mammal;

public abstract class Fish extends Animal implements Carnivore {
	
//*********************************** VARIABLES SECTION ***********************************
	
	private int maxSwimmingSpeed = 1; 
	protected void setMaxSwimmingSpeed(int speed ) { 
		if(speed > 1) {
			maxSwimmingSpeed = speed; // mph 
		}
	}

	protected List<String> prey = new ArrayList<>();
	
	protected transient String preyFound = null;  //The transient is used to avoid serialization.
	protected transient String preyCaught = null; 
	
	private transient boolean fastSwimming = false; 
	public boolean isFastSwimming() { return fastSwimming; } 
	public void setFastSwimming (boolean in) { 
		fastSwimming = in; 
	}

//*********************************** CONSTRUCTOR SECTION ***********************************

	
	public Fish() {
//		System.out.println("In Fish no arg constructor");
		setType("unknow fish");
	}
	
//*********************************** METHOD SECTION ***********************************
	
//	Object Override method 
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof Fish) {
			result = super.equals(other) // call animal equals method
						&& maxSwimmingSpeed == ((Fish)other).maxSwimmingSpeed; 
		}
		return result; 
	}
	
	@Override 
	public int hashCode() {
		int code = super.hashCode(); 
		code ^= maxSwimmingSpeed * 12;
		return code; 
	}
	
	
//	Animal override method
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " swimming at max speed " + maxSwimmingSpeed + " mph.");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping with its eyes open!");
	}
	
	@Override 
	public void eat () {
		if(preyCaught == null || preyCaught.isEmpty()) {
			System.out.println(getExtenedType() + " has nothing to eat");
		}else {
			System.out.println(getExtenedType() + " easts a " + preyCaught);
			preyCaught = null; 
		}
	}
	
	@Override
	public void hunt() {
		findPrey(); 
		catchPrey(null); 
		eat(); 
	}
	
	@Override
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}

	@Override
	public String findPrey() {
		if(preyFound == null) {
			int x = (int) (Math.random() * prey.size());
			preyFound = prey.get(x); 
		}
		return preyFound;
	}

	@Override
	public boolean catchPrey(Animal target) {
		if(preyFound == null || preyFound.isEmpty()) {
			System.out.println(this.getExtenedType() + " has not found food yet!");
			return false; 
		}else {
			double probability = Math.random(); 
			if(probability > .5) {
				System.out.println(this+ " caught a " + target );
				preyCaught = preyFound; 
				return true;
			}
			System.out.println(this + " cound not caught " + target );
			return false; 
		}
	}
	
}
