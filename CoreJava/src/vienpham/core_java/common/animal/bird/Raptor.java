package vienpham.core_java.common.animal.bird;

import java.util.ArrayList;
import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Carnivore;

public abstract class Raptor extends Bird implements Carnivore {

	protected List<String> prey = new ArrayList<>(); 
	
	protected String preyFound = null; 
	protected String preyCaught = null; 

	
	public Raptor() {
		setType("unknow raptor");
		food = BirdFood.MEAT; 
	}
	
//	Object Override Methods 
	@Override
	public boolean equals(Object other) {
		if (this == other) return true; 
		boolean result = false; 
		if(other instanceof Raptor) {
			result = super.equals(other)
					&& prey.equals(((Raptor)other).prey);
		}
		return result; 
	}
	
//  Bird Overrides Methods 
	public boolean canRun() {return false;}
	public boolean canSwim() {return false;}
	
//  Animal Overrides 
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findPrey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean catchPrey(Animal target) {
		// TODO Auto-generated method stub
		return false;
	}

}
