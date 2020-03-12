import java.util.Random;

/**
 * 
 * @author Thomas Lochner
 *
 */
public class MastermindModel {
	
	private String answer;
	
    public MastermindModel() {
    	// Make a char array with the possible color choices.
    	char[] colors = "roygbp".toCharArray();
    	StringBuilder answer = new StringBuilder(4);
    	Random random = new Random();
    	
    	// Choose a random color from our choices and append it to our new answer.
    	for (int i = 0; i < 4; i++) {
    	    char c = colors[random.nextInt(colors.length)];
    	    answer.append(c);
    	}
    	
    	// Set the answer!
    	this.answer = answer.toString();
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution.
     */
    public MastermindModel(String answer) {
    	this.answer = answer;
    }

    /**
     * This method gets a color at a certain index in the answer.
     * 
     * @param index The index of the color we want.
     * 
     * @return The char of the color at the specified index.
     */
    public char getColorAt(int index) {
          return answer.charAt(index);
    }
}
