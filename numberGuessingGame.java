import java.util.Random;
import java.util.Scanner;
public class numberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String play="yes";
        int totalScore =0;

        while(play.equalsIgnoreCase("yes")){
            Random random= new Random();
            int randomNumber= random.nextInt(100)+1;// generates a number between 1 and 100
            int guess=-1;
            int attempts=0;
        
            System.out.println("*********************************");
            System.out.println("Welcome to the Number Guessing Game!!");
    


            while(guess!=randomNumber){
                System.out.println("Guess a number between 1 and 100:");
                guess=sc.nextInt();
                attempts++;

                if(guess == randomNumber){
                    System.out.println();
                    System.out.println("Congratulations! You guessed the number!");
                    System.out.println("You're a Mind Reader! ");
                    System.out.println("You guessed the number in " + attempts + " attempts..");
                   
                    int roundScore = 8 - attempts;
                    if (roundScore < 1) roundScore = 1;
                    totalScore += roundScore;

                    System.out.println("You earned " + roundScore + " points this round.");
                    System.out.println("Total Score: " + totalScore);
                }else if( guess > randomNumber){
                    System.out.println("Oops! Your guess is Too High! Try again.");
                }
                else{
                    System.out.println("Oops! Your guess is Too Low! Try again.");
                }
           }
           System.out.println("----------------------------------");
           System.out.println("Do you want to play again??(yes/no)");
           play=sc.next().toLowerCase();
         }
         System.out.println();
         System.out.println("Your final score: " +totalScore);
         System.out.println("Come back soon for another round!");
     }
}    
    

