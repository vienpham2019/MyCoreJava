/*
 * break - causes the program to stop execution of the innermost loop
 * labeled break - causes the program to stop execution of the labeled for loop
 * continue - causes the program to skip to the next iteration of the loop
 * labeled continue - causes the program to skip to the next iteration of the labeled loop
 */

package vienpham.core_java.lesson_05;

import javax.print.attribute.SetOfIntegerSyntax;

public class BreakAndContinue {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
	
//		breakingInfiniteLoops();
//		unlabeledBreakAndContinue();
		labeledBreakAndContinue();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void breakingInfiniteLoops() {
		System.out.println("1a. Break in infinite while loop");
		
		int count = 0; 
		while(true) {
			System.out.println(count++);
			if(count > 5) break; 
		}
		
		System.out.println("Break out the loop");
		
		System.out.println("1b. Break in infinite for loop");
		for( ; ; ) {
			System.out.println(count ++);
			if (count > 7) break ; 
			System.out.println("Run next iteration of for loop");
		}
		System.out.println("Outside for loop");
		System.out.println();
	}
	
	private void unlabeledBreakAndContinue() {
		System.out.println("2a. Unlabeled break operates on innermost loop");
		
		for(int i = 0 ; i < 3 ; i ++) {
			System.out.print("i = " + i + ":\t");
			for(int j = 0 ; j < 5 ; j ++) {
				// Add a break statement here 
				if(j == 2) {
					System.out.print("break hit");
					break; 
				}
				System.out.print("j= " + j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
		
		System.out.println("2b. Unlabeled continue operates on innermost loop");
		
		for(int i = 0 ; i < 3 ; i ++) {
			System.out.print("i = " + i + ":\t");
			for(int j = 0 ; j < 5 ; j ++) {
				// Add a break statement here 
				if(j == 2) {
					System.out.print("continue hit");
					continue; 
				}
				System.out.print("j= " + j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
	}
	
	
	private void labeledBreakAndContinue() {
		System.out.println("3a. Labeled break operates on outermost loop");
		
		breakTest:
		for(int i = 0 ; i < 3 ; i ++) {
			System.out.print("i = " + i + ":\t");
			for(int j = 0 ; j < 5 ; j ++) {
				// Add a break statement here 
				if(j == 2) {
					System.out.print("break hit");
					break breakTest; 
				}
				System.out.print("j= " + j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
		
		System.out.println("3b. Labeled continue operates on outermost loop");
		
		
		continueTest:
		for(int i = 0 ; i < 3 ; i ++) {
			System.out.print("i = " + i + ":\t");
			for(int j = 0 ; j < 5 ; j ++) {
				// Add a break statement here 
				if(j == 2) {
					System.out.print("continue hit");
					continue continueTest ; 
				}
				System.out.print("j= " + j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
	}
	
	

}





