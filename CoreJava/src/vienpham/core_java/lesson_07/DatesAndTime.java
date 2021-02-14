/*
 * New classes introduced in Java 8 for managing dates and time in package java.time:
 *		LocalDateTime: immutable objects which contain date and time information
 *		LocalDate: immutable objects which contain date information
 *		LocalTime: immutable objects which contain time information
 *		DateTimeFormatter: formats data and time information to a desires string and parses Strings into a LocalDate and/or Time object
 *		Period: represents a date interval
 *		Duration: represents a time interval
 * New interface in Java 8 in package java.time.temporal
 *		TemporalAmount: the interface implemented by Period
 */
package vienpham.core_java.lesson_07;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoUnit;

public class DatesAndTime {
	public void inClassWork() {
		System.out.println(this.getClass() + ".inClassWork():\n");

		theLocalDateClass(); 
		theLocalTimeClass();
		theLocalDateTimeClass();
		
		thePeriodClass(); 
		theDurationClass(); 
		
		manipulationDatesAndTimes(); 
		
		System.out.println("===================================================================\n\n");
	}

	private void theLocalDateClass() {
		System.out.println("1. The LocalDate and Class: \n");
		
		LocalDate date1 = LocalDate.now();
		System.out.println("Using now: " + date1);
		
		LocalDate date2 = LocalDate.of(2010, Month.SEPTEMBER, 25); 
		System.out.println("Using of: " + date2);
		
		LocalDate date3 = LocalDate.from(date2); 
		System.out.println("Using from: " + date3);
		
		JapaneseDate date4 = JapaneseDate.from(LocalDate.now());
		System.out.println("JapaneseDate: " + date4);
		
		
		
		System.out.println("===================================================================\n");
	}
	
	private void theLocalTimeClass() {
		System.out.println("2. The LocalTime and Class: \n");
		
		LocalTime time1 = LocalTime.now();
		System.out.println("Using now: " + time1);
		
		LocalTime time2 = LocalTime.of(15, 38 ,24); 
		System.out.println("Using of: " + time2);
		
		LocalTime time3 = LocalTime.from(LocalDateTime.now()); 
		System.out.println("Using from: " + time3);
		
		System.out.println("===================================================================\n");
	}
	
	private void theLocalDateTimeClass() {
		System.out.println("3. The LocalDateTime and Class: \n");
		
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println("Using now: " + dt1);
		
		LocalDateTime dt2 = LocalDateTime.of(2010 , 9 , 25, 15 , 38 , 24); 
		System.out.println("Using of: " + dt2);
		
		LocalDateTime dt3 = LocalDateTime.from(LocalDateTime.now()); 
		System.out.println("Using from: " + dt3);
		
		LocalDateTime dt4 = LocalDateTime.parse("1776-07-04T17:30");
		System.out.println("Using parse: " + dt4);
		
		System.out.println("===================================================================\n");
	}
	
	private void thePeriodClass() {
		System.out.println("4. The Period Class measures the difference between dates: \n");
		
		LocalDate independance = LocalDate.of(1776, Month.JULY, 4); 
		
		Period p1 = Period.between(independance, LocalDate.now()); 
		System.out.println("Using between: " + p1);
		
		System.out.println(p1.getYears() + " years");
		System.out.println(p1.toTotalMonths() + " months");
		System.out.println(p1.getDays() + " days");
		
		System.out.println("===================================================================\n");
	}
	
	private void theDurationClass() {
		System.out.println("5. The Period Class measures the difference between times: \n");
		
		LocalTime thisMorning = LocalTime.of(8, 23 , 42); // hours , minutes , seconds 
		Duration d1 = Duration.between(thisMorning, LocalTime.now()) ; 
		
		System.out.println("Using between: " + d1);
		
		System.out.println(d1.toHours());
		System.out.println(d1.toMinutes());
		System.out.println(d1.getSeconds());
		
		System.out.println("===================================================================\n");
	}
	
	private void manipulationDatesAndTimes() {
		System.out.println("6a. Manipulating Dates using LocalDate: \n");

		LocalDate date1 = LocalDate.of(2000, 10, 10); 
		Period p1 = Period.ofMonths(200); // 200 months 
		System.out.println(date1);
		
		LocalDate date2 = date1.plus(p1); // add 200 months to date1
		System.out.println(date2);
		
		Period p2 = Period.of(0 , 6 , 30); // 6 months and 30 days 
		LocalDate date3 = date2.minus(p2); // minus 6 months and 30 days from date2 
		System.out.println(date3);
		
		System.out.println("6b. Manipulating Dates using LocalTime: \n");
		
		LocalTime thisMorning = LocalTime.of(8 , 23, 42); 
		System.out.println(thisMorning);
		
		Duration d1 = Duration.of(325 , ChronoUnit.MINUTES); // 325 minute
		LocalTime time2 = thisMorning.plus(d1); // add 325 minute to thisMorning 
		
		System.out.println(time2);
		
		
		System.out.println("===================================================================\n");
	}


}













