package vienpham.core_java.lesson_01.exercises;

public class Cat extends Animal {
	
	public Cat(String _name, int _weight) {
		type = "cat";
		name = _name;
		weight = _weight; 
		increaseCount();
	}
	
	public void sound () {
		System.out.println(name + " says Meow! Meow!");
	}
}
