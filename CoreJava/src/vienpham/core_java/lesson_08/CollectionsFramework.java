package vienpham.core_java.lesson_08;

import java.util.*;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.domestic.*;

/*
 * * The collections framework was added in Java 1.2
 * Interfaces:
 *		Collection
 *		List extends Collection
 *		Set extends Collection
 *		Queue extends Collection
 *		Deque extends Queue
 *		Map
 *		Comparable
 *		Comparator
 *		Iterator
 * Utility classes:
 *		Arrays
 *		Collections
 * Ordered means you can iterate through a collection in a predictable way
 */

public class CollectionsFramework {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
		collectionsOverview();
		System.out.println("===================================================================\n");
		
		usingComparaple();
		System.out.println("===================================================================\n");
	}

	private void collectionsOverview() {
		System.out.println("1. Collections overview \n");
		
		System.out.println("1a. Lists are orderd by index \n");
		
		System.out.println("ArrayList: fast iteration and fast random access, slow insertion and removal");  
		
		List<String> aList = new ArrayList<>(); 
		aList.add("France");
		aList.add("Thailand");
		aList.add(0,"Nigeria");
		System.out.println(aList);
		Collections.sort(aList);
		System.out.println(aList);
		
		// Vector is synchronized ( for multithreading ) but slower than ArrayList 
		
		System.out.println("\nLinkedList good for adding elements at the ends.");
		System.out.println("Slower random access, faster insertion and removal at the end"); 
		
		List<String> bList = new LinkedList<>(); 
		bList.add("France");
		bList.add("Thailand");
		bList.add(0,"Nigeria");
		System.out.println(bList);
		Collections.sort(bList);
		System.out.println(bList);
		
		System.out.println("\n1b. Sets are collections of unique things, unordered");
		System.out.println("HashSet fast access, provide no ordering");
		
		Set<String> aSet = new HashSet<>(); 
		aSet.add("Jamaica");
		aSet.add("Cananda");
		aSet.add("Japan");
		System.out.println(aSet);
		
		System.out.println("\nLinkedHashSet not as fast, iterates on insertion order");
		
		Set<String> bSet = new LinkedHashSet<>(); 
		bSet.add("Jamaica");
		bSet.add("Cananda");
		bSet.add("Japan");
		System.out.println(bSet);
		
		System.out.println("\nTreeSet no duplicates, order on insertion using Comparable");
		
		Set<String> cSet = new TreeSet<>(); 
		cSet.add("Jamaica");
		cSet.add("Cananda");
		cSet.add("Japan");
		System.out.println(cSet);
		
		System.out.println("\n1c. Maps are collections of key-value pairs, keys are unique");
		System.out.println("HashMap are fast for updates, allows one nulls key, many null values");
		Map<Integer , String> aMap = new HashMap<>();  
		aMap.put(2,"Brazil");
		aMap.put(1,"Singapore");
		aMap.put(7,"Singapore");
		System.out.println(aMap);
		
		System.out.println("\nLinkedHashMap faster iteration by key insertion or last accessed");
		Map<Integer , String> bMap = new LinkedHashMap<>(); 
		bMap.put(2,"Brazil");
		bMap.put(7,"Singapore");
		bMap.put(1,"Singapore");
		System.out.println(bMap);
		
		System.out.println("\nTreeMap have keys are sorted on insertion");
		Map<Integer , String> cMap = new TreeMap<>(); 
		cMap.put(2,"Brazil");
		cMap.put(7,"Singapore");
		cMap.put(1,"Singapore");
		System.out.println(cMap);
		
		System.out.println("\nPriorityQueue: a to-do list ordered by user defined priority");
		Queue<String> aQueue = new PriorityQueue();
		aQueue.offer("India");
		aQueue.add("Saudi Arbia");
		aQueue.offer("Poland");
		aQueue.add("Chile");
		System.out.println(aQueue);
	}
	
	private void usingComparaple() {
		System.out.println("2. Using comparable to sort");
		
		List<Animal> animals = (List<Animal>) new RandomAnimalBuilder(Dog.class).build(5); 
		
		for(Animal a : animals) {
			System.out.println(a);
		}
		
		Collections.sort(animals);
		System.out.println();
		
		for(Animal a : animals) {
			System.out.println(a);
		}
	}
}








