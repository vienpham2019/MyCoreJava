package vienpham.core_java.common;

public class Light {
	public static int count = 0;
	
	// We need a static reference variable to hold the address of the one and only singleton 
	// This creates a 'lazy singleton' which not instantiate the object until needed. 
	private static volatile Light lightInstance = null; 
	// This create an 'eager singleton'  
//	 private static volatile Light lightInstance = new Light(); 
	
	// We need private constructor so the compiler will not add default constructor 
	// This will prevent users from using the 'new' keyword to instantiate an object 
	private Light() {
		count ++; 
	}
	
	// it need to be static because can use it with out create an object 
	// We need a static method to retrieve the single instance of this class 
	// It needs to be synchroized to prevent more than one thread from accessing it 
	// at any diven time.
	public static synchronized Light getLightInstance() {
		// This testnot needed for eager singleton 
		if(lightInstance == null) {
			lightInstance = new Light(); 
		}
		return lightInstance; 
	}
	
}
