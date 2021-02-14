package vienpham.core_java.common.animal.cephalopod;

import java.util.ArrayList;
import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Carnivore;
import vienpham.core_java.common.animal.Sex;

public abstract class Cephalopod extends Animal implements Carnivore {

//*********************************** VARIABLES SECTION ***********************************

	private int maxSwimmingSpeed = 1; 
	protected void setMaxSwimmingSpeed(int speed ) { 
		if(speed > 1) {
			maxSwimmingSpeed = speed; // mph 
		}
	}

	protected List<String> prey = new ArrayList<>();
	
	protected String preyFound = null; 
	protected String preyCaught = null; 

//*********************************** CONSTRUCTOR SECTION ***********************************

	public Cephalopod() {
		setType("unknow cephalopod"); 
	}

//*********************************** METHOD SECTION ***********************************
//	Class Animal overrides
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " swimming in the water.");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping");
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
			System.out.println(getExtenedType() + " has not found food yet!");
			return false; 
		}else {
			double probability = Math.random(); 
			if(probability > .5) {
				preyCaught = preyFound; 
				return true;
			}
			return false; 
		}
	}

}
