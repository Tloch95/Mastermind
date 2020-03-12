import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author Thomas Lochner
 *
 */
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 */
	@Test
	void testIsCorrect() {
		// Create the model with a specified answer.
		MastermindModel answer = new MastermindModel("rrrr");
		
		// Create the controller with the new model.
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		// Make sure this returns true.
		assertTrue(controllerUnderTest.isCorrect("rrrr"));

		// Make sure the rest return false.
		assertFalse(controllerUnderTest.isCorrect("oooo"));
		
		assertFalse(controllerUnderTest.isCorrect("roro"));
		
		assertFalse(controllerUnderTest.isCorrect("rrro"));
		
		assertFalse(controllerUnderTest.isCorrect("orrr"));
		
		assertFalse(controllerUnderTest.isCorrect("oror"));
		
		assertFalse(controllerUnderTest.isCorrect("rroo"));
		
		assertFalse(controllerUnderTest.isCorrect("oorr"));
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		// Create the model with a specified answer.
		MastermindModel answer = new MastermindModel("rrrr");
		
		// Create the controller with the new model.
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		// Make sure all 4 correct returns 4.
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		
		// Make sure 0 correct returns 0.
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("gggg"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rygb"), 1);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rygr"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrgr"), 3);
		
		answer = new MastermindModel("pbgr");
		controllerUnderTest = new MastermindController(answer);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("yyyy"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pppp"), 1);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbpb"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrpb"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbyy"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbrr"), 3);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbro"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbor"), 3);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pbgr"), 4);
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		// Create the model with a specified answer.
		MastermindModel answer = new MastermindModel("rrrr");
		
		// Create the controller with the new model.
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oooo"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrro"), 3);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rrro"), 0);
		
		answer = new MastermindModel("royg");
		controllerUnderTest = new MastermindController(answer);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("oygr"), 0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oygr"), 4);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("rogy"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oygr"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("ryog"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oygr"), 2);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("royg"), 4);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("royg"), 0);
		
		answer = new MastermindModel("pppp");
		controllerUnderTest = new MastermindController(answer);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("yyyy"), 0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("yyyy"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pyrg"), 1);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("pyrg"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pprr"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("pprr"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pppr"), 3);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("pppr"), 0);
		
		assertEquals(controllerUnderTest.getRightColorRightPlace("pppp"), 4);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("pppp"), 0);
	}

}
