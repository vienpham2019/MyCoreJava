package vienpham.core_java.lesson_04;

public class LogicOperators {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		testAnd();
		testOr();
		System.out.println("================================================================================================================\n\n");
	}

	private void testAnd() {
		System.out.println("1. AND result. \n");
		boolean result ; 
		
		result = (5 > 3) && (9 > 6); 
		System.out.println(result);
		
		result = (5 > 3) && (9 < 6); 
		System.out.println(result);
		
		result = (5 < 3) && (9 > 6); 
		System.out.println(result);
		
		result = (5 < 3) && (9 < 6); 
		System.out.println(result);
		
	}
	
	private void testOr() {
		System.out.println("2. OR result. \n");
		boolean result ; 
		
		result = (5 > 3) || (9 > 6); 
		System.out.println(result);
		
		result = (5 > 3) || (9 < 6); 
		System.out.println(result);
		
		result = (5 < 3) || (9 > 6); 
		System.out.println(result);
		
		result = (5 < 3) || (9 < 6); 
		System.out.println(result);
		
	}

}
