package vienpham.core_java.common.animal;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.domestic.*;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;
import vienpham.core_java.common.animal.reptile.*;
import vienpham.core_java.common.ecosystem.*;

public class RandomAnimalBuilder {
//*********************************** VARIABLES SECTION ***********************************

	private AnimalType type = null; 
	
	private Class species = null; 
	
	// Variables for file handling 
	private Path parentDir = Paths.get("src" , "vienpham", "core_java", "common", "animal"); 
	private String parentPkg = "vienpham.core_java.common.animal"; 
	private boolean debug = false; 
	
	private EcosystemType ecoSystem = null;  
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	public RandomAnimalBuilder() {}
	
//	use this constructor to build random animal of a specific type
	public RandomAnimalBuilder(AnimalType t) {
		type = t; 
	}
//  use this constructor to build random animals of specific type 
	public RandomAnimalBuilder(Class cl) {
		species = cl; 
	}
	
//*********************************** METHOD SECTION ***********************************
	// Builder design pattern used to set non mandatory parameters 
	// Method that set various parameter instead of creating multiple constructors 
	public RandomAnimalBuilder setEcosystem(EcosystemType ecoType) {
		ecoSystem = ecoType; 
		return this;
	}
	
	public RandomAnimalBuilder setDebug(boolean db) {
		debug = db; 
		return this; 
	}
	
	// Ends Builder Design pattern setters
	
	// The build method is also of the Builder Design Pattern 
	public List<? extends Animal> build(int count){
		List<Animal> result = new ArrayList<>(); 
		
		for(int i = 1 ; i <= count ; i ++) {
			Animal a; 
			
			if(type != null) {
				a = buildType(type); 
			
			}else if(species != null) {
				a = buildClass(); 
			}else {
				a = buildRandom();
			}
			
			if(a == null) continue ; 
//			Set the new animal to random age base on it age range 
			int age = ThreadLocalRandom.current().nextInt(0 , a.getMaxAge()); 
			a.setAge(age);
			
//			Set the new animal's sex, default is FEMALE, so set half to MALE
			if(ThreadLocalRandom.current().nextBoolean()) {
				a.setSex(Sex.MALE);
			}
			
//			Set the weight base on animals sex and age 
			a.setRandomWeightByAge(); 
			
			result.add(a); 
		
		}
		
		return result; 
	}
	
	private Animal buildRandom() {
		Animal a = null; 
		
		switch(ThreadLocalRandom.current().nextInt(6)) {
			default: 
				a = buildMammal(); 
			case 0 : 
				a = buildBird(); break; 
			case 1 : 
				a = buildFish(); break; 
			case 2 : 
				a = buildReptile(); break; 
			case 3 : 
				a = buildDemestic(); break; 
		}
			
		return a; 
	}
	
	private Animal buildType(AnimalType t) {
		Animal a = null; 
		
		switch(t) {
			default: 
			case ZOO : 
				a = buildZoo(); break; 
			case MAMMAL: 
				a = buildMammal(); break; 
			case BIRD : 
				a = buildBird(); break; 
			case FISH : 
				a = buildFish(); break; 
			case REPTILE : 
				a = buildReptile(); break; 
			case DOMESTIC : 
				a = buildDemestic(); break; 
		}
			
		return a; 
	}
	
	private Animal buildClass() {
		Animal newAnimal = null ;
		
		String className = species.getCanonicalName(); // return the canonical name of the underlying class 
		
		try {
			newAnimal = (Animal) Class.forName(className).newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		
		return newAnimal; 
	}
	
	private Animal buildZoo() {
		Animal newAnimal = null; 
		
		switch(ThreadLocalRandom.current().nextInt(6)) {
		case 0: 
			newAnimal = buildBird() ; break; 
		case 1: 
			newAnimal = buildReptile() ; break; 
		default: 
			newAnimal = buildMammal(); 
		}
		
		return newAnimal; 
	}

	private List<String> mammalClasses = null; 
	private Mammal buildMammal() {
		Mammal newMammal = null ; 
		
		if(mammalClasses == null) {
			mammalClasses = getClassList("mammal"); 
		}
		if(mammalClasses.isEmpty()) {
			return null; 
		}
		int index = ThreadLocalRandom.current().nextInt(mammalClasses.size()); // get random number form 0 to mammalClasses length 
		
		String name = mammalClasses.get(index); 
		
		
		try {
			newMammal = (Mammal)Class.forName(name).newInstance(); // create new mammal with pagage name 
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
			
		return newMammal; 
	}
	
	// set string birdClasses List contain all the non abstract class
	private List<String> birdClasses = null; 
	private Bird buildBird() {
		Bird newBird = null; 
		
		// Check for birdClasses is null if equal to null set that by using getClassList("bird") 
		if(birdClasses == null) {
			birdClasses = getClassList("bird"); 
		}
		// get random index from 0 to birdClasses length 
		int index = ThreadLocalRandom.current().nextInt(birdClasses.size()); 
		// get the package name from birdClasses using random index 
		String birdPackageName = birdClasses.get(index); // EXP: vienpham.core_java.common.animal.mammal.Duck
		// try to create new bird using class name 
		try {
			newBird = (Bird)Class.forName(birdPackageName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		// return new bird 
		return newBird;
	}
	
	private List<String> fishClasses = null; 
	private Fish buildFish() {
		Fish newFish = null; 
		
		if(fishClasses == null) {
			fishClasses = getClassList("fish"); 
		}
		
		int index = ThreadLocalRandom.current().nextInt(fishClasses.size()); 
		String name = fishClasses.get(index);
		
		try {
			newFish = (Fish)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	
		
		return newFish;
	}
	
	// Reptile class list
	List<String> reptileClasses = null; 
	private Reptile buildReptile() {
		Reptile newReptile = null; 
		
		// check for reptile list for null 
		if(reptileClasses == null) {
			reptileClasses = getClassList("reptile"); 
		}
		
		// get random index
		int index = ThreadLocalRandom.current().nextInt(reptileClasses.size()); 
		// get random reptile package name using index 
		String reptileClassName = reptileClasses.get(index);
		
		// create new reptile using random reptile package name 
		
		try {
			newReptile = (Reptile)Class.forName(reptileClassName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return newReptile;
	}
	
	private Animal buildDemestic() {
		Domesticatable newAnimal = null; 
		
		switch(ThreadLocalRandom.current().nextInt(5)) {
		default: 
			
		case 0: 
			newAnimal = new Dog(); break; 
		case 1: 
			newAnimal = new Cat(); break; 
		case 2: 
			newAnimal = new Horse(); break; 
				
		}
		
		return (Animal)newAnimal; 
	}
	
	private List<String> getClassList(String subDir){ 
		Path dir = Paths.get(parentDir.toString() , subDir); // This will get the path directory file and add the subDir value in to a string 
		List<String> classes = new CopyOnWriteArrayList<>(); 
		String pkg = parentPkg + "." + subDir ; // This is concat the parent page directory to a subDir
		
		if(debug) {
			System.out.println(dir);
			System.out.println(pkg);
		}
		
		File entry = dir.toFile();  
		if(entry.isDirectory()) {
			String[] entryNames = entry.list(); // get all the class directory in side a dir
			for(String fileName : entryNames) {
//				System.out.println(fileName); // Class file name 
				
				String clsName = pkg + "." + fileName.substring(0 , fileName.indexOf(".")); // concat the page name to class name 
//				if (debug) System.out.println("Found: " + clsName);
				classes.add(clsName);
			}
		}
		
		// Loop through the list and attempt to instantiate the class 
		for(String clsName : classes) {
			Animal a = null; 
			
			try {
				a = (Animal)Class.forName(clsName).newInstance(); 
				if(ecoSystem != null && (ecoSystem != EcosystemType.UNKNOWN || ecoSystem != EcosystemType.VARIOUS)) {
					if(a.getEcosystem() != ecoSystem) {
						if(debug) System.out.println("Remove ecosystem " + a.getEcosystem() + " form class list");
						classes.remove(clsName);
					}
				}
			} catch (ClassNotFoundException | IllegalAccessException e){
//				e.printStackTrace();
				System.out.println(e + ": " + e.getCause());
				System.exit(1); 
			} catch(InstantiationException ie) {
				// Remove abstract classes or interfaces
				if(debug) System.out.println("Removing " + clsName + " from class list"); 
				classes.remove(clsName); 
			}
		}
		
		return classes; 
	}
	
	public void testGetClassList (String subDir) {
		debug = true; 
		List<String> classes = getClassList(subDir);
		
		for(String s : classes) {
			System.out.println(s);
		}
		debug = false; 
	}
	
	
	
}






