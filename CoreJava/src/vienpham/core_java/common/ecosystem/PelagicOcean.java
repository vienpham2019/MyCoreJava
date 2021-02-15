package vienpham.core_java.common.ecosystem;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;
import vienpham.core_java.common.animal.marine_mammal.NorthernFurSeal;
import vienpham.core_java.lesson_09.dao.AnimalDAO;
import vienpham.core_java.lesson_09.dao.AnimalDaoFactory;
import vienpham.core_java.lesson_09.dao.DaoFactory;
import vienpham.core_java.lesson_09.dao.DataStoreNotFoundException;

/*
 * Oceanic Whitetip Shark , Sword Fish , YellowfinTuna , Northern Fur Seal , AtlanticBluefinTuna
 *
 */

public class PelagicOcean extends Ecosystem {
	
/* ************************ VARIABLES, GETTERS AND SETTERS SECTION ********************************
 * Variables with getters and setters
 * Static variables first, others organized by state
 */
	List<OceanicWhitetipShark> oceanicWhitetipSharkPride = new ArrayList<>(); 
	List<GreateWhiteShark> greateWhiteSharkPride = new ArrayList<>(); 
	List<Swordfish> swordfishPride = new ArrayList<>();;
	List<YellowfinTuna> yellowfinTunaPride = new ArrayList<>();
	List<NorthernFurSeal> northernFurSealPride = new ArrayList<>();
	List<AtlanticBluefinTuna> atlanticBluefinTunaPride = new ArrayList<>();


/* ********************* CONSTRUCTORS AND INITIALZATION BLOCKS SECTION ****************************
 * Constructors and initialization blocks
 * static initialization blocks first, regular initialization blocks second
 * No argument constructor third, other constructors next
 */

//	Variables section 	
	public PelagicOcean() {
		setEcosystem(EcosystemType.PELAGIC_OCEAN); 
		useFileDAO(); 
		System.out.println();
	}
	
/* ******************************* METHODS SECTION ************************************************
 * Methods other than getters and setters section
 * These should be organized by parent classes, overrides first
 */
	// Object method overrides
	// Animal method overrides
	// Mammal,  Bird, Fish or Reptile method overrides
	// Support interface
	
	
//	TODO: Simple simulation without multithreading 
	public void dawnBreaks() {
		System.out.println("Its just before dawn on the ocean");
		
		for(OceanicWhitetipShark s : oceanicWhitetipSharkPride) {
			if(s.getAge() < 4) {
				System.out.println(s + ": ");
				s.sleep(); 
			}else if(s.getSex() == Sex.MALE && s.getWeight() > 650) {
				System.out.println(s + " watch over ther fish");
			}
		}
		
		System.out.println("Mother and baby seal: ");
		for(NorthernFurSeal s : northernFurSealPride) {
			s.sleep();
		}
	}

	
//	TODO: Create a simulation of a whitetip shark hunting 
	
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
	
	public void greateWhiteSharkAreHungry() {
		GreateWhiteShark shark = new GreateWhiteShark(30); 
		
		shark.move();
		
		Thread t = new Thread(new HuntingThread(shark , nearbyAnimals)); 
		t.start();
		System.out.println();
		
//		for(YellowfinTuna tuna : yellowfinTunaPride) {
//			tuna.setFastSwimming(true);
//			tuna.move(); 
//		}
//		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		String food = shark.getPreyCaugth();
		
	}
	
	
	public void listPopulation () {
		System.out.println("oceanicWhitetipSharkPride " + oceanicWhitetipSharkPride.size());
		for(OceanicWhitetipShark s : oceanicWhitetipSharkPride ) System.out.println(s);
		
		System.out.println("\nswordfishPride " + swordfishPride.size());
		for(Swordfish s : swordfishPride ) System.out.println(s);
		
		System.out.println("\nyellowfinTunaPride " + yellowfinTunaPride.size());
		for(YellowfinTuna s : yellowfinTunaPride ) System.out.println(s);
		
		System.out.println("\nnorthernFurSealPride " + northernFurSealPride.size());
		for(NorthernFurSeal s : northernFurSealPride ) System.out.println(s);
		
		System.out.println("\natlanticBluefinTunaPride " + atlanticBluefinTunaPride.size());
		for(AtlanticBluefinTuna t : atlanticBluefinTunaPride ) System.out.println(t);
	}
	
	private void useFileDAO() {
		DaoFactory factory = new AnimalDaoFactory(); 
		AnimalDAO dao = null; 
		
		try {
			dao = factory.getDao("files");
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return; 
		} 
		
		for(Animal a : dao.findAll()) {
			if(a instanceof OceanicWhitetipShark) oceanicWhitetipSharkPride.add((OceanicWhitetipShark)a); 
			
			else if(a instanceof Swordfish) swordfishPride.add((Swordfish)a); 
			
			else if(a instanceof YellowfinTuna) yellowfinTunaPride.add((YellowfinTuna) a); 
			
			else if(a instanceof NorthernFurSeal) northernFurSealPride.add((NorthernFurSeal)a); 
			
			else if(a instanceof AtlanticBluefinTuna) atlanticBluefinTunaPride.add((AtlanticBluefinTuna)a); 
			
		}
		
	}

	@Override
	public void findNearbyAnimals() {
		int[] alreadyAdded = new int[3]; 
		for(int i = 0; i < 3 ; i ++) {
			int probability = ThreadLocalRandom.current().nextInt(1,5); 
			if(Arrays.binarySearch(alreadyAdded , 0 , 2 , probability) >= 0) {
				i --; 
				continue; 
			}
			switch(probability) {
			case 1: 
				nearbyAnimals.addAll(oceanicWhitetipSharkPride); break; 
			case 2:  
				nearbyAnimals.addAll(swordfishPride); break; 
			case 3: 
				nearbyAnimals.addAll(yellowfinTunaPride); break; 
			case 4: 
				nearbyAnimals.addAll(northernFurSealPride); break; 
			default: 
				nearbyAnimals.addAll(atlanticBluefinTunaPride); break; 
			}
			alreadyAdded[i] = probability; 
		}
	}

}
