package vienpham.core_java.lesson_01;

import vienpham.core_java.lesson_01.exercises.Dog;

public class Arrays {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		System.out.println();
		primitiveArrays(); 
		referenceVariableArrays(); 
//		First step i to declare the array 
		int[] myNums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; 
		
//		Second step is to create ( construct or define ) 
//		myNums = new int[7];
		
//		Third step is to fill it up 
//		myNums[0] = 6;  // indexes for array start at 0 
//		myNums[1] = 12; 
//		myNums[2] = 32;
//		myNums[3] = 13;
//		myNums[4] = 15;
//		myNums[5] = 1;
//		myNums[6] = 76;
		
//		If you try to add an element with an index larger than the array size, you get an ArrayIndexOutOfBoundsException 
//		myNums[7] = 12;
		
//		Array are type-safe this cause a compiler error  
//		myNums[3] = true;

		System.out.println();
	}
	
	
	private void primitiveArrays() {
//		First step is to declare the array 
		Dog[] kennel ;
		
//		Second step is to create ( construct or define )
		kennel = new Dog[3]; 
//		
		for(int i = 0 ; i < kennel.length ; i ++) {
			kennel[i] = new Dog(); 
		}
		
//		Array are safe-type this cause a compile error
//		kennel[1] = new Cat() 
		
		
		kennel[0].name = "Lassie"; 
		kennel[1].name = "Snoopy";
		kennel[2].name = "Rover"; 
		
		kennel[0].weight = 70; 
		kennel[1].weight = 12; 
		kennel[2].weight = 21; 
		
//		To process the array we can use for-each loop 
		for(Dog d : kennel) {
			d.bark(); 
		}
	}
	
	private void referenceVariableArrays (){
		
	}
	
}
