/*
 * Client for FunGame,BoarGame,Game.
 * Nikolay Nikolov
 * ECE558 Winter 2021
 * locked in Java
 */

class TestRunnerGame {

  /*
   * Simple TestRunner.
   */

  /**
   * Returned value from a function call.
   */
  private double returnedValue;

  /**
   * Expected value if the function returns correctly.
   */

  private double expectedValue;
  /**
   * Test index is the test count.
   */

  private int testIndex;
  /**
   * Test name is the description of the test.
   * Example. function A should return B when input is C
   */

  private String testName;

  /**
   * Constructor for the TestRunner.
   *
   * @param name - test name
   * @param ret - returned value from function tested
   * @param exp - expected value from function tested
   * @param index - test index
   */
  TestRunnerGame(
    final String name,
    final double ret,
    final double exp,
    final int index
  ) {
    this.testName = name;
    this.returnedValue = ret;
    this.expectedValue = exp;
    this.testIndex = index;
  }

  // function to run the test
  public void runner() {
    if (returnedValue == expectedValue) {
      System.out.println("Test: " + testIndex);
      System.out.println(testName);
      System.out.println("Success");
      System.out.println("---------------");
    } else {
      System.out.println("Test: " + testIndex);
      System.out.println(testName);
      System.out.println("Fail");
      System.out.println("---------------");
    }
  }
}

public class Gamer extends FunGame {

  /**
   * Main.
   * Bellow are the tests
   * @param args - command line input
   */
  public static void main(final String[] args) {
    /*
     * Game attributes:
     *  - description
     *  Board Game attributes:
     *  - number of players
     *  - allow tie [yes/no]
     * Fun Game attributes
     *  - min number of players
     *  - max number of players
     *  - time limit for the game
     */

    final String description = "New board game";
    final int players = 4;
    final String allow = "yes";
    final int minNumber = 2;
    final int maxNumber = 4;
    final int time = 1;

    FunGame playGame = new FunGame(
      description,
      players,
      allow,
      minNumber,
      maxNumber,
      time
    );

    // Test#1
    final String returnedDesc = playGame.toString();
    final String expectDesc = "description: New board game";
    if (expectDesc.equals(returnedDesc)) {
      System.out.println("Test: 1");
      System.out.println("Testing setting the description");
      System.out.println(returnedDesc);
      System.out.println("Success");
      System.out.println("---------------");
    }
    // Test#2
    int testIndex = 2;
    final int returnedMin = playGame.getMinPlayers();
    TestRunnerGame runTest1 = new TestRunnerGame(
      "getMinPlayers should return 2",
      returnedMin,
      minNumber,
      testIndex
    );
    runTest1.runner();

    // Test#3
    final int index = 3;
    final int returnedMax = playGame.getMaxPlayers();
    TestRunnerGame runTest2 = new TestRunnerGame(
      "getMaxPlayers should return 4",
      returnedMax,
      maxNumber,
      index
    );
    runTest2.runner();

    // Test#4
    final int indexTest = 4;
    final int returnedTime = playGame.getTime();
    TestRunner runTest3 = new TestRunner(
      "getTime should return 20",
      returnedTime,
      time,
      indexTest
    );
    runTest3.runner();

    // Test#5
    final String returnedAllowTie = playGame.getAllowTie();
    if (returnedAllowTie.equals(allow)) {
      System.out.println("Test: 5");
      System.out.println("getAllowTie should return 'yes'");
      System.out.println(returnedAllowTie);
      System.out.println("Success");
      System.out.println("---------------");
    }

    // Test#6
    final String setToNo = "no";
    playGame.setAllowTie(setToNo); // set to no
    final String returnedAllowTieNo = playGame.getAllowTie();
    if (returnedAllowTieNo.equals(setToNo)) {
      System.out.println("Test: 6");
      System.out.println("setAllowTie should return 'no'");
      System.out.println(returnedAllowTieNo);
      System.out.println("Success");
      System.out.println("---------------");
    }
    // Test#7

    final String secondDescription = "Another board game";
    final int secondPlayers = 10;
    final String allowTie = "no";
    final int secondMinNumber = 2;
    final int secondMaxNumber = 4;
    final int secondTime = 10;

    FunGame newGame = new FunGame(
      secondDescription,
      secondPlayers,
      allowTie,
      secondMinNumber,
      secondMaxNumber,
      secondTime
    );

    final String newString = newGame.toString();
    final int getNewPlayers = newGame.getPlayers();
    System.out.println("Test: 7");
    System.out.println("It should print error for exceeding max num");
    System.out.println(
      "New Players " + getNewPlayers + " > " + secondMaxNumber + " Max Num"
    );

    System.out.println("Success");
    System.out.println("---------------");
  }
}
// End
