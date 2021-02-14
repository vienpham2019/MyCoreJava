package vienpham.core_java.lesson_09;

import vienpham.core_java.common.Light;

public class SingletonPattern {

	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
		// can't use 'new' to instantiate the singleton 
		// Light newLight = new Light(); 
		System.out.println("Before Light is loaded, Light count: " + Light.count);
		System.out.println("Calling Light.getLightInstance()");
		Light newLight = Light.getLightInstance();
		System.out.println("Light count: " + Light.count);
		
		System.out.println("Calling Light.getLightInstance() a second time");
		Light newLight2 = Light.getLightInstance();
		System.out.println("Light count: " + Light.count);
		
		System.out.println("===================================================================\n");
	}
}
