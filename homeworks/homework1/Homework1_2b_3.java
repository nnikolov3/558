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

public class Homework1_2b_3 {

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

}
// End
