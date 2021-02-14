/*
 * Dates overview
 * Date class holds the value of the date in milliseconds from the start of the epoch
 * 		Most of this class's methods have been deprecated, but you can use
 * 		this class to bridge between the Calendar and DateFormat classes.
 * Calendar class allows you to manipulate dates and times
 * DateFormat class lets you to display the value in a human understandable format
 *
 * epoch - starts January 1, 1970 at midnight
 *
 */

package vienpham.core_java.lesson_07;

import java.text.DateFormat;
import java.util.*;

public class DatesAndTimeBeforeJava8 {
	public void inClassWork() {
		System.out.println(this.getClass() + ".inClassWork():\n");

		theDateClass(); 
		theCalenderClass();
		usingDateFormatClass();
		
		System.out.println("===================================================================\n\n");
	}

	private void theDateClass() {
		System.out.println("1. the date class");
		Date now = new Date(); 
		System.out.println("The current date is " + now);
		System.out.println(now.getTime());
		Date then = new Date(1_000_000_000_000L);
		System.out.println("The current date is " + then);
		System.out.println(then.getTime());
		
		System.out.println(then.getMonth());
		
		System.out.println("===================================================================\n");
	}
	
	private void theCalenderClass() {
		System.out.println("2. the calender class\n");
		
		Calendar now = Calendar.getInstance();
		
		System.out.println(now);
		System.out.println(now.getTime());
		
		Calendar future = Calendar.getInstance();
		future.add(Calendar.MONTH , 1);
		System.out.println(future.getTime());
		
		future.setTime(now.getTime());
		System.out.println(future.getTime());
		future.add(Calendar.DAY_OF_MONTH, 31);
		System.out.println(future.getTime());
		
		System.out.println("===================================================================\n");
	}
	
	private void usingDateFormatClass() {
		System.out.println("3. using date format class \n");
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2015, 6, 4);
		
		DateFormat df1 = DateFormat.getDateInstance();
		System.out.println(df1.format(c1.getTime()));
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(df2.format(c1.getTime()));
		
		DateFormat df3 = DateFormat.getDateTimeInstance();
		System.out.println(df3.format(c1.getTime()));
		
		System.out.println("===================================================================\n");
	}
}















