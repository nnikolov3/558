/**
 * Class that uses the BoardGame class.
 * HW 1 Q4
 */

class FunGame extends BoardGame {

  /**
   * Attribute for the min number of players.
   */
  private int min;

  /**
   * Attribute for the max number of players.
   */
  private int max;

  /**
   * Attribut for the time limit.
   */
  private int time;

  /**
   * Attribut for numger of players.
   */
  private int num;

  /**
   * Constructor.
   * @param description - String for the super class
   * @param number - number of players
   * @param tie - String [yes/no] to allow tie
   * @param minNum - int minimum number of players
   * @param maxNum - int maximum number of players
   * @param limitTime - int for time limit to finish the game
   */

  FunGame(
    final String description,
    final int number,
    final String tie,
    final int minNum,
    final int maxNum,
    final int limitTime
  ) {
    super(description, number, tie, minNum, maxNum);
    if (number > maxNum) {
      System.err.println("Error. Max num exceeded");
    }
    if (number < minNum) {
      System.err.println("Error. Not enough players");
    }

    this.min = minNum;
    this.max = maxNum;
    this.time = limitTime;
    this.num = number;
  }

  FunGame() {
    //
  }

  /**
   * Setter for min \# of players.
   * @param minPlayers - number of players
   */
  public void setMinPlayers(final int minPlayers) {
    if (minPlayers < num) {
      System.err.println("Error. No enough players");
    } else {
      this.min = minPlayers;
    }
  }

  /**
   * Getter for min \# of players.
   * @return int
   */
  public int getMinPlayers() {
    return min;
  }

  /**
   * Setter for max \# of players.
   * @param maxPlayers - number of players
   */
  public void setMaxPlayers(final int maxPlayers) {
    if (num > maxPlayers) {
      System.err.println("Error. Too many players");
    } else {
      this.max = maxPlayers;
    }
  }

  /**
   * Getter for max \# of players.
   * @return int
   */
  public int getMaxPlayers() {
    return max;
  }

  /**
   * Setter for time limit.
   * @param limitTime - int time in minutes
   */
  public void setTime(final int limitTime) {
    this.time = limitTime;
  }

  /**
   * Getter for time limit.
   * @return int
   */
  public int getTime() {
    return time;
  }

  /**
   * overwritting toString().
   * @return String
   */
  public String toString() {
    return super.toString();
  }
}
