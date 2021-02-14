package vienpham.core_java.common.ecosystem;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.mammal.*;
import vienpham.core_java.lesson_09.dao.*;

public class Savannah extends Ecosystem {
	
//  Variables  section
//	List<Lion> lionPride = (List<Lion>) new RandomAnimalBuilder(Lion.class).build(6); 
	List<Lion> lionPride = new ArrayList<>(); 
	List<Cheetah> cheetahPride = (List<Cheetah>) new RandomAnimalBuilder(Cheetah.class).build(2);
	
	List<Gazelle> gazellePride = (List<Gazelle>) new RandomAnimalBuilder(Gazelle.class).build(20);

	
	public Savannah() {
		setEcosystem(EcosystemType.SAVANNAH); 
//		useFileDAO(); 
	}
	
/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
	public void listPopulation () {
		System.out.println(lionPride);
		System.out.println("cheetahPride");
		System.out.println("gazellePride");
	}

//	TODO: Create a simulation of a pride lions hunting 
	 
	private class HuntingThread implements Runnable{
		Carnivore hunter = null; 
		List<? extends Animal> hunted = null; 
		
		HuntingThread(Carnivore c , List<? extends Animal> targets){
			hunter = c; 
			hunted = targets; 
		}
		
		@Override 
		public void run() {
			hunter.hunt(hunted); 
		}
	}
	
//	TODO: Create a simulation of a cheetah hunting gazelles
	public void thecheetahsAreHungry() {
		Cheetah cub = new Cheetah(); 
		Cheetah mother = new Cheetah(6); 
		
		mother.move(); 
		cub.move(); 
		
		Thread t = new Thread(new HuntingThread(mother , gazellePride)); 
		t.start();
		System.out.println();
		
		for(Gazelle g : gazellePride) {
			g.setRunning(true);
			g.move(); 
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String food = mother.getPreyCaugth();
		if(food != null) {
			System.out.println("cub eat");
			cub.eat(food);
		}else {
			cub.eat(); 
		}
	}
	
//	TODO: Create a simulation of cheetahs finding a herd of larger animals to rample tall grass so thery can eat short grass 
	
//	TODO: A second cheetah is nearby, what happens? 
	
	private void useFileDAO() {
		DaoFactory factory = new AnimalDaoFactory(); 
		AnimalDAO dao = null; 
		
		try {
			dao = factory.getDao("files");
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return; 
		} 
		
		dao.setDebug(false);
		
//		for(Animal lion : lionPride) {
//			dao.create(lion);
//		}
		
		// Retrieve the lions from the dao: 
		
		for(Animal lion : dao.findAll()) {
			lionPride.add((Lion)lion); 
		}
		
		
		System.out.println("--------------------------------------------------------------\n");
		
	}

	@Override
	public void findNearbyAnimals() {
		for(int i = 1 ; i < 4 ; i ++) {
			int probability = ThreadLocalRandom.current().nextInt(1,3); 
			
			switch(probability) {
			case 1 : 
				nearbyAnimals.addAll(cheetahPride); 
				break; 
			case 2: 
				nearbyAnimals.addAll(lionPride); 
				break; 
			default: 
				nearbyAnimals.addAll(gazellePride); 
				break; 
			}
		}
	}
}



