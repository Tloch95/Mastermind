/**
 * 
 * @author Thomas Lochner
 *
 */
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		System.out.println("Welcome to Mastermind!");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to play?");
		
		String wantsToPlay = scan.next();
		
		while (wantsToPlay.toLowerCase().charAt(0) == 'y') {
			
			MastermindModel mm = new MastermindModel();
			MastermindController mc = new MastermindController(mm);
			
			int numGuesses = 0;
			
			// 10 guesses.
			while (numGuesses != 10) {
				System.out.println("Enter guess number " + (numGuesses + 1) + ":");
				String guess = scan.next();
				
				if (guess.length() != 4) {
					System.out.println("Invalid string, please make sure your answer is 4 characters in length.");
					continue;
				}
				
				numGuesses++;
				
				if (mc.isCorrect(guess)) {
					System.out.println("Congratulations! You win!");
					break;
				} else {
					System.out.println("That is incorrect.\nNumber of guesses with color in correct place: " + mc.getRightColorRightPlace(guess) + "\nNumber of correct colors in incorrect position: " + mc.getRightColorWrongPlace(guess));
				}
			}
			
			// Check if they ran out of guesses as opposed to winning to exit the while loop.
			if (numGuesses == 10) {
				System.out.println("You have run out of guesses!");
			}
			
			System.out.println("Would you like to play again?");
			wantsToPlay = scan.next();
		}
		scan.close();
	}

}
