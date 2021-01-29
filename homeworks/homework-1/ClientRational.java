/**
 * Client for Rational class.
 * Nikolay Nikolov
 * ECE558 Winter 2021
 * It has a test runner
 * that make simple comparison
 * assertion like, but assertion is normally
 * locked in Java
 */

class TestRunner {

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
  TestRunner(
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

public class ClientRational extends Rational {

  /**
   * Main.
   * Bellow are the tests
   * @param args - command line input
   */
  public static void main(final String[] args) {
    // Test#1
    final int numer = 1;
    final int denom = 5;
    Rational ratObj = new Rational(numer, denom);
    double sum = ratObj.sum();
    final int expectedSum = 6;
    int testIndex = 1;
    TestRunner runTest1 = new TestRunner(
      "sum should return 6 when num = 1 and den = 5",
      sum,
      expectedSum,
      testIndex
    );
    runTest1.runner();
    // Test#2
    double multiply = ratObj.multiply();
    final int expectedMultiply = 5;
    testIndex = 2;
    TestRunner runTest2 = new TestRunner(
      "multiply should return 5 when num = 1 and den = 5",
      multiply,
      expectedMultiply,
      testIndex
    );
    runTest2.runner();
    // Test#3
    String returnedString = ratObj.toString();
    String expectedString = "Numerator   = 1.0\n" + "Denominator = 5.0\n";
    if (returnedString.equals(expectedString)) {
      System.out.println("Test: 3");
      System.out.println("Testing toString()");
      System.out.println(returnedString);
      System.out.println("Success");
      System.out.println("---------------");
    }
    // Test#4
    // Test Setter and Getter for Numerator
    final double newNumerator = 15;
    ratObj.setNumerator(newNumerator);
    final int expectedNumerator = 15;
    String expectedNewString = "Numerator   = 15.0\n" + "Denominator = 5.0\n";
    String returnedNewString = ratObj.toString();
    if (returnedNewString.equals(expectedNewString)) {
      System.out.println("Test: 4");
      System.out.println("Testing setting the Numerator to 15");
      System.out.println(returnedNewString);
      System.out.println("Success");
      System.out.println("---------------");
    }
    // Test#5
    // Test Setter and Getter for Denominator
    final double newDenominator = 20;
    ratObj.setDenominator(newDenominator);
    final int expectedDenominator = 20;
    final String expectedNewDenominator =
      "Numerator   = 15.0\n" + "Denominator = 20.0\n";
    final String returnedNewDenominator = ratObj.toString();
    if (returnedNewDenominator.equals(expectedNewDenominator)) {
      System.out.println("Test: 5");
      System.out.println("Testing setting the Denominator to 20");
      System.out.println(returnedNewDenominator);
      System.out.println("Success");
      System.out.println("---------------");
    }
  }
}
// End
