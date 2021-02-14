/*
 * ArrayList class is part of the collection API. They are:
 * 1. dynamic and can grow and shrink as needed
 * 2. implement the List interface
 * 3. uses a zero based index to maintain order
 * 4. not sized when first created
 * 5. can have duplicate values
 *
 * Some ArrayList methods:
 *     add(element) - Adds an element to the END of the ArrayList
 *     add(index, element) - Add an element at the index location shifting other elements
 *     clear() - removes all the elements of an ArrayList
 *     contains(element) - returns whether or not an ArrayList contains that element
 *     get(index) - Returns the element at the specified index in the list. Does not remove it.
 *     indexOf(Object) - returns the index location of the object or -1 if not found
 *     iterator() - returns an iterator
 *     remove(index) - removes the element at that index shifts later elements down
 *     remove(object) - removes the first occurrence of the object if it exists
 *     set(index, object) - replaces the existing element t the specified index
 *     size() - returns the number of elements in the ArrayList
 */

package vienpham.core_java.lesson_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.domestic.*;

public class UsingArraylists {
	
	List<String> cityList = new ArrayList<>();
	List<Dog> dogList; 
	
	public void inClassWork() {
		System.out.println(this.getClass() + ".inClassWork():\n");
		
//		creatingArrayLists(); 
//		compareArrayToArrayList();
//		
//		convertingListToArray(); 
//		
//		usingAnIterator(); 
		
		convertingArrayToList(); 
		
		System.out.println("===================================================================\n\n");
	}

	private void creatingArrayLists() {
		System.out.println("1. creating array list.\n");
		
//		Java 5 & Java 6 
		List<String> lists2 = new ArrayList<String>(); 
		
//		Java 7 
		List<String> list3  = new ArrayList<>();  // the dimon is using the declare data type
		list3.add("first element"); 
		list3.add("second element"); 
		System.out.println(list3);
		
//		Constructor to create a list using another list 
		List<String> list4 = new ArrayList<>(list3); 
		list4.add("third element"); 
		System.out.println(list4);
		
		
	}
	
	private void compareArrayToArrayList() {
		String[] cityArray = new String[3]; 
		List<String> cityList = new ArrayList<>();
		
		cityArray[0] = "Oslo";
		cityArray[1] = "Paris"; 
		cityArray[2] = "Rome"; 
		
		cityList.add("Oslo");
		cityList.add("Paris");
		cityList.add("Rome");
		
		System.out.println("Size of array is: " + cityArray.length);
		System.out.println("Size of list is: " + cityList.size());
		
//		Say we want add an element between Oslo and Paris 
		String[] a1 = new String[4]; 
		a1[0] = cityArray[0];
		a1[1] = "London";  
		a1[2] = cityArray[1]; 
		a1[3] = cityArray[2]; 
		
		cityArray = a1; 
		
		cityList.add(1, "London"); 
		
		for(String city : cityArray) {
			System.out.println(city);
		}
		System.out.println("List: " + cityList);
	
		
 	}
	
	public void usingAnIterator() {
		System.out.println("3. using an iterator");
		
//		before java 5 we had to use an iterator 
		Iterator it = cityList.iterator();
		while(it.hasNext()) {
			Dog d = (Dog)it.next(); 
			System.out.println(d);
		}
			
	}
		
	public void convertingListToArray() {
		dogList = (List<Dog>) new RandomAnimalBuilder(Dog.class).build(5); 
		
		Dog[] dogArray = new Dog[dogList.size()]; 
		
		dogArray = dogList.toArray(dogArray); 
		
		System.out.println("dogArray: " + Arrays.toString(dogArray) );
	}
	
	private void convertingArrayToList() {
		String[] sa = {"hobbit" , "wizard" , "elf" , "dwarf"};
		
		List<String> listFromArray = Arrays.asList(sa); 
		System.out.println(listFromArray);
	}
	
	
}

















