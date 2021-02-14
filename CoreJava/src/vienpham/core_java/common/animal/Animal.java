package vienpham.core_java.common.animal;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.ecosystem.EcosystemType;

public class Animal extends Object implements Comparable<Animal> , Serializable {
//*********************************** VARIABLES SECTION ***********************************
	
//	Variables and with getters and setters 
//	Static variables first 
	
	private static final long serialVersionUID = 1L;

	// This is a static or class primitive variable 
	private static int count = 0; 
	public static int getCount() {return count;}
	
	// This is an instance reference variable 
	private String type;
	public String getType() {return type;}
	final protected void setType(String t) {  // protected is help all the class who extends the Animal class can access it
		type = t; 							 // final variable is to create constant variable 
	}										// final method is to prevent method overriding 
									       // final class is to prevent class inheritance
	private int age = 0; 
	public int getAge() { return age; }
	public void setAge(int a) { 
		if(a < 0) {
			age = 0 ;
			throw new AgeException(a , MAX_AGE , this.getClass()); 
		}else if(a > MAX_AGE) {
			age = a + 1; 
			System.out.println(this.toString() + " has died");
			throw new AgeException(a , MAX_AGE , this.getClass()); 
		}else {
			age = a;
		}
	}
	
	protected int MATURITY = 12; 
	protected int MAX_AGE = 50; 
	protected int BIRTH_WEIGHT = 10; 
	protected int ADULT_FEMALE_MIN_WEIGHT = 100; 
	protected int ADULT_FEMALE_MAX_WEIGHT = 150; 
	protected int ADULT_MALE_MIN_WEIGHT = 120; 
	protected int ADULT_MALE_MAX_WEIGHT = 180; 
	
	
	public int getMaxAge() {return MAX_AGE;}
	
	private int weight; 
	public int getWeight() { return weight; }
	public void setWeight(int w) { 
		if(w >= 0)  weight = w; 
	}
	
	public Sex sex = Sex.FEMALE; 
	public Sex getSex() { return sex ; } 
	public void setSex(Sex s) { sex = s; } 
	
	private byte health = 10; 
	public byte getHealth() { return health; }
	public void setHealth(byte b) {
		if(b <= 10 && b >= -10) { 
			health = b; 
		}else {
			throw new IllegalArgumentException("Health must be between -10 and +10 inclusive"); // it will throw err message to console if set health over 10 or -10 
		}
	}
	
	public transient boolean targeted = false; 
	public boolean isTargeted() {return targeted; }
	public void setTargeted(boolean b) { targeted = b; } 
	
	private EcosystemType ecosystemType = EcosystemType.UNKNOWN; 
	public void setEcosystem(EcosystemType est) { ecosystemType = est; } 
	public EcosystemType getEcosystem() {return ecosystemType; } 
	
	// support unique id for file and rdbms DAOs
	private int animalId = 0; 
	public void setAnimalId(int id) {animalId = id;} 
	public int getAnimalId() { return animalId; } 
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	
/*
 * 	Constructors and initialization blocks
 * 	static initialization blocks first, regular initialization blocks second 
 * 	No argument constructor third, other constructors next
 */
	static {
//		System.out.println("In Animal static initialization block");
	}
	
	{
//		System.out.println("In Animal initialization block");
		++count; 
		type = "unknow animal"; 
	}
	
	public Animal() {
//		System.out.println("In Animal no arg constructor");
	}
	
//This is overloading the constructor 
	public Animal(int a) {
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}
	
	public Animal(int a , Sex s) {
		this(a);
		setSex(s); 
	}
	
	
	
//*********************************** METHOD SECTION ***********************************
//	Override Object methods
	@Override 
	public String toString() {
		String result = getExtenedType() + " ( Age: " + age + ", Weight: " + weight + " lb )"; 
		result += ", " + sex.toString().charAt(0) + ")"; 
		return result; 
	}
	
	@Override 
	public boolean equals(Object other) {
		if(this == other) return true; 
		if(other == null) return false; 
		boolean result = false;
		System.out.println(this.getClass());
		System.out.println(other.getClass());
		if(other.getClass() == this.getClass()) {
			Animal aRef = (Animal) other;
			result = this.type.equalsIgnoreCase(aRef.type) && 
					 this.age == aRef.age && 
					 this.weight == aRef.weight && 
					 this.sex == aRef.sex && 
					 this.ecosystemType == aRef.ecosystemType; 
		}
		return result; 
	}
	
	@Override 
	public int hashCode() {
		int code = type.toLowerCase().hashCode();
		// ^= is the bitwise XOR assignment operator
		code ^= (age * 17); 
		code ^= (weight * 31); 
		code += sex.toString().hashCode(); 
		code += ecosystemType.toString().hashCode(); 
		
		return code; 
	}
	
//	Class Animal methods 
	public void eat() {
		System.out.println(type + " eating");
		
	}
	
	public void move() {
		System.out.println(type + " moving");
		
	}
	
//	public abstract void move(); 
	
	public void sleep() {
		System.out.println(type + " sleeping");	
	}
	
	public void setRandomWeightByAge() {
		setRandomWeightByAge(ADULT_FEMALE_MIN_WEIGHT , ADULT_FEMALE_MAX_WEIGHT , ADULT_MALE_MIN_WEIGHT , ADULT_MALE_MAX_WEIGHT , BIRTH_WEIGHT); 
	}
	
	protected int setRandomWeightByAge(int a) {
		int result; 
		if (a < 5) {
			result = a + 2; 
		}else {
			if(getSex() == Sex.FEMALE) {
				result = ThreadLocalRandom.current().nextInt(BIRTH_WEIGHT ,ADULT_FEMALE_MAX_WEIGHT); 
			}else {
				result = ThreadLocalRandom.current().nextInt(BIRTH_WEIGHT ,ADULT_MALE_MAX_WEIGHT); 
			}
		}
		
		return result; 	
	}
	
//	This is overloading because we using the same name and changing the argument list 
	protected void setRandomWeightByAge(int femaleMinWeight , int femaleMaxWeight , int maleMinWeight , int maleMaxWeight , int birthWeight ) {
		int adultMinWeight, adultMaxWeight; 
		
		if(this.sex == Sex.FEMALE) {
			adultMinWeight = femaleMinWeight;
			adultMaxWeight = femaleMaxWeight; 
		}else {
			adultMinWeight = maleMinWeight;
			adultMaxWeight = maleMaxWeight; 
		}
		
		if(getAge() == 0) {
			setWeight(birthWeight + ThreadLocalRandom.current().nextInt(-4,10));
		}else if (getAge() <= MATURITY) {
			double proportion = getAge() / (double) MATURITY; 
			setWeight((int)(adultMinWeight * proportion)); 
		}else {
			setWeight(ThreadLocalRandom.current().nextInt(adultMinWeight , adultMaxWeight));
		}
		
	}
	
	public void grow () {
		setAge(age + 1); 
		int oldWeight = weight; 
		setRandomWeightByAge();
		if(weight < oldWeight) {
			setWeight(oldWeight); 
		}
	}
	
	public Animal reproduce() {
		if(sex == Sex.MALE) {
			System.out.println("Male " + getExtenedType() + " looks for Female " + getExtenedType());
			return null; 
		}
		
		if(age > MATURITY) {
			return new Animal(0);
		}else {
			System.out.println("Female " + getExtenedType() + " is not old enought.");
			return null; 
		}
		
	}
	
	public String getExtenedType() {
		String t = type;
		if(this.getAge() == 0) {
			t = "baby " + type; 
		}else if(this.getAge() < MATURITY) {
			t = "juvenile " + type; 
		}else if(this.getAge() > MAX_AGE) {
			t = "dead " + type; 
		}
		return t;
	} 
	
	public void changeHealth(int x) {
		int newHealth = health + x; 
		if (newHealth > 10) {
			health = 10; 
		}else if(newHealth < -10) {
			health = -10; 
		}else {
			health = (byte)newHealth; 
		}
	}
	
	// Implement Comparable interface 
	@Override 
	public int compareTo(Animal otherAnimal) {
		int result = 0; 
		 
		result = type.compareToIgnoreCase(otherAnimal.type); 
		if(result == 0) {
			result += new Integer(age).compareTo(new Integer(otherAnimal.age));
			
			if(result == 0) {
				result += new Integer(weight).compareTo(new Integer(otherAnimal.weight));
				
				if(result == 0) {
					result += sex.compareTo(otherAnimal.sex);
				}
			}
		}
		
		return result; 
	}
}





























