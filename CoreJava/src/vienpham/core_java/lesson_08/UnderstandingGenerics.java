package vienpham.core_java.lesson_08;

import java.util.*;

import vienpham.core_java.common.animal.domestic.*;

/*
 * The purpose of using generics is to enforce type safety 
 */

public class UnderstandingGenerics {

	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
		genericTyping(); 
		
		System.out.println("===================================================================\n");
	}

	private void genericTyping() {
		List<String> strList = new ArrayList<>(); 
		
		strList.add("A string literal"); 
		strList.add(new Integer(42).toString()); 
		strList.add(new Dog("Shotgun").toString()); 
		strList.add(this.getClass().toString()); 
		
		for(String s : strList) {
			System.out.println(s);
		}
		
		// can't create a collection using primitives 
//		List<int> intList = new ArrayList<>(); 
		List<Integer> intList = new ArrayList<>(); 
		
		// These examples use auto-boxing 
		intList.add(46); 
		intList.add(12); 
		intList.add(345); 
		// can't add a list of Strings to a list of Integers
//		intList.addAll(strList); 
		
		System.out.println(intList.get(0).getClass());
	}

}
