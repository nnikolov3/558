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
