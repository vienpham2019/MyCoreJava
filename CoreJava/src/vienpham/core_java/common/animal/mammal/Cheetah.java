package vienpham.core_java.common.animal.mammal;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Sex;
import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.AnimalType;
import vienpham.core_java.common.animal.RandomAnimalBuilder;

/**
 * @author Steve
 * Cheetahs are members of family Felidae in order Carnivora
 * This class is modeled on the southern cheetah found throughout south and east Africa
 *  The cheetah is characterised by a slender body, deep chest, spotted coat, small rounded head, 
 *  black tear-like streaks on the face, long thin legs and long spotted tail.Cheetahs are active 
 *  mainly during the day.
 *  They are the fastest land animal reaching speeds up to 75 mph in short bursts.
 *  Cheetahs inhabit a variety of habitats – dry forests, scrub forests and savannahs. 
 *  Cheetahs have the ability to survive with just one drink of water every three or four days.
 */
public class Cheetah extends Carnivora {
//**************************** VARIABLES SECTION ******************************

//*************************** CONSTRUCTOR SECTION *****************************
	public Cheetah() {
		setType("cheetah");
		MAX_AGE = 15;
		MATURITY = 4;
		prey.add("gazelle");
		prey.add("baby wildebeest");
		prey.add("impala");
		prey.add("rabbit");
		prey.add("warthog");
		setMaxRunningSpeed(75);
	}
	
	public Cheetah(int a) {
		this();
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}

//****************************** METHOD SECTION *******************************

	// Object overrides
	@Override
	public boolean equals(Object other){
		boolean result = false;
		if (other instanceof Cheetah) {
			result = super.equals(other);
		}
		return result;
	}

	// Animal overrides
	@Override
	public void eat() {
		if (getAge() < 2) {
			if (preyCaught == null && Math.random() > .7) {
				preyCaught = "rabbit";
				System.out.println("Mother brings a " + preyCaught);
			}
		}
		super.eat();
	}
	
	// overload 
	public void eat(String food) {
		System.out.println(getExtenedType() + " eat " + food);
	}

	@Override
	public void move() {
		changeHealth(-1);
		if (getAge() > MAX_AGE) 
			return;
		else if (getAge() > MAX_AGE-2)
			System.out.println("Old cheetah moves very slowly.");
		else if (getAge() > MATURITY) 
			System.out.println(getExtenedType() + " charging a herd of " + findPrey());
		else if (getAge() == 0)
			System.out.println("Cheetah cub batting a stick");
		else
			System.out.println("Young cheetah learning to sneak up on rabbit.");
	}

	@Override
	public void sleep() {
		System.out.print(this + " sleeping: ");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println(getHealth());
	}

	@Override
	public void setRandomWeightByAge () {
		// Female adults are between 50 and 140 lbs
		// Male adults are between 88 and 150 lbs
		// Cheetah cubs are born at about 10 lbs
		setRandomWeightByAge(50, 140, 88, 150, 10);
	}

	@Override
	public Cheetah reproduce() {
		if (getAge() >= MATURITY && getSex() == Sex.FEMALE) 
			return new Cheetah();
		else {
			System.out.println(getExtenedType() + " not old enough or is male");
			return null;
		}
	}

	// Carnivore override
	@Override
	public void hunt() {
		List<Animal> nearbyAnimals = (List<Animal>)new RandomAnimalBuilder(AnimalType.MAMMAL)
				.build(ThreadLocalRandom.current().nextInt(3, 10));
		hunt(nearbyAnimals);
	}

	// Carnivore overload
	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		
		if (getAge() > MAX_AGE) {
			return;
		} else if (getAge() == 0) {
			System.out.println("Cheetah cub batting a stick");
			return;
		} else if (getAge() < 2) {
			System.out.println("Young cheetah learning to sneak up on rabbit.");
			return;
		}

		if (getHealth() < 0 ) {
			System.out.println(this + " is too weak to hunt: " + getHealth());
			sleep();
		}

		System.out.println(this + " is hunting with a health of " + getHealth());
		// Conditions are met and the Cheetah looks for prey
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) { e.printStackTrace(); }
		Animal target = findPrey(nearbyAnimals);

		changeHealth(-1);
		if (target != null) {
			System.out.println(this.getExtenedType() + " is stalking a " + target.getExtenedType());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(-1);

			if  (catchPrey(target)) {
				nearbyAnimals.remove(target);
//				eat();
			}
//    		eat();
		}
	}

	// Cheetah methods
	public boolean catchPrey(Animal target) {
		int age = getAge();
		double probability = Math.random();
		if (age > MAX_AGE) return false;

		if (target != null) {
			System.out.println(this + " chasing a " + target + " with a health of " + target.getHealth());
			target.move();
			changeHealth(-2);
			target.changeHealth(-2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			if (target.isTargeted() && age > 2
				&& ((age < 5 && probability > .1) // .7
				|| (age < 12 && probability > .1) // .4
				|| (age >= 12 && probability > .1) ) ) { // .5
				System.out.println(this +  " caught a " + target.getExtenedType() + " in the grass!");
				this.preyCaught = target.getExtenedType();
				return true;
			} else {
				System.out.println(this + " could not catch the " + target.getExtenedType());
				this.preyFound = null;
				target.setTargeted(false);
			}
		} else {
			this.preyFound = null;
			System.out.println(this + " could not find prey!");
		}
		return false;
	}
}
