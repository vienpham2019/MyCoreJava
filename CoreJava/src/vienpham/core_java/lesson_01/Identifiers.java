/*
 * Rules for identifies 
 * 	1. Must start with a letter, dollar sign or underscore 
 * 	2. May contain letters, numbers, underscores and currency characters
 * 	3. No limit to length 
 * 	4. Can't use a Java keyword
 * 	5. Identifiers are case sensitive
 */



package vienpham.core_java.lesson_01;

public class Identifiers {
	public void inClassWork ( ) {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		stringConcatenation(); 
		caseStudies();
		otherUsefulStringMethods(); 
		System.out.println();
	}
	
	private void stringConcatenation() {
		System.out.println("1.String concatenation");
		String y = "Sail";
		System.out.println(" y = " + y);
	}
	
	private void caseStudies() {
		System.out.println("2. Case studies");
		
		String hobbit = "Bilbo Baggins"; 
		System.out.println("Original String = " + hobbit);
		System.out.println("upper case = " + hobbit.toUpperCase());
		System.out.println("lower case = " + hobbit.toLowerCase());
		
		String hobbit2 = "bilbo baggins"; 
		System.out.println("Using == " + hobbit == hobbit2);
		System.out.println("Using equals() " + hobbit.equals(hobbit2));
		System.out.println("Using equalsIgnoreCase() " + hobbit.equalsIgnoreCase(hobbit2));

	}
	
	private void otherUsefulStringMethods () {
		String s = "Contentments!";
		String s2 = ""; 
		int startIndex = 3; 
		int endIndex = 7; 
		System.out.println("isEmpty() " + s.isEmpty());
		System.out.println("isEmpty() " + s2.isEmpty());
		System.out.println("contains() " + s.contains("tent"));
		System.out.println("endsWith() " + s.endsWith("!"));
		System.out.println("length() " + s.length());
		System.out.println("substring() " + s.substring(startIndex , endIndex));
	}
}
