/*
 * switch statements are branching statements that check for discrete values
 * 			All version of Java switch work with ints 
 * 			All of Java 5 switch works with enum 
 * 			All of Java 8 switch works with Strings
 *
 * switch statements only check for equality
 * each case branch  must be a constant
 * the default case is optional and can be placed anywhere in the switch statement
 */

package vienpham.core_java.lesson_05;

public class SwitchStatements {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
//		basicSwitchStatement(); // See switch on enum AnimalType in RandomAnimalBuilder 
//		breakAndFallThough(); 
		switchonStrings();
		
		System.out.println("================================================================================================================\n\n");
	}


	private void basicSwitchStatement() {
		System.out.println("1. Switching on ints");
		
		long x = 3;
		int total = 0; 
		
		switch((int)x) {
		case 1: 
			System.out.println("x is 1");
			total += x; 
			break; 
		case 2: 
			System.out.println("x is 2");
			total += x; 
			break; 
		case 3: 
			System.out.println("x is 3");
			total += x; 
			break; 
		default: 
			System.out.println("x is something else");
			total += x; 
			break; 
		}
		
		System.out.println("total =  " + total);
		System.out.println();
	}
	
	private void breakAndFallThough() {
		System.out.println("2. break and fall through");
		
		int x = 3;
		int total = 0; 
		
		switch(x) {
		case 1: 
			System.out.println("x is 1");
			total += x; 
			
		case 2: 
			System.out.println("x is 2");
			total += x; 
			
		case 3: 
			System.out.println("x is 3");
			total += x; 
			 
		default: 
			System.out.println("x is something else");
			total += x; 
			
		}
		
		System.out.println("total =  " + total);
		System.out.println();
	}
	
	private void switchonStrings() {
		System.out.println("3. switching on string as of Java 7.");
		
		String dow = "Tuesday"; 
		
		switch (dow.toLowerCase()) {
		case "monday": 
			System.out.println("Monday, monday, can't trust that day!");
			break; 
			
		case "tuesday":
			System.out.println("Its toco Tuesday, lets head to On The Border");
			break;
			
		case "wednesday": 
			System.out.println("It's humpday");
			break;
			
		case "thursday": 
			System.out.println("throw-back thursday");
			break;
			
		case "friday": 
			System.out.println("Its casual Friday, time for a beer!");
			break;
			
		default: 
			System.out.println("Its the weekend");
			break; 
		}

	}

}























