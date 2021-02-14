package vienpham.core_java.lesson_09;

import java.util.*;

import vienpham.core_java.common.Light;
import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.ecosystem.EcosystemType;

public class BuilderPattern {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
		// Not using builder setter 
		List<Animal> animals = (List<Animal>) new RandomAnimalBuilder(AnimalType.MAMMAL).build(10); 
		System.out.println("Displaying list of animals with out filtering");
		displayResult(animals);		
		System.out.println("===================================================================\n");
		
		animals = (List<Animal>) new RandomAnimalBuilder(AnimalType.MAMMAL)
													.setDebug(true)
													.setEcosystem(EcosystemType.BATHIC_OCEAN)
													.build(10); 
		
		System.out.println("Displaying list of animals with filtering for SAVANNAH");
		displayResult(animals);		
		System.out.println("===================================================================\n");
	}

	private void displayResult(List<Animal> animals) {
		System.out.println(animals);
		for(Animal a : animals) {
			System.out.println(a);
		}
	}
}
