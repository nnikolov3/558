/**
 * Nikolay Nikolov ECE558 Winter 2021
 * <h2>Question 3 </h2>
 *
 */

import java.io.*;
import java.util.*;

class TestRunner {

  // Simple Test Runner
  private double returnedValue;
  private double expectedValue;
  private int testIndex;
  private String testName;

  // constructor
  public TestRunner(String _name, double _ret, double _exp, int _index) {
    this.testName = _name;
    this.returnedValue = _ret;
    this.expectedValue = _exp;
    this.testIndex = _index;
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

  // main
  public static void main(String[] args) {
    // Test#1
    Rational ratObj = new Rational(1, 5);
    double sum = ratObj.sum();
    TestRunner runTest1 = new TestRunner(
      "sum should return 6 when num = 1 and den = 5",
      sum,
      6,
      1
    );
    runTest1.runner();
    // Test#2
    double multiply = ratObj.multiply();
    TestRunner runTest2 = new TestRunner(
      "multiply should return 5 when num = 1 and den = 5",
      multiply,
      5,
      2
    );
    runTest2.runner();
    // Test#3
    String returnedString = ratObj.toString();
    String expectedString = "Numerator   = 1.0\n" + "Denominator = 5.0\n";
    if (returnedString.equals(expectedString) == true) {
      System.out.println("Test: 3");
      System.out.println("Testing toString()");
      System.out.println(returnedString);
      System.out.println("Success");
      System.out.println("---------------");
    }
  }
}
// End
