package vienpham.core_java.common.animal.mammal;

import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.Sex;

public class Elephant extends Herders {
//*********************************** VARIABLES SECTION ***********************************
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	
	public Elephant() {
		setType("elephant"); // get this method from Animal class 
		MAX_AGE = 70; 
		MATURITY = 15; 

		BIRTH_WEIGHT = 200; 
		ADULT_FEMALE_MIN_WEIGHT = 5300; 
		ADULT_FEMALE_MAX_WEIGHT = 7700; 
		ADULT_MALE_MIN_WEIGHT = 8800; 
		ADULT_MALE_MAX_WEIGHT = 13900; 
		
		setMaxRunningSpeed(20);
	}
	
	
//This is overloading the constructor 
	public Elephant(int a) {
		this();
		setAge(a); 
		setWeight(setRandomWeightByAge(a));
	}

//*********************************** METHOD SECTION ***********************************

//	Class Animal overrides
	@Override 
	public void eat() {
		if(getAge() == 0) {
			System.out.println(" baby new born.");
		}else {
			System.out.println(getExtenedType() + " chomping tree branches");
		}
	}
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " shuffling ponderously");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping on its feet!");
	}
	
//	Elephant return type is a covariant return 
	@Override 
	public Elephant reproduce() {
		if(getSex() == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null; 
		}
		
		if(getAge() > MATURITY) {
			Elephant baby = new Elephant(); 
			if(ThreadLocalRandom.current().nextBoolean()) {
				baby.setSex(Sex.MALE);
			}
			return baby; 
		}else {
			System.out.println("Female " + getExtenedType() + " is not old enought.");
			return null; 
		}
		
	}
}
