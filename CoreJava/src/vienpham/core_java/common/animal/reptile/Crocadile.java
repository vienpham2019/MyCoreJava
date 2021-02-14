package vienpham.core_java.common.animal.reptile;

public class Crocadile extends Reptile {

	public Crocadile() {
		setType("crocadile");
		MAX_AGE = 100; 
		MATURITY = 10; 
		prey.add("frog"); 
		prey.add("fish");
		prey.add("rat");
	}
	
	@Override 
	public void move() {
		System.out.println(getExtenedType() + " swimming stealtily just below the  surface with its ");
	}
	
	@Override 
	public void sleep() {
		System.out.println(getExtenedType() + " sleeping like a log");
	}
	

}
