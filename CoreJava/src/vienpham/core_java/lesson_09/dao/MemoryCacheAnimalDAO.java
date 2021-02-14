/*
 * DAO design pattern implementation classes should NOT be public. 
 * We hide the implementation details from the user
 */
package vienpham.core_java.lesson_09.dao;

import java.util.Collection;
import java.util.*;

import vienpham.core_java.common.animal.*;

class MemoryCacheAnimalDAO implements AnimalDAO {
	private static List<Animal> animalListCache = new ArrayList<>();
	private boolean debug = false; 
	
	@Override
	public void setDebug(boolean in) {
		debug = in; 
	}
	@Override
	public void create(Animal a) {
		if(debug) System.out.println("Adding " + a + " to memory cache");
		animalListCache.add(a);
	}

	@Override
	public Animal find(String type, int age, int weight, Sex sex) {
		for(Animal a : animalListCache) {
			if(a.getExtenedType().toLowerCase() == type.toLowerCase() 
					&& a.getAge() == age 
					&& a.getWeight() == weight
					&& a.getSex() == sex ) {
				return a; 
			}
		}
		return null;
	}

	@Override
	public Collection<Animal> findAll() {
		if(debug) System.out.println("Reading all animal from memory cache");
		// Bad encapsulation; 
		// return animalListCache; 
		return new ArrayList<Animal>(animalListCache);
	}

	@Override
	public boolean update(Animal a) {
		
		return false;
	}

	@Override
	public void delete(Animal a) {
		animalListCache.remove(a);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
