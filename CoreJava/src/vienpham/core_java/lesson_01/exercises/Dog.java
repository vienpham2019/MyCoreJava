package vienpham.core_java.lesson_01.exercises;
  
public class Dog extends Animal { 
	
	public Dog() {
		type = "dog"; 
		name = ""; 
		weight = 0; 
		increaseCount(); 
	}
	
	public Dog(String _name , int _weight) {
		type = "dog"; 
		name = _name; 
		weight = _weight;
		increaseCount(); 
	}
	
	public void bark() {
		String bark = name + " says ";
		
		if(weight > 60) {
			bark += "Woof! Woof!"; 
		}else if(weight > 14) {
			bark += "Ruff! Ruff!"; 
		}else {
			bark += "Yip! Yip!";
		}
		
		System.out.println(bark);
	}
}
