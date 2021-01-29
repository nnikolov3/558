/**
 * Provided for HW1.
 */

public class Game {

  /**
   * Attribute.
   */
  private String mDescription;

  /**
   * Constructor.
   * @param description - String description of the game
   */
  public Game(final String description) {
    setDescription(description);
  }

  Game() {
    //
  }

  /**
   * Getter for Description.
   */
  public String getDescription() {
    return mDescription;
  }

  /**
   * Setter for Description.
   */
  public void setDescription(String description) {
    mDescription = description;
  }

  public String toString() {
    return ("description: " + mDescription);
  }
}
