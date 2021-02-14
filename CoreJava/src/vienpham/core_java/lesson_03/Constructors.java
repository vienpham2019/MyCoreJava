package vienpham.core_java.lesson_03;

import java.util.List;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;

public class Constructors {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		testConstructorChainig(); 
		testOverloadedRandomAnimalBuilderConstructor(); 
		
		System.out.println("================================================================================================================\n\n");
	}

	private void testConstructorChainig() {
		System.out.println("1. Constructor chaining");
		
		Swordfish fish = new Swordfish(12); 
		
		System.out.println();
	}
	
	private void testOverloadedRandomAnimalBuilderConstructor() {
		System.out.println("2. Overloaded RandomAnimalBuilder");
		
		List<Fish> fishs = (List<Fish>) new RandomAnimalBuilder(AnimalType.FISH).build(3); 
		System.out.println(fishs);
		System.out.println();
		for(Fish f : fishs) {
			f.hunt(); 
			System.out.println();
		}
		System.out.println();
		
		List<Bird> birds = (List<Bird>) new RandomAnimalBuilder(AnimalType.BIRD).build(3); 
		System.out.println(birds);
		
		System.out.println();
//		
		List<Mammal> mammals = (List<Mammal>) new RandomAnimalBuilder(AnimalType.MAMMAL).build(6); 
		System.out.println(mammals);
		System.out.println();
		for(Mammal m : mammals) {
			if(m instanceof Carnivora) {
				((Carnivora) m).hunt(); 
				System.out.println();
			}
		}
		System.out.println();
		
//		Student exercies: cretea random reptiles (and at least one more reptile
		
	}
	
}
