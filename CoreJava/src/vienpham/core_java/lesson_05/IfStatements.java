package vienpham.core_java.lesson_05;

public class IfStatements {

	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
		ifElseBasics();
		multipleBranches(); 
		
		System.out.println("================================================================================================================\n\n");
	}

	private void ifElseBasics() {
		boolean booleanExpression = false; 
		
		if(booleanExpression) {
			System.out.println("Inside if block");
		}else {
			System.out.println("Inside else block");
		}
		
		if(true) {
			System.out.println("This always executes");
		}
		
		if(false) {
			System.out.println("This never executes");
			
		}
	}
	
	private String multipleBranches() {
		int score = 75;
		String grade; 
		
		if(score >= 90) {
			grade = "A";
		}else if(score >= 80) {
			grade = "B";
		}else if(score >= 70) {
			grade = "C"; 
		}else if(score >= 60) {
			grade = "D"; 
		}else {
			grade = "F";
		}
		
		return grade; 
	}
	

}
