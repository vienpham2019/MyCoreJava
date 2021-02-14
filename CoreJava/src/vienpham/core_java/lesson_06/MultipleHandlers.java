/*
 * 
 */
package vienpham.core_java.lesson_06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.mammal.*;

public class MultipleHandlers {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");

//		throwingExceptions();
		exceptionMatching(); 
		
		Lion leo = new Lion(6, 350 , Sex.MALE); 
		leo.hunt();
		leo.sleep();
		
		intergateFileListsIntoRAB(); 
		
		System.out.println("===================================================================\n\n");
	}

	public void printAverage(int total, int number) {
		// Add try catch here
		try {
			int average = computeAverage(total, number);
			System.out.println("Average = " +                     
					total + " / " + number + " = " + average);
		}catch(IllegalArgumentException e) {
			System.err.println("Exception handel in printAverage: " + e);
		}catch (ArithmeticException ae) {
			System.out.println(ae);
		}
		
		System.out.println("Exit printAverage().");
	}

	//  Notice that the exception is propagated from the computeAverage
	//  method to the printAverage method where it is handled by a catch block
	public int computeAverage(int sum, int number) {
		if(number == 0) {
			// programmatically throwing an exception 
			throw new IllegalArgumentException("computeAverage number parameter can't be 0"); 
		}
		System.out.println("Computing average.");             
		// Exception may be triggered here
		return sum/number;                                    
	}
	
	public void throwingExceptions() {
		System.out.println("1. Programmatic throwing of an exception: ");
		
		System.out.println("1. Normal execution \n");
		printAverage(100 , 20); 
		
		System.out.println("-----------------------\n");
		System.out.println("2. Falty execution.");
		printAverage(100 , 0); 
	}
	
	private void exceptionMatching() {
		System.out.println("2. Exception matching with multiple catch blocks");
		RandomAccessFile raf = null; 
		try {
			raf = new RandomAccessFile("myfile.txt" , "r");
			byte[] buffer = new byte[100]; 
			raf.readFully(buffer , 0 , 100);
			computeAverage(100 , 0);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
		} catch (NullPointerException npe) {
			System.out.println(npe);
		} catch (ArithmeticException ae) {
			System.out.println(ae);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}catch (IOException ioe) {
			System.out.println(ioe);
		}finally {
			try {
				raf.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	private void intergateFileListsIntoRAB() {
		System.out.println();
		System.out.println("3. Testing file name in RandomAnimalBuilder\n");
		RandomAnimalBuilder builder = new RandomAnimalBuilder(); 
		try {
			builder.testGetClassList("bird");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} 
	}

}







