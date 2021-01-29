/**
 * Board Game class that inherits from Game.
 * HW 1 Q4
 */

class BoardGame extends Game {

  /**
   * Constructor.
   * @param description - String for the super class
   * @param number - number of players
   * @param tie - String [yes/no] to allow tie
   * @param min - int min number of users
   * @param max - int max number of users
   */
  BoardGame(
    final String description,
    final int number,
    final String tie,
    final int min,
    final int max
  ) {
    super(description);
    if (number == 0 || number == 1) {
      System.err.println("Error.Cannot play with 0 or 1 players");
    }
    this.numberPlayers = number;
    this.allowTie = tie;
    this.minNum = min;
    this.maxNum = max;
  }

  BoardGame() {
    //
  }

  /**
   * Attribute for the number of players.
   */
  private int numberPlayers;

  /**
   * Attribute for the max number of players.
   */
  private int maxNum;

  /**
   * Attribute for the min number of players.
   */
  private int minNum;

  /**
   * Attribute for whethere the game can end in tie.
   */
  private String allowTie;

  /**
   * Setter for players.
   * @param players - number of players
   */
  public void setPlayers(final int players) {
    this.numberPlayers = players;
  }

  /**
   * Getter for players.
   * @return int
   */
  public int getPlayers() {
    return numberPlayers;
  }

  /**
   * Setter for allowTie.
   * @param tie - string [yes/no] for to allow a tie
   */
  public void setAllowTie(final String tie) {
    this.allowTie = tie;
  }

  /**
   * Getter for allowTie.
   * @return String
   */
  public String getAllowTie() {
    return allowTie;
  }

  /**
   * overwritting toString().
   * @return String
   */
  public String toString() {
    return super.toString();
  }
}
