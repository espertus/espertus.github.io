package edu.mills.cs64.final_project;
/**
 * A record of a course taken, such as might appear in a transcript,
 * including the department and number of the course, the year it was 
 * taken, and the grade received.
 * 
 * @author [replace the brackets and their contents with your Mills id]
 * @version 10 April 2016
 */
public class GradeRecord {
    private Course course;
    private int year;
    private String grade;

    /**
     * Constructs a new GradeRecord with the given information.
     * 
     * @param course the course
     * @param year the year the course was taken
     * @param grade the grade earned
     * @throws IllegalArgumentException if the grade is not legal,
     *     as determined by {@link #isLegalGrade(String)}
     */
    public GradeRecord(Course course, int year, String grade)
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
    private static boolean isLegalGrade(String grade)
    {
      return false;
    }

    @Override
    public String toString()
    {
      return course + " " + year + ": " + grade;
    }
}
