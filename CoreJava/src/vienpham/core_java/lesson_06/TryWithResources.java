package vienpham.core_java.lesson_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResources {

	private Path parentDir = Paths.get("src" , "vienpham", "core_java", "common", "animal"); 
	
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()\n");
		
//		java6Way(); 
		java7Way(); 
		
		System.out.println("===================================================================\n\n");
	}

	private void java6Way() {
		System.out.println("1. Print out Gazelle.java using the Java 6 and earlier way");
		Path targetFile = Paths.get(parentDir.toString() , "mammal" , "Horse.java");
		String data = null ; 
		BufferedReader reader = null;
		
		try {
			reader = Files.newBufferedReader(targetFile);
			while((data = reader.readLine()) != null ) {
				System.out.println(data);
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		} finally {
			try {
				reader.close();
			}catch(IOException e) {
				System.out.println(e);
			}
		}
	}
	
	private void java7Way() {
		System.out.println("2. Print out other class using Try-With-Resources");
		
		Path targetFile = Paths.get(parentDir.toString() , "bird" , "Hawk.java"); 
		String data = null; 
			
		try (BufferedReader br = Files.newBufferedReader(targetFile)){
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
	
	
}
















