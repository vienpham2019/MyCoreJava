package vienpham.core_java.common.animal.fish;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.mammal.Mammal;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class GreateWhiteShark extends Fish {
	/*
	 * ************************ VARIABLES, GETTERS AND SETTERS SECTION
	 * ******************************** Variables with getters and setters Static
	 * variables first, others organized by state
	 */

	/*
	 * ********************* CONSTRUCTORS AND INITIALZATION BLOCKS SECTION
	 * **************************** Constructors and initialization blocks static
	 * initialization blocks first, regular initialization blocks second No argument
	 * constructor third, other constructors next
	 */

	{ // Initialization block runs after the call to super()
		setType("greate white shark");

		MATURITY = 26;
		MAX_AGE = 70;
		BIRTH_WEIGHT = 55;
		ADULT_FEMALE_MIN_WEIGHT = 1500;
		ADULT_FEMALE_MAX_WEIGHT = 2450;
		ADULT_MALE_MIN_WEIGHT = 1151;
		ADULT_MALE_MAX_WEIGHT = 1700;

		prey.add("herring");
		prey.add("hake");
		prey.add("cod");
		prey.add("haddock");
		prey.add("tuna");
		prey.add("swordfish");
		prey.add("shear water");
		prey.add("seal");
		prey.add("carrion"); // dead animal

		setEcosystem(EcosystemType.PELAGIC_OCEAN);
		setMaxSwimmingSpeed(25); // mph
	}

	// Constructors
	public GreateWhiteShark() {
		setRandomWeightByAge();
	}

	public GreateWhiteShark(int a) {
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}

	/*
	 * ******************************* METHODS SECTION
	 * ************************************************ Methods other than getters
	 * and setters section These should be organized by parent classes, overrides
	 * first
	 */
	// Object method overrides
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		boolean result = false;
		if (other instanceof GreateWhiteShark) {
			result = super.equals(other); // call fish equals method
		}
		return result;
	}

	// Animal method overrides
	@Override
	// As soon as the baby shark is born, they are ready to swim and hunt.
	public void eat() {
		if (getAge() == 0 && (preyCaught == null || preyCaught.isEmpty()))
			preyCaught = "baby tuna";
		super.eat();
	}

	@Override
	// sharks are able to engage in periods of deep rest while still swim but do not
	// fall asleep in the traditional sense.
	public void sleep() {
		System.out.println(getExtenedType() + " in periods of deep rest while still swimming.");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changeHealth(1);
		}
		System.out.println(getHealth() + "\n");
	}

	@Override
	/*
	 * The oceanic whitetip shark is one of the shark species that never stops
	 * moving. Because they cannot pump water across their gills, they must
	 * constantly swim forward with their mouths slightly open in order to obtain
	 * sufficient oxygen from the water.
	 */
	public void move() {
		if (isFastSwimming()) {
			super.move();
			changeHealth(-3);
		} else {
			System.out.println(getExtenedType()
					+ " constantly swim forward with their mouths slightly open in order to obtain sufficient oxygen from the water.");
			changeHealth(-1);
		}
	}

	// The oceanic whitetip shark is viviparous with litters of 5 to 15 pups which
	// are born at a length of 65 to 75 cm (26 to 30 in)
	// Overloading.
	public List<GreateWhiteShark> reproduce(int number) {
		List<GreateWhiteShark> babys = new ArrayList<>();
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null;
		} else {
			if (getAge() > MATURITY) {
				for (int i = 0; i < number; i++) {
					GreateWhiteShark babyShark = new GreateWhiteShark();
					if (ThreadLocalRandom.current().nextBoolean()) {
						babyShark.setSex(Sex.MALE);
					}
					babys.add(babyShark);
				}
				return babys;
			}
		}
		System.out.println("Female " + getExtenedType() + " is not old enought.");
		return null;
	}

	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		// check for age
		if (getAge() > MAX_AGE) {
			System.out.println(getExtenedType() + " is dead");
			return;
		}

		// check for health
		if (getHealth() < 0) {
			System.out.println(getExtenedType() + " is too weak to hunt: " + getHealth());
			sleep();
		}
		System.out.println(this + " is hunting with the health of " + getHealth());

		// find prey
		Animal target = findPrey(nearbyAnimals); 

		changeHealth(-1); 
		if(target != null) {
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// catch prey
			if(catchPrey(target)) {
				nearbyAnimals.remove(target);
			}
			eat();
		}

	}

	// Overload
	/*
	 * Juvenile white sharks predominantly prey on fish, including other
	 * elasmobranchs. Their jaw cartilage mineralizes enough to withstand the impact
	 * of biting into larger prey species.
	 * 
	 * Upon approaching a length of nearly 4 m (13 ft), great white sharks begin to
	 * target predominantly marine mammals for food
	 */
	public Animal findPrey(List<? extends Animal> nearbyAnimals) {

		Animal target = null; 
		
		animalLoop: 
		for (Animal animal : nearbyAnimals) {
			for (String preyType : prey) {
				if (getAge() < MATURITY) {
					if (!(animal instanceof Mammal)) {

						if (animal.getAge() > 5 && animal.getType().contains(preyType)) {
							target = animal; 
							break animalLoop; 
						} else if (animal.getExtenedType().contains("baby " + preyType)) {
							target = animal; 
							break animalLoop; 
						}

					}

				} else {
					if(animal.getType().contains(preyType)) {
						if(target == null) target = animal; 
						if(animal instanceof Mammal) {
							target = animal; 
							break animalLoop; 
						}
					}
				}

			}
		}

		if(target == null) {
			System.out.println(this + " cound not found prey");
			this.preyFound = null; 
		}else {
			System.out.println(this + " selected a " + target);
			this.preyFound = target.getExtenedType(); 
		}
		
		return target;
	}
	
	@Override
	public boolean catchPrey(Animal target) {
		if(this.preyFound == null || this.preyFound.isEmpty()) {
			System.out.println(this.getExtenedType() + " has not found food yet!");
			return false; 
		}else {
			double probability = Math.random(); 
			if(
				(target.getAge() > target.getMaxAge()) || 
				(target.getExtenedType().contains("baby") && probability > .1) || 
				(target.getExtenedType().contains("juvenile") && probability > .3) || 
				probability > .5 ) {
				
				System.out.println(this+ " caught a " + target );
				preyCaught = preyFound; 
				return true;
			}
			System.out.println(this + " cound not caught " + target );
			return false; 
		}
	}

	// Mammal, Bird, Fish or Reptile method overrides
	// Support interface
}
