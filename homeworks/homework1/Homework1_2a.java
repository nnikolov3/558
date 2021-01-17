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

public class Homework1_2a {
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
// End
