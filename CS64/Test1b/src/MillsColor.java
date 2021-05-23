import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Test 1B
 * 
 * @author Ellen Spertus [Replace with your Mills ID]
 */
public class MillsColor
{
  /**
   * Constructs a new instance with the given color component values,
   * which are passed through {@link #boundColorComponent(int)} to 
   * ensure that they are in the range 0 to 255, inclusive.
   * 
   * @param red the red color component
   * @param green the green color component
   * @param blue the blue color component
   */
  public MillsColor(int red, int green, int blue)
  {
  }
  
  /**
   * Tests whether the color component is in the range
   * 0 to 255, inclusive.
   * 
   * @param component a color component
   * @return {@code true} if in the range 0 to 255, inclusive;
   *     false otherwise
   */
  protected static boolean inRange(int component)
  {
  }
  
  /**
   * Sets this color's red component to the argument,
   * if it is in range, as determined by 
   * {@link #inRange(int)}. If it is not in range,
   * no change is made.
   * 
   * @param red the new red component
   */
  public void setRed(int red)
  {
  }
  
  /**
   * Sets this color's green component to the argument,
   * if it is in range, as determined by 
   * {@link #inRange(int)}. If it is not in range,
   * no change is made.
   * 
   * @param green the new green component
   */
  public void setGreen(int green)
  {
  }
  
  /**
   * Sets this color's blue component to the argument,
   * if it is in range, as determined by 
   * {@link #inRange(int)}. If it is not in range,
   * no change is made.
   * 
   * @param blue the new blue component
   */
  public void setBlue(int blue)
  {
  }
  
  /**
   * Returns the red component.
   * 
   * @return the red component
   */
  public int getRed()
  {
  }
  
  /**
   * Returns the green component.
   * 
   * @return the green component
   */
  public int getGreen()
  {
  }
  
  /**
   * Returns the blue component.
   * 
   * @return the blue component
   */
  public int getBlue()
  {
  }
  
  /**
   * Ensures that a color component is within the
   * range [0, 255]. Specifically, if the parameter
   * is greater than 255, the return value is 255;
   * if the parameter is less than 0, the return
   * value is 0; otherwise, the return value is the
   * parameter.
   * 
   * @param i a numeric color component value
   * @return a component value in the range 0 to 255, inclusive
   */
  protected static int boundColorComponent(int i)
  {
  }
  
  /**
   * Returns a string representation of this color of the
   * form "(r, g, b)", where r, g, and b are the red, green,
   * and blue color components, respectively. For example,
   * if the red component was 5, the green component 10, and
   * the blue component 20, the string representation would
   * be "(5, 10, 20)".
   * 
   * @return a string representation of the color
   */
  public String toString()
  {
  }
  
  /**
   * Tests whether this color is equal to the argument. This
   * will be the case if and only if the argument is also a
   * {@code MillsColor} with the same three component values.
   * 
   * @return {@code true} if they have the same component values,
   *     {@code false} otherwise
   */
  public boolean equals(Object o)
  {
  }
  
  /**
   * Displays a window whose background color is this color and
   * whose text is the value returned by {@link #toString()}.
   * The implementation of this method is provided for you.
   */
  public void display()
  {
    // Source: http://stackoverflow.com/a/9064970/631051
    UIManager.put("OptionPane.background", new Color(getRed(), getGreen(), getBlue()));
    UIManager.put("Panel.background", new Color(getRed(), getGreen(), getBlue()));
    JOptionPane.showMessageDialog(null, toString(), 
        "SetColor", JOptionPane.INFORMATION_MESSAGE); 
  }
  
  /**
   * Tests the method {@link #equals(Object)} by creating 3 instances
   * and testing them for equality. It should be clear from the printed
   * output what three colors were created and which pairs of colors
   * were found to be equal.
   */
  protected static void testEqualsMethod()
  {
  }

  /**
   * Repeatedly prompts user to provide red, green, and blue color
   * component values, which are used to create a new instance of
   * this class, which is printed and displayed. This does no error 
   * checking. The program ends after the user enters a color with 
   * a negative component value.
   * 
   * @param args ignored
   */
  public static void main(String[] args)
  {
    // Uncomment the following call when testing your equals() method
    // and creating your transcript.
    //testEqualsMethod();

    // The next two lines are provided for your convenience. Delete this comment.
    //System.out.println("Enter red, green, and blue color components, separated by spaces.");
    //System.out.println("To end the program, make any component negative.");
  }
}
