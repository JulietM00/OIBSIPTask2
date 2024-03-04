
package com.game.guessinggame;

import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

public static void main (String[] arg){

System. out.println("\nHow about a game? I'll select a number between 1 and 100, and you can try to guess it." + "\nYou have 5 attempts");

Random randNum = new Random();
Scanner scan = new Scanner(System.in);
int secretnumber;
secretnumber= randNum.nextInt(100) + 1;

int attemptCount = 0;
while(true){
        System.out.println("\nTry and guess a number between 1 and 100.");

int PlayerGuess = scan.nextInt();
attemptCount++;

if (PlayerGuess == secretnumber){
    System.out.println("\nCorrect! You Win!");
System.out.println("My number is " + secretnumber);
    System.out.println("\nYou've used " + attemptCount + " attempts.");
System.out.println("\nYour score is "+((11-attemptCount)*5)+" out of 100");
break;
} else if(secretnumber > PlayerGuess){
    System.out.println("\nIncorrect! The number is high. Guess again." + attemptCount);
    System.out.println("My number is " + secretnumber);
} else{

    System.out.println("Incorrect! The number is lower. Guess again" + attemptCount);
System.out.println("My number is " + secretnumber);

}
System.out.println("\nYour score is "+((11-attemptCount)*5)+" out of 100");

}
} 
}        




