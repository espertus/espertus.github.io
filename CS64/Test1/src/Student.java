import java.util.UUID;

/**
 * A student is represented by a name and unique ID.
 * 
 * INDICATE HERE WHETHER YOU SUCCESSFULLY IMPLEMENTED EVERYTHING
 * OR IF ANYTHING IS BROKEN/INCOMPLETE.
 *
 * @author Ellen Spertus
 */
public class Student {

  /**
   * Constructs a new student with the given first name, middle name, and last name.
   * 
   * @param firstName the personal name
   * @param middleName the middle name
   * @param lastName the family name
   */
  public Student(String firstName, String middleName, String lastName)
  {
  }
  
  /**
   * Constructs a new student with a given first name and last name but no middle name.
   * 
   * @param firstName the personal name
   * @param lastName the family name
   */
  public Student(String firstName, String lastName)
  {
  }
  
  /**
   * Constructs a new student with the given name. For more information on the
   * format, see {@link #setName(String)}.
   * 
   * @param name the full name of the student
   */
  public Student(String name)
  {
  }
  
  /**
   * Returns the student's first name, or the empty string if it has not been initialized.
   * 
   * @return the student's first name
   */
  public String getFirstName()
  {
  }
  
  /**
   * Returns the student's middle name, or the empty string if it has not been initialized.
   * 
   * @return the student's middle name
   */
  public String getMiddleName()
  {
  }
  
  /**
   * Returns the student's last name, or the empty string if it has not been initialized.
   * 
   * @return the student's last name
   */
  public String getLastName()
  {
  }
  
  /**
   * Gets a student's full name, which consists of their first name, middle name (if present),
   * and last name, separated by spaces. If the student does not have a middle name, there
   * should be only a single space between the first name and last name.
   * 
   * @return the student's full name
   */
  public String getName()
  {
  }
  
  /**
   * Sets the student's first, middle, and last name from the argument,
   * which must contain either two or three words, separated from each other
   * by a single space. If there are exactly two words, the substring before 
   * the space becomes the new first name, the middle name is set to the 
   * empty string, and the substring after the space becomes the new last 
   * name. If there are two spaces, the student gets a new first name, 
   * middle name, and last name. If there are either 0 spaces or more than 
   * 2 spaces, none of the names are changed, and an error message is printed.
   *
   * @param newName the new name, which should consist of a first name, optional middle
   *     name, and last name, separated by spaces
   */
  public void setName(String newName)
  {
  }
  
  /**
   * Returns the student unique alphanumeric identifier.
   * 
   * @return the identifier
   */
  public String getId()
  {
  }
  
  /**
   * {@inheritDoc}
   * 
   * Creates a string of the form "Name (id)".
   * 
   * @return a string representation of the student
   */
  @Override
  public String toString()
  {
  }
  

  /**
   * {@inheritDoc}
   * 
   * Tests whether the argument is equal to this student, which
   * will be the case only if the argument is a {@code Student}
   * with the same ID (regardless of the names).
   * 
   * @param other the object to compare to this
   * @return true if the students have the same ID, false otherwise
   */
  @Override
  public boolean equals(Object other)
  {
  }

  private String generateID()
  {
    return UUID.randomUUID().toString();
  }
}
