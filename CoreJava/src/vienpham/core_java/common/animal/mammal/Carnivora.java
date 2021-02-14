package vienpham.core_java.common.animal.mammal;

import java.util.ArrayList;
import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Carnivore;

public abstract class Carnivora extends Mammal implements Carnivore {

//*********************************** VARIABLES SECTION ***********************************

	protected List<String> prey = new ArrayList<>();
//	public void setPrey(String[] newPreys) {
//		prey = Array.asList(newPreys); 
//	}

	protected transient String preyFound = null;
	protected transient String preyCaught = null;

	public String getPreyCaugth() {
		return preyCaught;
	}

//*********************************** CONSTRUCTOR SECTION ***********************************

	public Carnivora() {
		setType("unknown carnivore");
	}

//*********************************** METHOD SECTION ***********************************

// Object method Overrides
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		boolean result = false;
		if (other instanceof Carnivora) {
			result = super.equals(other) && prey.equals(((Carnivora) other).prey);
		}

		return result;
	}

	@Override
	public int hashCode() {
		int code = super.hashCode();
		code ^= prey.hashCode();
		return code;
	}

//  Animal Overrides 
	@Override
	public void eat() {
		if (preyCaught == null || preyCaught.isEmpty()) {
			System.out.println(getExtenedType() + " has nothing to eat");
		} else {
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
		if (preyFound == null) {
			int x = (int) (Math.random() * prey.size());
			preyFound = prey.get(x);
		}
		return preyFound;
	}

	// Overload the findPrey() method to use a list of animal
	public Animal findPrey(List<? extends Animal> nearbyAnimals) {
		// Looking for prey takes energy, so decrease the health

		changeHealth(-1);

		// Scan the nearby animals to see if any are on the preferred list

		List<Animal> possibleTargets = new ArrayList<>();
		System.out.print(this.getExtenedType() + " sees ");

		// In a loop create a list of possible target

		for (Animal animal : nearbyAnimals) {
			for (String type : prey) {
				if (animal.getType().contains(type)) {
					System.out.print(animal + ",");
					possibleTargets.add(animal);
				}
			}
		}
		System.out.println();

		// Print out a list of possible targets

		// Set up the process of selecting a target in its own thread

		Animal target = null;
		synchronized (nearbyAnimals) {
			// Find the weakest target
			if (possibleTargets.size() > 0) {

				for (Animal a : possibleTargets) {
					if (a.isTargeted())
						continue;
					if (target == null) {
						target = a;
					} else if (a.getHealth() < target.getAge()) {
						target = a;
					}
				}
			}
			// Set the target in preyFound
			if (target == null) {
				System.out.println(this + " cound not found prey");
				preyFound = null;
			} else {
				target.setTargeted(true);
				preyFound = target.getExtenedType();
				System.out.println(this + " selected a " + target);
			}
		}
		// Return the target to use in the catch prey method
		return target;
	}

	@Override
	public boolean catchPrey(Animal target) {
		if (preyFound == null || preyFound.isEmpty()) {
			System.out.println(getExtenedType() + " has not found food yet!");
			return false;
		} else {
			double probability = Math.random();
			if (probability > .5) {
				preyCaught = preyFound;
				return true;
			}
			return false;
		}
	}

	@Override
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE)
			return; // the hunter is dead
		hunt();
	}

}
