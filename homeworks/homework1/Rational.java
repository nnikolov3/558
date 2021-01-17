/**
 * Nikolay Nikolov ECE558 Winter 2021
 * <h2>Question 3 <h2>
 An integer representing the numerator of the rational number
 An integer representing the denominator of the rational number

 a)
 Define the class and write two constructors for the class, the first constructor being a
 default (no parameters) constructor and the second constructor being a fully qualified
 constructor (parameters for numerator and denominator). Make use of the setters you
 are going to write in part b.
//-------------------------------------- 

b)
Write getters and setters for your instance variables. You should not allow the value
of the denominator to be 0; instead, give the denominator a default value of 1.
// -------------------------------------
c)
Write toString() and equals() methods for your class. The equals() method
should check if the difference between the fractional results (numerator/denominator)
is < 0.001.
// -----------------------------------

d) 
[10] Write two additional methods for your class. The first method should perform a
multiplication of two rational numbers and the second method should perform an
addition of two rational numbers. Both methods should return a rational number. Keep
in mind, that these two methods are the API for your rational number class so, in effect
you are performing math on the rational number encapsulated in the object and a
second rational number. That is, the signature for the multiplication method is:
public Rational multiply( Rational r ){};x
The Wikipedia article lists the equations for performing these operations.

*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Rational {
	// attribute
	private double num;
	private double den = 1;

	// constructor
	public	Rational() {
	}

	// constructor
	public Rational(double numerator, double denominator) {
		if(denominator == 0) {
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
	public double setNumerator(double newNumerator) {
		this.num = newNumerator;
		return this.num;
	}

	// Getter Denominator
	public double getDenominator () {
		return den;
	}

	// Setter Denominator
	public double setDenominator (double newDenominator){
		this.den = newDenominator;
		return this.den;
	}

	// Equals()
	public boolean equals() {
		double frac = 0.001;
		if (frac == (Math.abs(num/den))){
			return true;
		}
		return false;
	}

	// toString()
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append( "Numerator   = " );  buf.append( num );  buf.append( "\n" );
		buf.append( "Denominator = " );  buf.append( den );  buf.append( "\n" );
		return buf.toString();
	}

	// multiplication of two rational numbers
	public double multiply (){
		return (num * den);
	}

	// addition of two rational numbers
	public double sum (){
		return (num + den);
	}

}

// End
