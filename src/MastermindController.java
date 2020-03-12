/**
 * 
 * @author Thomas Lochner
 *
 */
public class MastermindController {
	
	private MastermindModel model;
	private boolean[] alreadyCounted;
	
	public MastermindController(MastermindModel model) {
		this.model = model;
		this.alreadyCounted = new boolean[4];
	}
 
	/**
     * This method tells us whether or not the guess was correct.
     * 
     * @param guess The guess from the user.
     * 
     * @return True/false whether or not the guess was correct.
     */
    public boolean isCorrect(String guess) {
    	// If all chars are right, then it is correct.
    	if (model.getColorAt(0) == guess.charAt(0) && model.getColorAt(1) == guess.charAt(1) && model.getColorAt(2) == guess.charAt(2) && model.getColorAt(3) == guess.charAt(3)) {
    		return true;
    	} else {
    		return false;
    	}
    }


    /**
     * This method calculates the amount of correct colors in their correct places.
     * 
     * @param guess The guess from the user.
     * 
     * @return The amount of correct colors in their correct places.
     */
    public int getRightColorRightPlace(String guess) { 
    	int rightColorsRightPlace = 0;
    	
    	// Iterate through the guess and answer at the same time. If one of them match up, count it and mark it as counted.
    	for (int i = 0; i < 4; i++) {
    		if (model.getColorAt(i) == guess.charAt(i)) {
    			rightColorsRightPlace++;
    			alreadyCounted[i] = true;
    		}
    	}
    	return rightColorsRightPlace;
    }

    /**
     * This method calculates the amount of correct colors in the incorrect place.
     * 
     * @param guess The guess from the user.
     * 
     * @return The amount of correct colors in the incorrect place.
     */
    public int getRightColorWrongPlace(String guess) {
    	int rightColorsWrongPlace = 0;
    	
    	// Iterate through the guess.
    	for (int i = 0; i < 4; i++) {
    		if (!this.alreadyCounted[i]) {
    			
    			// Iterate through the answer.
    			for (int j = 0; j < 4; j++) {
    				
    				// If any chars in the answer are the current char being looked at (i), and it has not been counted
    				// (accounted for in the if statement above), then it is the right color in the wrong place.
    				if (model.getColorAt(j) == guess.charAt(i)) {
    					rightColorsWrongPlace++;
    				}
    			}
    		}
    	}
    	
    	// Reset the alreadyCounted array for the next time around.
    	this.alreadyCounted = new boolean[4];
    	return rightColorsWrongPlace;
    }
}
