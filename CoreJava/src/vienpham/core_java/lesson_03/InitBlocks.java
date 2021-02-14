package vienpham.core_java.lesson_03;

import vienpham.core_java.common.animal.fish.*;

public class InitBlocks {

	public InitBlocks() {
		
	}
	
	public void inClassWork () {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		whenInitializationRun();
		
		System.out.println("================================================================================================================\n\n");
	}

	private void whenInitializationRun() {
		Swordfish sword = new Swordfish(); 
	}

}
