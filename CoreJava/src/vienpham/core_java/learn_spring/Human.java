package vienpham.core_java.learn_spring;

public class Human {
	
	Heart heart; 
	
	public void getHeart(Heart heart) {
		this.heart = heart; 
	}
	
	public void pumping() {
		if(this.heart != null) heart.beating();
		else System.out.println("no heart object");
	}
}
