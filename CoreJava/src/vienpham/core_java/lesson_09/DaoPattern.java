package vienpham.core_java.lesson_09;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;
import vienpham.core_java.lesson_09.dao.*;

public class DaoPattern {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
//		useMemoryDAO();
		useFileDAO(); 
//		useRdbmsDAO(); 
//		transferFilesToMySqlDb(); 
		
		System.out.println("===================================================================\n");
	}

	private void useMemoryDAO() {
		//MemoryCacheAnimalDAO is package level access and it not visible
//		AnimalDAO dao = new MemoryCacheAnimalDAO();
		
		DaoFactory factory = new AnimalDaoFactory(); 
		AnimalDAO dao = null; 
		
		try {
			dao = factory.getDao("memory");
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return; 
		}
		
		// Create a list of animals to use the dao: 
		List<Animal> lionPride = (List<Animal>) new RandomAnimalBuilder(Lion.class).build(7);  
		dao.setDebug(true);
		for(Animal lion : lionPride) {
			dao.create(lion);
		}
		
		System.out.println("--------------------------------------------------------------\n");
		
		// Retrieve the lions from the dao: 
		for(Animal lion : dao.findAll()) {
			System.out.println(lion);
		}
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
		
		// Create a list of animals to use the dao: 
		
////		Whitetip Shark 
//		List<Animal> whitetipSharkPride = (List<Animal>) new RandomAnimalBuilder(OceanicWhitetipShark.class).build(5);  
//		int babySharkNum = ThreadLocalRandom.current().nextInt(2,5); 
//		for(int i = 0 ; i < babySharkNum ; i ++) {
//			whitetipSharkPride.add((Animal) new OceanicWhitetipShark()); 
//		}
//		
//		for(Animal shark : whitetipSharkPride) {
//			dao.create(shark);
//		}
//		
//		
////		Swordfish
//		List<Animal> swordfishPride = (List<Animal>) new RandomAnimalBuilder(Swordfish.class).build(15); 
//		int babySwordFishNum = ThreadLocalRandom.current().nextInt(5 , 10); 
//		for(int i = 0 ; i < babySwordFishNum ; i ++) { 
//			swordfishPride.add((Animal) new Swordfish()); 
//		}
//		
//		for(Animal a : swordfishPride) {
//			dao.create(a);
//		}
//		
////		YellowfinTuna
//		List<Animal> yellowfinTunaPride = (List<Animal>) new RandomAnimalBuilder(YellowfinTuna.class).build(20); 
//		int tunaBabyNum = ThreadLocalRandom.current().nextInt(10 , 20); 
//		for(int i = 0 ; i < tunaBabyNum ; i ++) {
//			yellowfinTunaPride.add((Animal) new YellowfinTuna()); 
//		}
//		
//		for(Animal a : yellowfinTunaPride) {
//			dao.create(a);
//		}
//		
////		NorthernFurSeal
//		List<Animal> northernFurSealPride = (List<Animal>) new RandomAnimalBuilder(NorthernFurSeal.class).build(10); 
//		int tunaBabyNum1 = ThreadLocalRandom.current().nextInt(3, 8); 
//		for(int i = 0 ; i < tunaBabyNum1 ; i ++) {
//			northernFurSealPride.add((Animal) new NorthernFurSeal()); 
//		}
//		
//		for(Animal a : northernFurSealPride) {
//			dao.create(a);
//		}
//		
////		AtlanticBluefinTuna
//		List<Animal> atlanticBluefinTunaPride = (List<Animal>) new RandomAnimalBuilder(AtlanticBluefinTuna.class).build(20); 
//		int tunaBabyNum2 = ThreadLocalRandom.current().nextInt(4, 10); 
//		for(int i = 0 ; i < tunaBabyNum2 ; i ++) {
//			atlanticBluefinTunaPride.add((Animal) new AtlanticBluefinTuna()); 
//		}
//		
//		for(Animal a : atlanticBluefinTunaPride) {
//			dao.create(a);
//		}
			
		
		
		//Delete all the files
//		for(Animal shark : dao.findAll()) {
//			dao.delete(shark);
//		}
//		
		System.out.println("--------------------------------------------------------------\n");
		
	}
	
	private void useRdbmsDAO() {
		DaoFactory factory = new AnimalDaoFactory(); 
		AnimalDAO dao = null; 
		
		try {
			dao = factory.getDao("rdbms");
			dao.setDebug(true);
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return; 
		} 
		
		
		
		dao.close();
	}
	
	private void transferFilesToMySqlDb() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO fileDao = null;
		AnimalDAO dbDao = null;
		try {
			fileDao = factory.getDao("files");
			dbDao = factory.getDao("rdbms");
			dbDao.setDebug(true);
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return;
		}
		
        Scanner sc = new Scanner(System.in);
        String answer;
  		System.out.println("In MySQL Workbench, drop the animals table and recreate it.");
		System.out.println("After recreating the table, type 'yes' and hit 'enter' to continue");
		answer = sc.nextLine();
		if (!answer.equalsIgnoreCase("yes")) {
			System.out.println("Operation aborted!");
			return;
		}
		System.out.println("Is MySQL Workbench closed? Type 'yes' and hit 'enter' to continue");
		answer = sc.nextLine();
		if (!answer.equalsIgnoreCase("yes")) {
			System.out.println("Operation aborted!");
			return;
		}
		// Retrieve the lions from the dao:
		for (Animal animal : fileDao.findAll()) {
			dbDao.create(animal);
		}
		sc.close();
		dbDao.close();
	}

}





























