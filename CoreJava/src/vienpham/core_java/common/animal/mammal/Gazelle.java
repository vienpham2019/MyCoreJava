package vienpham.core_java.common.animal.mammal;

public class Gazelle extends Herders {

	
	{
		MAX_AGE = 15;
		MATURITY = 5; 
		BIRTH_WEIGHT = 5; 
		ADULT_FEMALE_MIN_WEIGHT = 33; 
		ADULT_FEMALE_MAX_WEIGHT = 55; 
		ADULT_MALE_MIN_WEIGHT = 44;
	}
	public Gazelle() {
		setType("gazelle"); 
		setMaxRunningSpeed(50); 
	}
	
//	Animal override 
	
	public void eat() {
		if(getAge() == 0) {
			System.out.println(getExtenedType() + " nurses on mother's milk");
		}else {
			System.out.println(getExtenedType() + " eats short grass made avaiable by zebras trampling tall grass");
		}
	}
	public void sleep() {
		System.out.println(getExtenedType() + " sleeps for five minutes.");
	}
	
	public void move(){
		if(isRunning()) {
			super.move();
			System.out.println(getExtenedType() + " running for its life!!!");
			changeHealth(-3); 
		}else {
			System.out.println(getExtenedType() + " walking slowly with the herd to find new grazing land");
			changeHealth(-1); 
		}
	}
}
