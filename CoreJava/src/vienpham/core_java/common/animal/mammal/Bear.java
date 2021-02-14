package vienpham.core_java.common.animal.mammal;

public class Bear extends Carnivora {
//*********************************** VARIABLES SECTION ***********************************
	
//*********************************** CONSTRUCTOR SECTION ***********************************
	
	public Bear() {
		setType("bear"); // get this method from Animal class 
		
		MAX_AGE = 14; 
		MATURITY = 5; 
		
		BIRTH_WEIGHT = 3; 
		ADULT_FEMALE_MIN_WEIGHT = 250; 
		ADULT_FEMALE_MAX_WEIGHT = 400; 
		ADULT_MALE_MIN_WEIGHT =  330; 
		ADULT_MALE_MAX_WEIGHT = 550; 
		
		setMaxRunningSpeed(50);
		
		prey.add("mixed diet of plants"); 
		prey.add("berries") ;
		prey.add("fish"); 
	}
	
	public Bear(int a) {
		this(); 
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}

//*********************************** METHOD SECTION ***********************************

	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " loping through the jungle!");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping in a leaves, grass, and twigs!");
	}
}
