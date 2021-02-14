/*
 *  Definitions.java Copyright 2015, 2020 Steve Montgomery, All rights reserved
 *  1.  Source - the code you write saved in a file with a .java extension
 *  2.  Compiler - a tool (javac) that turns the source code into bytecode and saves it in
 *      a file with the .class extension
 *  3.  Bytecode - compiled code that can be run by any JVM
 *  4.  JVM - Java Virtual Machine, a program that runs your application on a computer or device.
 *  5.  Source file - the file you save when writing Java (this one is named ADefinitions.java
 *  6.  Class - a template that describes the state and behavior of objects
 *  7.  Keyword - a restricted word in java that means something special to the compiler. 
 *      In Eclipse, they are colored purple (by default)
 *  8.  Whitespace - spaces, carriage returns, tabs. They mean nothing to the compiler
 *      
 *  Everything in these first 16 lines is a multi-line or block comment
 *  
 */

// Everything following the // is a single line comment

// This is called the package declaration. It is similar to the directory that this java file is 
// located in. If present, it must be the very first line of code (excluding whitespace and comments)
package vienpham.core_java.lesson_01;


public class Definitions {
	int x; 
	boolean b; 
	String s1 = "Java Rocks!";
	public void inClassWork() {
		System.out.println(s1); 
	}
	
	public void setS1(String _s1) {
		s1 = _s1; 
	}
}