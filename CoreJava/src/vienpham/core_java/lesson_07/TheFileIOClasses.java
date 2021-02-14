/*
 *  Overview:
 *     File - checking, creating and deleting files and directories
 *     FileInputStream - reads in bytes
 *     FileReader - reads in characters
 *     FileOutputStream - writes out bytes
 *     FileWriter - writes out characters
 *     BufferedReader - reads text streams and stores them in a buffer
 *     BufferedWriter - writes text streams
 *     PrintWriter - easy to use class for writing files
 *
 * File I/O in Java follows the Decorator design pattern
 *
 * FileWriter key methods
 *     constructors using File or String
 *     write() - writes characters out to a file
 *     flush()
 *     close()
 * FileReader key methods
 *     constructors using File or String
 *     read(char []) - reads characters from a file and puts the in a char[]
 *     close()
 *
 * BufferedReader key methods
 *     constructor using Reader
 *     read()
 *     readLine()
 *     close()
 */

package vienpham.core_java.lesson_07;

import java.io.*;

public class TheFileIOClasses {
	
	private static final String file1Line1 = "Forescore and seven years ago our fathers brought forth\n";
	private static final String file1Line2 = "on this continent a new nation, conceived in liberty and dedicated\n";
	private static final String file1Line3 = "to the proposition that all men are created equal.";
	
	public void inClassWork() {
		System.out.println(this.getClass() + ".inClassWork():\n");
		
		File fileToTest = useFileWriter(); 
		useFileReader(fileToTest); 
		useBufferReader(fileToTest); 
		
		System.out.println("===================================================================\n\n");
	}

	private File useFileWriter() {
		System.out.println("1. FileWriter writes out charactors to a file \n");
		
		File myFile = new File("Gettysburg.txt");
		
//		Java 7 way using try-with-resources 
		try(FileWriter fw = new FileWriter(myFile , false)){ // the false is mean clear every thing inside a file an rewrite all-over again 
															 // if is  a true it will append in to a old file 
			fw.write(file1Line1);
			fw.write(file1Line2);
			fw.write(file1Line3);
			fw.flush(); // this line is make sure everything written out before the file is close 
						// the file will auto close 
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return myFile; 
		
	}
	
	private void useFileReader(File inFile) {
		System.out.println("2. FileReader reads in characters from " + inFile);
		
		char[] buffer = new char[(int)inFile.length()]; 
		System.out.println("Size of the file to read in: " + inFile.length());
		
		try(FileReader fr = new FileReader(inFile)){
			int size = fr.read(buffer);
			System.out.println("Size of the file actually read in: " + size);
			for(char buffer_char : buffer) {
				System.out.print(buffer_char); // it print out every single character inside inFile 
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println();
	}
	
	private void useBufferReader(File inFile) {
		System.out.println("3. FileReader reads in text from " + inFile);
		
		String textFromFile = null; 
		
		try(BufferedReader br = new BufferedReader(new FileReader(inFile))){
			while((textFromFile = br.readLine()) != null) { 
				System.out.println(textFromFile);
			}
		}catch(IOException ioe) { 
			System.out.println(ioe);
		}
	}

}




















