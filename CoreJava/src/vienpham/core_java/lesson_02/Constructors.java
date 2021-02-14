/*
 * A constructor is a special method is use to instantiate an object 
 * 	1.Must have exactly the same name as its class. 
 * 	2.Must not have return type. 
 * 	3.Cannot be final, abstract or static 
 * 	4.Can have any access modifier including private. 
 * 	5.The first statement in a constructor must me call to this() or super(). If you do not write this statement, the compiler will insert a call to super()
 * 
 *  
 * Every class MUST have a constructor. If not, one will be created for you by the compiler. This is called the default constructor. 
 * 
 * DEFAULT constructors follow all the above rule plus
 * 	6.Has the same access level as the class 
 * 	7.Has no arguments 
 * 	8.Has the call super()
 *  
 * The default constructor looks like this: 
 * public ClassName{
 * 	super();
 * }
 *
 */

package vienpham.core_java.lesson_02;

import java.util.List;

import vienpham.core_java.common.animal.Animal;
import vienpham.core_java.common.animal.RandomAnimalBuilder;
import vienpham.core_java.common.animal.fish.*;
import vienpham.core_java.common.animal.mammal.*;

public class Constructors {
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		testOverloadedConstructors(); 
		System.out.println("================================================================================================================");
		
		testRandomAnimalBuilder();
	}
	
	public void testOverloadedConstructors() {
		Animal[] zoo = new Animal[4]; 
		zoo[0] = new Bear(6); 
		zoo[1] = new Elephant(8);
		zoo[2] = new Swordfish(); 
		zoo[3] = new Swordfish(20); 
		
		
		for(Animal a : zoo) {
			System.out.println(a);
			a.eat(); 
			a.move(); 
			a.sleep(); 
			System.out.println();
		}
	}
	
	public void testRandomAnimalBuilder() {
		System.out.println("2. Test RandomAnimalBuilder: ");
		List<Animal> animals = (List<Animal>)new RandomAnimalBuilder().build(6); 
		
		for(Animal a : animals) {
			System.out.println(a);
			a.eat(); 
			a.move(); 
			a.sleep(); 
			System.out.println();
		}
	}
}
