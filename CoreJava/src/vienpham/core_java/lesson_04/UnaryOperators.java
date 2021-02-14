/*
 * Unary operators operate on a single operand
 * Prefix operators: ++x, --x      // Change the value before being used
 * Postfix operators: x++, x--     // Change the value after being used
 * Increment operators: ++x, x++   // Increase the value by 1
 * Decrement operators: --x, x--   // Decrease the value by 1
 *
 * +	Unary plus operator; indicates positive value (numbers are positive without this, however)
 * -	Unary minus operator; negates an expression
 * !	Logical complement operator; inverts the value of a boolean
 * ~    Bitwise complement
 *
 * Unary operators have the highest precedence
 */

package vienpham.core_java.lesson_04;

public class UnaryOperators {
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
		testUnaryOperators(); 
		
		System.out.println("================================================================================================================\n\n");
	}

	private void testUnaryOperators() {
		System.out.println("Increment prefix operator: ++x");
		int x = 10; 
		System.out.println(++x);
		
		System.out.println("Increment postfix operator: x++");
		x = 10; 
		System.out.println(x++);
		System.out.println(x);
		
		System.out.println("Decrement prefix operator: --x");
		x = 10; 
		System.out.println(--x);
		
		
		System.out.println("Decrement postfix operator: x--");
		x = 10; 
		System.out.println(x--);
		System.out.println(x);
		
		
		x = 10;
		int y = x++ * ++x;
//		int y = 10 * 12; 
		System.out.println("y = " + y + ", x = " + x);
		x = 2;
		y = x++ * x++ * x++;
//		y = 2   * 3   * 4; 
		System.out.println("y = " + y + ", x = " + x);
		x = 2;
		y = ++x * ++x * ++x;
//		y = 3   *  4  *  5
		System.out.println("y = " + y + ", x = " + x);
	}

}
