package edu.mills.cs64.final_project;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * A Mills College transcript. This only includes courses that
 * fulfill core requirements.
 * 
 * @author [replace the brackets and their contents with your Mills id]
 * @version 10 April 2016
 */
public class Transcript
{
  private String id;
  private String firstName;
  private String lastName;
  private List<GradeRecord> gradeRecords;

  /**
   * Constructs a transcript from a file. The first three lines 
   * describe the student:
   * <pre>
   * ID
   * FIRST_NAME
   * LAST_NAME
   * </pre>
   * They are followed by zero or more grade records in the 
   * following format:
   * <pre>
   * DEPARTMENT NUMBER
   * YEAR
   * GRADE
   * </pre>
   * Here is a sample file:
   * <pre>
   * B00000123
   * Susan
   * Mills
   * CS 63
   * 2015
   * B
   * CS 64
   * 2016
   * A
   * </pre>
   * Grade records are only added to the transcript if the course
   * is found by {@link Course#getClass()}.
   * <p>
   * Results are undefined if the file is not in the appropriate format.
   * (In other words, this method does not do any error checking.)
   * 
   * @param filename the name of the transcript file
   * @throws FileNotFoundException if the file cannot be found
   */
  public Transcript(String filename) throws FileNotFoundException
  {
    // TODO: Write this method. It is more challenging than
    // previous similar methods that you have written because
    // you have to:
    // 1. Read in the id, first name, and last name (once).
    // 2. Write a loop to:
    //    a. Read in each grade record.
    //    b. Look up the Course that matches the grade record.
    //       If no Course can be found, skip this record.
    //    c. Construct a new GradeRecord and add it to the List.
  }

  @Override
  public String toString()
  {
    // TODO: Write this method.
    return "";
  }
    
  /**
   * Tests the program by loading in courses from "courses.txt"
   * and a transcript from "transcript.txt".
   * 
   * @param args ignored
   */
  public static void main(String[] args)
  {
    // You should not modify this method, except possibly
    // temporarily, when testing, after which you should
    // change it back.
    try {
      // Read in courses.
      Course.loadCourses("courses.txt");
      System.out.println("Course.getCourse(\"CS 63\"): " + 
          Course.getCourse("CS 63"));

      // Read in transcript.
      Transcript transcript = new Transcript("transcript.txt");
      System.out.println(transcript);

    } catch (FileNotFoundException e) {
      System.err.println(e.toString());
      return;
    }
  }
}
