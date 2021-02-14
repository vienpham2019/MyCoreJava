package vienpham.core_java.common.animal.reptile;

import java.util.ArrayList;
import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Carnivore;
import vienpham.core_java.common.animal.Sex;

public abstract class Reptile extends Animal implements Carnivore {

	protected List<String> prey = new ArrayList<>(); 
	
	protected String preyFound = null; 
	protected String preyCaught = null; 
	
	public Reptile() {
		// TODO Auto-generated constructor stub
	}
	
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
	public String findPrey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean catchPrey(Animal target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}

}
