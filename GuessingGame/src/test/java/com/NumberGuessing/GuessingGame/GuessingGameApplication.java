package com.NumberGuessing.GuessingGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class GuessingGameApplication {

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        boolean continuePlaying = true;

        while (continuePlaying) {
            Random random = new Random ( );
            int targetNumber = random.nextInt ( 100 ) + 1;
            int attempts = 0;
            boolean isCorrectGuess = false;

            System.out.println ( "RandomNumber = " + targetNumber );
            System.out.println ( "Welcome to the Number Guessing Game!" );
            System.out.println ( "You have 5 chances to guess the number." );
            System.out.println ( "The number ranges from 1 to 100." );

            while (attempts < 5 && !isCorrectGuess) {
                System.out.println ( "Attempt " + (attempts + 1) + ":" );
                System.out.print ( "Enter your guess: " );
                int guess = scanner.nextInt ( );
                attempts++;

                if ( guess == targetNumber ) {
                    System.out.println ( "Congratulations! You've guessed the correct number in " + attempts + " tries." );
                    isCorrectGuess = true;
                } else {
                    if ( attempts < 5 ) {
                        System.out.println ( "Incorrect guess. Here are some clues:" );
                        if ( targetNumber % 2 == 0 ) {
                            System.out.println ( "Hint: The number is even." );
                        } else {
                            System.out.println ( "Hint: The number is odd." );
                        }

                        if ( guess < targetNumber ) {
                            System.out.println ( "Hint: The number is higher than your guess." );
                        } else {
                            System.out.println ( "Hint: The number is lower than your guess." );
                        }

                        for ( int i = 1 ; i <= 9 ; i++ ) {
                            if ( targetNumber % i == 0 ) {
                                System.out.println ( "Hint: The number is a multiple of " + i + "." );
                            }
                        }
                    }
                }
            }

            if ( !isCorrectGuess ) {
                System.out.println ( "Sorry! You've used all 5 attempts. The correct number was " + targetNumber + "." );
            }

            System.out.print ( "Would you like to play again? (yes/no): " );
            String response = scanner.next ( );
            if ( !response.equalsIgnoreCase ( "yes" ) ) {
                continuePlaying = false;
                System.out.println ( "Thank you for playing the Number Guessing Game!" );
            }
        }
        scanner.close ( );
    }
}