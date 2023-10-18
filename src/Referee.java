/**
 * The Referee class is in charge of keeping track of the Board (the dice)
 * and one or two ScoreCards, depending on how many players there are. It
 * handles the interactions with the player, asking the player what to do,
 * determining whether the moves are legal, displaying the board and scorecard,
 * and updating the board and scorecard.
 *
 */
public class Referee {

	private ScoreCard[] myScoreCards; // one for each player
	private Board theBoard;
	
	/**
	 * constructor - set up the Referee class
	 */
	public Referee()
	{
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
	}
	
	/**
	 * roll all the dice at once, as in the start of a new turn.
	 */
	public void rollAllDice()
	{
		// I've written this one for you. ;^)
		rollDice("ABCDE");
	}
	
	/**
	 * roll some dice, as indicated
	 * @param diceToRoll - a string that indicates which dice to roll. For instance,
	 * "ADE" would mean to roll die A, die D and die E, without changing die B or 
	 * die C.
	 */
	public void rollDice(String diceToRoll)
	{
		// I've written this one for you, too.
		theBoard.rollSelectedDice(diceToRoll);
	}
	
	/**
	 * playGame - the main game loop for the Referee.
	 */
	public void playGame()
	{
		System.out.println("Game is playing");// placeholder code.
		//--------------------
		// TODO: insert your code here.
		// Note: I've added some methods to this class to get you
		//      started, but I suspect you will need to make some
		//      more of your own. Use this as a starting point.
				
				
		//--------------------
	}
	
	/**
	 * displayBoardAndDice - does a s.o.p. to the screen, showing
	 * the score card for the current player, the dice, and ABCDE
	 * labels for the dice.
	 */
	public void displayBoardAndDice()
	{
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
	}
	
	//-------------------------------
	// Code for debugging/testing only:
	
	public void debugSetDice(int[] inDice)
	{
		theBoard.debugSetDice(inDice[0], inDice[1], inDice[2], inDice[3], inDice[4]);
		theBoard.updateFrequencyList();
	}
	
	public int[] debugGetDice()
	{
		return theBoard.debugGetDice();
	}
	
	public int[] debugGetTotals()
	{
		return theBoard.getFrequencies();
	}
}
