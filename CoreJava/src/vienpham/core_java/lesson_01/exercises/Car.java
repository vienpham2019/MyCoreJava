package vienpham.core_java.lesson_01.exercises;

public class Car {
	public String make = "Ford"; 
	public String color = "green";
	
	public void drive() {
		String s = color; 
		s += " " + make; 
		s += " ratting down the road"; 
		System.out.println(s);
	}
}
