/*
 * The basic for loop:
 *   The declaration has three parts:
 *     1. initialization sets up the loop control variable:     int i = 0
 *     2. conditional test determines when loop terminates:     i < 4
 *     3. iterator increments the loop control variable:        i++
 *   A fourth part is the body of the for loop
 *
 * Enhanced for loop introduced in Java 5:
 *   Designed for ease of use with arrays and collections
 *   Two parts to setting up the enhanced for loop:
 *     1. declaration - a block variable of the same type as the array element
 *     2. expression - the array itself
 *
 * If you do not use curly braces, the loop body consists of just one statement
 *
 */

package vienpham.core_java.lesson_05;

import vienpham.core_java.common.animal.mammal.Lion;

public class ForLoops {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
		testBasicForloop();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void testBasicForloop() {
		System.out.println("1. Basic old tyle for loop:");
		for(int i = 0 ; i < 4 ; i ++) {
			System.out.println("i = " + i + " , " );
		}
		System.out.println();
//		Student exercise: change i < 4 to i > 4 what happens 
//		Loop will only execute when the conditional expression returns true
		
		System.out.println("1a. Options for loop control");
//		The iteration expression can be anything
		for(int j = 10 ; j > 4 ; j --) {
			System.out.println("j = " + j + " , " );
		}
		System.out.println();
		
		System.out.println("1b. The loop control variable can be anything");
		for(double j = 100 ; j > 4 ; j /= 2) {
			System.out.println("j = " + j + " , " );
		}
		System.out.println();
		
		System.out.println("1c. Loop expression can literally be anythig");
		for(Lion a = new Lion(); a.getAge() < 5 ; a.grow()) {
			System.out.println(a);
			a.move();
		}
		System.out.println("\n");
		
		System.out.println("1d. All declaration parts are optional");
		int count = 0; 
		for(;count < 6;) {
			System.out.println("count = " + count++);
		}
		System.out.println("\n");
		
		
		System.out.println("1e. Declaring the loop control variable the loop");
		int k = 1; 
		for(; k <= 3; k ++) {
			System.out.println("k = " + k );
		}
		
		System.out.println("k outside for loop = " + k);
		
		System.out.println("1f. Multiple variables in loop expression");
		
		for(int i = 1 , j = 2; i <= 16 && j <= 10000 ; i ++ , j*= 2) {
			System.out.println("2 to the i = " + i + " , j = " + j);
		}
	}

}







