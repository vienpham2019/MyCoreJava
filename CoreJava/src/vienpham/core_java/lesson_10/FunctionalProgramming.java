/*
 * A functional interface is an interface with one and only on abstract method 
 * A function interface can have multiple static or default methods 
 * 			( see Predicate in the Java 8 API)
 */

package vienpham.core_java.lesson_10;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.bird.*;
import vienpham.core_java.common.animal.domestic.*;

public class FunctionalProgramming {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork():\n");
		
//		lambdaSystax();
//		passingLambdasIntoMethods();
//		compareLamdasAndMethodReferences(); 
		testSupplier(); 
		System.out.println("===================================================================\n");
	}

	List<Dog> pack = (List<Dog>) new RandomAnimalBuilder(Dog.class).build(10); 
	private List<Dog> dogQuerier(Predicate<Dog> expression){
		List<Dog> result = new ArrayList<>(); 
		for(Dog d : pack) {
			if(expression.test(d)) {
				result.add(d);
			}
		}
		return result; 
	}
	
	private void passingLambdasIntoMethods() {
		System.out.println("2. Passing lambdas into the dogQuerier method: ");
		
		System.out.println("Minimum age of 12: " + dogQuerier(d -> d.getAge() >= 12));
		System.out.println("Maximum age of 20: " + dogQuerier(d -> d.getWeight() <= 20));
		System.out.println("Dogs like Shotgun: " + dogQuerier(d -> {
			boolean b = d.getAge() > 13 && d.getWeight() >= 100; 
			b &= d.getSex() == Sex.MALE; 
 			return b; 
		}));
	}
	
	private void lambdaSystax() {
		System.out.println("Dogs in pack: ");
		for(Dog d : pack) {
			System.out.println(d);
		}
		System.out.println();
		
		System.out.println("1. Find dogs older than 10");
		Predicate<Dog> pred1 = d -> d.getAge() > 10;  			// 'd' is implied from generic <Dog> 
		for (Dog d : pack) {
			if(pred1.test(d)) System.out.println(d);
		}
		

		System.out.println("\n2. Find dogs younger than 5");
		Predicate<Dog> pred2 = (d) -> d.getAge() < 5; 			// Parenthesis left of arrow are optional 
		for (Dog d : pack) {
			if(pred2.test(d)) System.out.println(d);
		}
		
		System.out.println("\n3. Find dogs heavier than 50");
		Predicate<Dog> pred3 = (Dog d) -> d.getWeight() > 50; 			// Parenthesis requiered if explicity declaring d
		for (Dog d : pack) {
			if(pred3.test(d)) System.out.println(d);
		}
		
		System.out.println("\n4. Find dogs lighter than 20");
		Predicate<Dog> pred4 = (Dog d) -> { return d.getWeight() < 20; }; 			// Using curly braces around expression to right of arrow 
		for (Dog d : pack) {								 			// Curly braces required return statement and ending semicolon
			if(pred4.test(d)) System.out.println(d);
		}
		
		System.out.println("\n5. Find Female dogs over 9 weighing < 20");          // Multiple states require curly braces 
		Predicate<Dog> pred5 = d -> {
			boolean result = d.getAge() > 9 && d.getWeight() < 20; 
			
			result &= d.getSex() == Sex.FEMALE;
			return result; 
		};
		
		for(Dog d : pack) {
			if(pred5.test(d)) {
				System.out.println(d);
			}
		}
 	}
	
	private void compareLamdasAndMethodReferences() {
		System.out.println("Predicate interface with method references vs lambdas");
		
		String str = "abcdef"; 
		Predicate<String> pred1Lambda = s -> str.startsWith(s);
		System.out.println("Start with 'A': " + pred1Lambda.test("A"));
		System.out.println("Start with 'a': " + pred1Lambda.test("a"));
		
		Predicate<String> pred1MethodRef = str::startsWith; 
		System.out.println("Start with 'A': " + pred1MethodRef.test("A"));
		System.out.println("Start with 'a': " + pred1MethodRef.test("a"));
		
		Dog dog = new Dog("Scruffy"); 
		dog.setAge(15);
		dog.setWeight(27);
		dog.setBreed("bulldog");
		
		Predicate<Dog> pred2Lambda = d -> d.getAge() > 12; 
		System.out.println("Scruffy over 12? " + pred2Lambda.test(dog));
		
		Predicate<Emu> pred2MethRef = Bird::canFly; 
		System.out.println("Can Emu fly? " + pred2MethRef.test(new Emu()));
	}
	
	private void testSupplier() {
		System.out.println("The SuppliLocalDateon interface");
		Supplier<LocalDate> mRefSupp = LocalDate::now; 
		System.out.println("Today: " + mRefSupp.get());
		
		Supplier<LocalDate> lambSupp = () -> LocalDate.of(1776, 7, 4); 
		System.out.println("Independe");
	}
	

}










