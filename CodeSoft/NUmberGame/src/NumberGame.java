import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args)  {
        Scanner input =new Scanner(System.in);
        Random random = new Random();//Random class is invoked to generate random numbers
        int totalAttempts=0;
        int totalRoundWon=0;

        while (true) {
            int randomNumber = random.nextInt(100) + 1;
            int tryCount = 0;
            int choice;
            int max_chances =8;// By default, it is Easy (8 chances)
            while (true) {
                System.out.println("Choose Difficulty \n1.Easy\t2.Medium\t3.Hard");
                try {
                    choice = input.nextInt();
                    if (choice == 1 || choice == 2 || choice == 3) {
                        break; // Exit the loop if the input is valid
                    } else {
                        System.out.println("Enter a valid Choice (1, 2, 3) :)");
                    }
                } catch (java.util.InputMismatchException e) {
                    input.next(); // Clear the input buffer
                    System.out.println("Enter a valid Choice (1, 2, 3) :)");
                }
            }

            if(choice == 2){
                max_chances =5;//Medium
            }else if(choice == 3){
                max_chances=3;//Hard
            }

            int i = 0;
            int flag=0;//To ensure Won or Not
            while (i < max_chances) {

                System.out.println("Enter the guess(1-100):");
                int guessNumber = input.nextInt();
                tryCount++;
                if (randomNumber == guessNumber) {
                    System.out.println("Congratulations!!You have won!!!At " + tryCount + " attempt");
                    totalRoundWon++;
                    flag=1;
                    break;
                } else if (guessNumber > randomNumber) {
                    System.out.println("Nope!The Guess is higher.Guess again");
                } else {
                    System.out.println("Nope!The Guess is lesser.Guess again");
                }
                i++;
            }
            if(flag == 0) {
                System.out.println("Ops! You Lost. The correct number was " + randomNumber);
            }
            totalAttempts++;
            System.out.println("Wanna try once again?(Yes for 1 or No for 0):");
            int round=input.nextInt();
            if (round == 0) break;//GameOver
        }
        System.out.println("Number of Rounds won "+ totalRoundWon);
        System.out.println("Number of Attempts "+totalAttempts);
        input.close();
    }
}