package edu.mills.cs64.final_project;
import java.io.FileNotFoundException;
import java.util.Hashtable;

/**
 * A representation of an academic course. Course information
 * can be loaded from a file through the method {@link #loadCourses(String)}.
 * After this method has been called, courses can be retrieved
 * through the method {@link #getCourse(String)}.
 * 
 * @author [replace the brackets and their contents with your Mills id]
 * @version 10 April 2016
 */
public class Course
{
  private String department;
  private int number;
  private String name;
  private int credits;
  // TODO: Add instance variable requirementsMet.
  // TODO: Add hash table courses.

  // TODO: Write private constructor.
  
  /**
   * Loads course information from the specified file, after
   * which the information can be retrieved by calling 
   * {@link #getCourse(String)}.
   * <p>
   * The file should consist of records in the following
   * format:
   * <pre>
   *     DEPARTMENT NUMBER
   *     NAME
   *     CREDITS
   *     REQUIREMENTS MET (comma-separated list)
   * </pre>
   * Here is a sample file:
   * <pre>
   *     CS 64
   *     Computer Concepts and Intermediate Programming
   *     4
   *     QL
   *     ARTH 18
   *     Introduction to Western Art
   *     3
   *     CA, CIE, IP
   * </pre>
   * All courses in the file must meet at least one requirement.
   * <p>
   * Results are undefined if the file is not in the proper format.
   * (In other words, there is no error checking and recovery.)
   * 
   * @param filename the name of the file with course information
   * @throws FileNotFoundException if the file cannot be found
   */
  public static void loadCourses(String filename) 
      throws FileNotFoundException
  {
    // TODO: Write this.
    // Note that in order to construct an instance of Course,
    // you will have to get the CoreRequirement (e.g, CoreRequirement.SI)
    // associated with the textual representation of the requirement (e.g., "SI")
    // in the file.
  }
  
  /**
   * Gets a course that was previously loaded through a call
   * to {@link #loadCourses(String)}.
   * 
   * @param shortName the short name of the course, as would be
   *     returned by {@link #getShortName()}
   * @return the course, or null if it cannot be found
   * @throws IllegalStateException if courses have not yet been
   *     loaded
   */
  public static Course getCourse(String shortName) 
      throws IllegalStateException
  {
    // TODO: Write this.
    return null;
  }
  
  /**
   * Gets a short version of the name of this course.
   * This consists of the department and the number, e.g.,
   * "CS 64".
   * 
   * @return a short version of the name of this course
   */
  public String getShortName()
  {
    return department + " " + number;
  }
}
