
/*
 * There are 4 level of access , but only 3 access modifies 
 * 	Variables and methods with no access modifier have package ( default ) level of access 
 * Access modifiers: 
 * 	public - anyone can see it with an import statement 
 * 	protected  - package + kids ( in same package or inherits from 
 * 	private  - visible only in the class itself 
 * 	
 * Non-access modifiers
 * 	final - can't be changed 
 * 	abstract - must be overridden ( methods ) or extended ( classes ) 
 * 	static  - can be use without instantiating an object 
 * 	
 * 	synchronized - used in multithreaded applications to prevent collisions between threads 
 * 	transient - in fileIO to ignore variables in serialization  
 * 	
 * 	volatile - used in multi-threading to reconcile data modified in multiple threads 
 * 	strictfp - forces floating point notation to use IEEE754 standard 
 * 	native - method is implemented in another language 
 */


package vienpham.core_java.lesson_01;

public class Modifiers {
	
//	Class variables use the static keyword
	static String classVar = "Class variable"; 
	private final double TEST_FINAL = 123456.789; 

	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
//		Can't change the constant: 
//		TEST_FINAL = 987.766554; 
	}
	
//	public abstract testAbstractMethod(); 
	
}
