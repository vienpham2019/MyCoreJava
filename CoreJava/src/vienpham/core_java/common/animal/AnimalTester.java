package vienpham.core_java.common.animal;

import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;

import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;
import vienpham.core_java.common.animal.reptile.*;

public class AnimalTester {
	public static AnimalTester at = new AnimalTester();
	
	static private Path parentDir = Paths.get("src" , "vienpham", "core_java", "common", "animal"); 
	private String parentPkg = "vienpham.core_java.common.animal"; 

	public static void main(String[] args) {
		
//		at.testRandomAnimalBuilder();
//		at.testAnimalTypes(AnimalType.MAMMAL, 20);
//		at.testSpecificAnimal();
		at.checkAnimalClasses(AnimalType.MAMMAL); 
//		at.checkAnimalFile(Paths.get(parentDir.toString() , "mammal" , "Bear.java")); 
	}

	private void testSpecificAnimal() {
		List<Gazelle> herd = (List<Gazelle>) new RandomAnimalBuilder(Gazelle.class).build(20); 
		for(Gazelle a : herd) {
			System.out.println(a);
			a.eat();
		}
	}
	
	private void testRandomAnimalBuilder() {
		System.out.println("1. Test RandomAnimalBuilder:");
		List<Animal> animals = (List<Animal>)new RandomAnimalBuilder().build(6);
		for (Animal a : animals) {
			System.out.println(a);
//			a.eat();
//			a.move();
//			a.sleep();
			System.out.println();
		}
		System.out.println();
	}

	private void testAnimalTypes(AnimalType typeToTest, int numToTest) {
		System.out.println("2. Overloaded RandomAnimalBuilder");
		List<? extends Animal> displayResults;
		switch (typeToTest) {
		case FISH:
			List<Fish> fishes = (List<Fish>) new RandomAnimalBuilder(AnimalType.FISH).build(numToTest);
			displayResults = fishes;
			break;
		case BIRD:
			List<Bird> birds = (List<Bird>) new RandomAnimalBuilder(AnimalType.BIRD).build(numToTest);
			displayResults = birds;
			break;
		case MAMMAL:
			List<Mammal> mammals = (List<Mammal>) new RandomAnimalBuilder(AnimalType.MAMMAL).build(numToTest);
			displayResults = mammals;
			break;
		case REPTILE:
			List<Reptile> lizards = (List<Reptile>) new RandomAnimalBuilder(AnimalType.REPTILE).build(numToTest);
			displayResults = lizards;
			break;
		case DOMESTIC:
			List<Animal> domestics = (List<Animal>) new RandomAnimalBuilder(AnimalType.DOMESTIC).build(numToTest);
			displayResults = domestics;
			break;
		case ZOO:
		default:
			List<Animal> animals = (List<Animal>)new RandomAnimalBuilder(AnimalType.ZOO).build(6);
			displayResults = animals;
			break;
		}

		for(Animal a : displayResults) {
			System.out.println(a);
		}
		System.out.println();
	}
	

	private void checkAnimalFile(Path targetFile) {
		String data = null;
		try (BufferedReader br = Files.newBufferedReader(targetFile)) {
		boolean eatMethodFound=false, sleepMethodFound=false, moveMethodFound=false;
			while((data = br.readLine()) != null) {
				if (data.contains("public void eat()")) eatMethodFound = true;
				if (data.contains("public void sleep()")) sleepMethodFound = true;
				if (data.contains("public void move()")) moveMethodFound = true;
			}		
				
			if (!eatMethodFound) System.out.println("You need to override the eat method");
		
			if (!sleepMethodFound) System.out.println("You need to override the sleep method");
			
			if (!moveMethodFound) System.out.println("You need to override the move method");
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
	}

	
	private void checkAnimalClasses(AnimalType type) {
		String subDir = type.toString().toLowerCase();  // EXP: "bird"
		// directory 
		Path dir = Paths.get(parentDir.toString(), subDir); // EXP: src/vienpham/core_java/common/animal/bird
		// List of all the class in that directory 
//		List<String> classNames = new ArrayList<>(); // this is the interface of ArrayList 
		// package name 
		String pageName =  parentPkg + "." + subDir; // EXP: vienpham.core_java.common.animal.bird
		
		File entryFile = dir.toFile(); // convert object form Path to File
		// check if the file is a directory or not 
		if(entryFile.isDirectory()) {
			String[] fileArray = entryFile.list(); 
			
			// Check all class to see if all that class have eat() sleep() and move() methods 
			for(String file : fileArray) {
				String fileDir = pageName + "." + file.substring(0 , file.indexOf(".")); 
				
				// check for enum , interface and abstract class 
				try{
					Class currClass = Class.forName(fileDir); 
					if(!Modifier.isAbstract(currClass.getModifiers()) && !currClass.isInterface() && !currClass.isEnum()) {
//						classNames.add(file); 
						
						System.out.println("\n_ " + file);
						checkAnimalFile(Paths.get(dir.toString() , file)); 
						System.out.println("-----------------------");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}
//		System.out.println(classNames);
	
	}

}





