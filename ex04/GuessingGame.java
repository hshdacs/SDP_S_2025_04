package ex04;

import java.util.Scanner;

public class GuessingGame {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int secretNumber = (int)(10_000 * Math.random());
        //System.out.println("DEBUG: " + secretNumber);

        while (true) {
            System.out.print("Enter your guess: ");
            int tipp = input.nextInt();

            if (tipp == 0) {
                System.out.println("Oh, we're sorry!");
                System.out.println("The secret number was " + secretNumber);
                break;
            }

            if (tipp == secretNumber) {
                System.out.println("Yeah, you did it!!!");
                break;
            }
        }
    }
}
