0package edu.mills.cs64.test2;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * A record of a course taken, such as might appear in a transcript,
 * including the name of the course, the year it was taken, and the
 * grade received.
 * 
 * Replace this sentence with a precise statement of what functionality
 * does and does not work.
 * 
 * @author [replace the brackets and their contents with your Mills id]
 */
public class GradeRecord {
    private static final String GRADES_FILE = "grades.txt";
    private String courseName;
    private String grade;
    private int year;

    /**
     * Constructs a new GradeRecord with the given information.
     * 
     * @param courseName the name of the course
     * @param grade the grade earned in the course
     * @param year the year in which the course was taken
     * @throws IllegalArgumentException if the grade is not legal,
     *     as determined by {@link #isLegalGrade(String)}
     */
    public GradeRecord(String courseName, String grade, int year)
	    throws IllegalArgumentException
    { 
    }

    /**
     * Checks whether a character represents a legal grade. Legal
     * grades are "A", "B", "C", "D", and "F".
     * 
     * @param grade a potential grade
     * @return true if it is a legal grade, false otherwise
     */
    public static boolean isLegalGrade(String grade)
    {
	// TODO: Write this method.
	return true;
    }

    @Override
    public String toString()
    {
	return "[" + courseName + " " + year + ": " + grade + "]";
    }

    /**
     * Reads in grade records from a file and displays information about them.
     * 
     * @param args ignored
     */
    public static void main(String[] args)
    {
	int numFailures = 0;

	// Read in grade records.
	List<GradeRecord> records = new ArrayList<GradeRecord>();
	File inputFile = new File(GRADES_FILE);

	// TODO: Modify the following code to handle any checked
	// exceptions that could be thrown by existing method/constructor
	// calls and the IllegalArgumentException that could be thrown by
	// the GradeRecord constructor.
	Scanner scanner = new Scanner(inputFile);
	while (scanner.hasNext())
	{
	    // Do not modify or separate the following 6 statements,
	    // although you may put whatever you want before, after,
	    // or around them, or anywhere else in this method.
	    String courseName = scanner.nextLine();
	    String grade = scanner.nextLine();
	    int year = Integer.parseInt(scanner.nextLine());
	    GradeRecord record = new GradeRecord(courseName, grade, year);
	    records.add(record);
	    System.out.println("New record created: " + record);
	}
	scanner.close();

	// TODO: Add code to complete the following statements.
	// You will need to replace each 0, plus possibly add additional
	// code elsewhere.
	System.out.println("\nNumber of records created: " + 0);
	System.out.println("Number of records that could not be created: " + 0);


	// TODO: Add code to sort records by year, starting with the
	// most recent year, and print the results after the below
	// statement. If two courses have the same year, their order
	// does not matter. XC: Sort courses with the same year alphabetically.
	System.out.println("\nGrade records sorted by year: ");

	// TODO: Add code to sort records alphabetically by course name
	// and print the results after the below statement.
	System.out.println("\nGrade records sorted by course name: ");

	System.out.println("\nDone.");
    }
}
