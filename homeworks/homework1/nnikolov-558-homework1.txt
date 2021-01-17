# Homework 1
* ECE558
* Nikolay Nikolov
* Winter 2021
* Prof. Roy Kravitz

## Question 2: Java Basics

### a)

#### Source code: 
```java

/**
 * Nikolay Nikolov ECE558 Winter 2021
 * <h2>Question 2 a)
 * <h2>Write a method that takes an integer input from the user, then prompts
 * for additional integers and prints all of the integers that are greater than
 * or equal to the original input until the user enters a negative number, which
 * is not printed
 */

import java.io.*;
import java.util.*;

public class Homework1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int[] previousNumbers = new int[100]; // store the user's previous numbers
		int index = 0;
		int originalInput = -1; 
		// ---------------------
		while (true){
			System.out.println("Type a number.Negative number will make me exit");
			// Get user input
			int userNumber = Integer.parseInt(scanner.nextLine());
			// if the number is negative exit
			if(userNumber < 0 ){
				System.out.println("Goodbye!");
				System.exit(-1);
			}
			else {
				// The very first time the App is running
				if (originalInput < 0){
					originalInput = userNumber;
				}
				// Store numbers in array
				previousNumbers[index] = userNumber;
				// Print numbers >= originalInput
				for (int i = 0; i < previousNumbers.length; i++)
				{
					if (previousNumbers[i] >= originalInput ) 
					{
						System.out.println("[ " + previousNumbers[i] + ">=" + originalInput + " ]");
					}
				}
				// increment index for the array of previous numbers
				index = index + 1;
			}
		}
		// ------------------------
		// While loop ends here
	}

}

```

#### Traces from testing:

```
[niko@toolbox homework1]$ java Homework1
Type a number.Negative number will make me exit
9
[ 9>=9 ]
Type a number.Negative number will make me exit
1
[ 9>=9 ]
Type a number.Negative number will make me exit
0
[ 9>=9 ]
Type a number.Negative number will make me exit
10
[ 9>=9 ]
[ 10>=9 ]
Type a number.Negative number will make me exit
3
[ 9>=9 ]
[ 10>=9 ]
Type a number.Negative number will make me exit
11
[ 9>=9 ]
[ 10>=9 ]
[ 11>=9 ]
Type a number.Negative number will make me exit
12
[ 9>=9 ]
[ 10>=9 ]
[ 11>=9 ]
[ 12>=9 ]
Type a number.Negative number will make me exit
13
[ 9>=9 ]
[ 10>=9 ]
[ 11>=9 ]
[ 12>=9 ]
[ 13>=9 ]
Type a number.Negative number will make me exit
-1
Goodbye!

```


### b ) 

#### 1 ) The following code sequence is intended to print Hello three times; however, it
only prints Hello once. Where is the problem in this code sequence?

*Original Code*  

```java

public static void main(String[] args);
for (int i = 0; i < 3; i++){ 
	System.out.println("Hello");

}

```

* Removing the semicolon. With the simicolon, it runs 3 loops and then prints

#### Modified Code 

```java

public class Homework1_2b_1 {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++){ 
			System.out.println("Hello");
		}

	}

}

```
#### Traces:

```java

[niko@toolbox homework1]$ java Homework1_2b_1
Hello
Hello
Hello
[niko@toolbox homework1]$ 

```

#### 2) You coded the following in class Hw1.java:
int a = 32, b = 10;
double c = a / b;
System.out.println(“The value of c is “ + c);
You expected the value of c to be 3.2, but instead c was displayed as 3. Explain
what the problem is and write the code to fix it.

The problem is that a and b are integers

#### Correct code:

```java
public static void main(String[] args) {
	double a = 32, b = 10;
	double c = a / b;  
	System.out.println("The value of c is " + c);         

}

```

#### Traces:

```java
[niko@toolbox homework1]$ java Homework1_2b_2
The value of c is 3.20
```


#### 3) 

You coded the following:
int[][] a = {{9,8,7,6},{10,20,30,40}};
for (int j = 0, j <= a[1].length; j++) {
	if (a[ 1 ][j] == 20) {
		System.out.println(“Found 20 at column index “ + j +
				+ “ of second row”);
	}
}
The code compiles properly, but when you run the program you get the following
output:
Found 20 at column index 1 of second row
Exception in thread “main”
	java.lang.ArrayIndexOutOfBoundsException: 4 at
Test.main(Test.java:14)

* In order the code to work we need to remove the '[1]'. Since the length of a is 2 not 4. 

```java
	Correct Code: 

	public static void main(String[] args) {
		int[][] a = {{9,8,7,6},{10,20,30,40}};
		for (int j = 0; j <= a.length; j++) {   
			System.out.println("a[1].length is" + a[1].length);
			System.out.println("a.length is" + a.length);

			if (a[ 1 ][j] == 20) {
				System.out.println("Found 20 at column index " + j + " of second row");                                                                  
			}
		}

	}

```

#### Traces:

```java

[niko@toolbox homework1]$ java Homework1_2b_3
a[1].length is4
a.length is2
a[1].length is4
a.length is2
Found 20 at column index 1 of second row
a[1].length is4
a.length is2

```

### Question 3:

#### Source Code

```java
Rational.java

[niko@toolbox homework1]$ cat Rational.java 
/**
 * Class Rational.
 * Nikolay Nikolov
 * ECE558 Winter 2021
 *
 */

class Rational {

  /*
   * This is the object
   * for the rational number
   */
  // ---------------------------------
  /**
   * Private attribute numerator for class Rational.
   * this is the numerator
   */
  private double num;

  /**
   * Private attribute denominator for class Rationa.
   */
  private double den = 1;

  // constructor
  Rational() {
    // First constructor
  }

  // constructor
  Rational(final double numerator, final double denominator) {
    if (denominator == 0) {
      System.err.println("Error.Denominator cannot be zero");
    }
    this.num = numerator;
    this.den = denominator;
  }

  // Getter Numerator
  public double getNumerator() {
    return num;
  }

  // Setter Numerator
  public double setNumerator(final double newNumerator) {
    this.num = newNumerator;
    return this.num;
  }

  // Getter Denominator
  public double getDenominator() {
    return den;
  }

  // Setter Denominator
  public double setDenominator(final double newDenominator) {
    this.den = newDenominator;
    return this.den;
  }

  // Equals()
  public boolean equals() {
    final double frac = 0.001;
    if (frac == (Math.abs(num / den))) {
      return true;
    }
    return false;
  }

  // toString()
  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append("Numerator   = ");
    buf.append(num);
    buf.append("\n");
    buf.append("Denominator = ");
    buf.append(den);
    buf.append("\n");
    return buf.toString();
  }

  // multiplication of two rational numbers
  public double multiply() {
    return (num * den);
  }

  // addition of two rational numbers
  public double sum() {
    return (num + den);
  }
}
// End

```

#### Testing the Rational.java
```java

[niko@toolbox homework1]$ cat ClientRational.java 
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

```
#### Traces from testing 

```text

[niko@toolbox homework1]$ java ClientRational
Test: 1
sum should return 6 when num = 1 and den = 5
Success
---------------
Test: 2
multiply should return 5 when num = 1 and den = 5
Success
---------------
Test: 3
Testing toString()
Numerator   = 1.0
Denominator = 5.0

Success
---------------
Test: 4
Testing setting the Numerator to 15
Numerator   = 15.0
Denominator = 5.0

Success
---------------
Test: 5
Testing setting the Denominator to 20
Numerator   = 15.0
Denominator = 20.0

Success
---------------
[niko@toolbox homework1]$ 

```

## Question 4
