package vienpham.core_java.common.animal.mammal;

import vienpham.core_java.common.animal.Sex;

public class Lion extends Carnivora {
//*********************************** VARIABLES SECTION ***********************************
	
//*********************************** CONSTRUCTOR SECTION ***********************************
//	initial constructor 
	{
		setType("lion"); // get this method from Animal class  
		MAX_AGE = 14; 
		MATURITY = 5; 
		
		BIRTH_WEIGHT = 3; 
		ADULT_FEMALE_MIN_WEIGHT = 250; 
		ADULT_FEMALE_MAX_WEIGHT = 400; 
		ADULT_MALE_MIN_WEIGHT =  330; 
		ADULT_MALE_MAX_WEIGHT = 550; 
		
		setMaxRunningSpeed(50);
		prey.add("gazelle"); 
		prey.add("wildebeast"); 
		prey.add("impala"); 
		prey.add("monkey"); 
		prey.add("gnu"); 
		prey.add("baboom"); 
	}
	public Lion() {
	}

	public Lion(int a) {
		this();
		setAge(a); 
	}
	
	public Lion(int a , int w , Sex s) {
		this(a); 
		setWeight(w); 
		setSex(s); 
	}

//*********************************** METHOD SECTION ***********************************
	
// Object method Overrides
	@Override 
	public boolean equals (Object other) {
		if(this == other ) return true; 
		boolean result = false; 
		if(other instanceof Lion) {
			result = super.equals(other); 
		}
		
		return result; 
	}
		
//	Class Animal overrides
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " loping through the jungle!");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping spots under the shade of bushes!");
	}
}
