/*
 * DAO design pattern implementation classes should NOT be public. 
 * We hide the implementation details from the user
 */
package vienpham.core_java.lesson_09.dao;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import vienpham.core_java.common.animal.*;

class FileAnimalDAO implements AnimalDAO {
	
	private boolean debug = false; 
	private static final Path daoDir = Paths.get("/Users" , "vienpham" , "my-eclipse-workspace" , "Animal Files"); 
	
	public FileAnimalDAO() {
		if(Files.notExists(daoDir)) {
			System.out.println("Could not find " + daoDir.toString());
		}else if (!Files.isDirectory(daoDir)) {
			System.out.println(daoDir.toString() + " is not a valid directory");
		}else {
			System.out.println("Using directory " + daoDir);
		}
	}
	
	@Override
	public void setDebug(boolean in) {
		debug = in; 
	}

	@Override
	public void create(Animal a) {
		// Create a filename based on the animl's type, age, weight and sex
		String filename = a.getExtenedType() + "_a" + a.getAge() + "_w" + a.getWeight();
		filename += a.getSex().toString().charAt(0) + ".data"; 
		
		Path pathName = Paths.get(daoDir.toString() , filename); // create the path name using the daoDir and file name 
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathName.toFile()))){ // create the new file using path name 
			if(debug) System.out.println("Saving " + a + " to file " + pathName.toString());
			oos.writeObject(a);
			oos.flush(); // because the method is running must faster than a disk so flush make the method wait for the disk finish write and close it 
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	@Override
	public Animal find(String type, int age, int weight, Sex sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Animal> findAll() {
		File directory = new File(daoDir.toString()); 
		List<Animal> animalList = new ArrayList<>(); 
		for(String fileName : directory.list()) {
			if(fileName.equals(".DS_Store")) continue; 
			Path pathName = Paths.get(directory.toString() , fileName); 
			Animal a = getAnimalFile(pathName.toString()); 
			if(a != null) animalList.add(a); 
		}
		return animalList;
	}

	@Override
	public boolean update(Animal a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Animal a) {
		File directory = new File(daoDir.toString()); 
		System.out.println(a + "out side for loop");
		for(String fileName : directory.list()) {
			if(fileName.equals(".DS_Store")) continue; 
			Path pathName = Paths.get(directory.toString() , fileName); 
			Animal animalFile = getAnimalFile(pathName.toString()); 
			System.out.println(animalFile.getClass() == a.getClass());
			if(animalFile != null && animalFile.equals(a)) {
				System.out.println("delete");
				File fileToDelete = new File(pathName.toString());
				fileToDelete.delete();
				return; 
			}
		}
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
	
	private Animal getAnimalFile(String fileName) {
		if(debug) System.out.println("Reading file " + fileName);
		Animal result = null; 
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			result = (Animal) ois.readObject(); 
		}catch(ClassNotFoundException | IOException e) {
			System.out.println(e);
		}
		
		return result; 
	}

}














