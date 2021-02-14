/*
 * do and while loops require a boolean expression 
 * 
 * do loops are guaranteed to run at least on 
 * while loops may not execute at all 
 * 
 * do loops have a while expression at the end requires a semicolon
 */
package vienpham.core_java.lesson_05;

import vienpham.core_java.common.animal.mammal.*;

public class WhileDoLoop {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
//		whileAndDoLoopBasic();
		testWhileWithLion();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void whileAndDoLoopBasic() {
		System.out.println("1a. while and do loop basic");
		int count = 3; 
		while (count < 6) {
			System.out.println("count = " + count );
			count++; 
		}
		
		System.out.println("1b. Do Loop");
		count = 3; 
		do {
			System.out.println(count + " ");
			count++; 
		}while(count < 6); 
		System.out.println();
		
//		Infinite loops:
//		while(true) {}
//		do {} while(true); 
	}
	
	private void testWhileWithLion() {
		System.out.println("2. Test while loop with lion \n");
		
		Lion aLion = new Lion(); 
		
		while (aLion.getAge() < aLion.getMaxAge()) {
			aLion.hunt();
			aLion.grow(); 
			System.out.println(aLion);
			System.out.println();
		}
	}

}













