package vienpham.core_java.common.animal.domestic;

import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.Pet;
import vienpham.core_java.common.animal.mammal.Carnivora;

public class Cat extends Carnivora implements Pet {
	
//	Support Nameable interface 
	private String name; 
	public String getName() { return name; }
	public void setName(String n) { name = n; } 
	
//	Support Domesticatable interface 
	String breed; 
	public String getBreed() { return breed; } 
	public void setBreed(String b) { breed = b; } 
	
	
	
	public Cat() {
		setType("cat");
		MAX_AGE = 20; 
		MATURITY = 2; 
		prey.add("tree mouse");
		prey.add("kibble");
		prey.add("bird");
		prey.add("gecko");
	}
	
//	Supports Pet interface
	@Override
	public boolean hasLicense() {
		return false;
	}
	@Override
	public void beFriendly() {
		System.out.println(name + " " + getExtenedType() + " rubs against you leg!");
	}
	@Override
	public void hunt(List<? extends Animal> target) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}
	
}
