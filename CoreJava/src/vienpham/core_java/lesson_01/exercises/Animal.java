package vienpham.core_java.lesson_01.exercises;

public class Animal {
	private static int count = 0; 
	public static int getCount() {return count;}; 
	public String type; 
	public int age; 
	public int weight; 
	public String name; 
	
	public void getInfo(){
		System.out.println("The " + type + " is name " + name + " and he/she is " + weight + " lb.");
	}
	
	public void sleep() {
		System.out.println(type + " name " + name + " is sleeps.");
	}
	
	public void increaseCount() {
		count++; 
	}
}
