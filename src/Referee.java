import java.util.Scanner;
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
	//true and false are two different players
	private int currentPlayer = 0;

	private Scanner myScanner;
	private int turnCounter = 0;

	
	/**
	 * constructor - set up the Referee class
	 */
	public Referee()
	{
		//--------------------
		// TODO: insert your code here.
		myScanner= new Scanner(System.in);

		myScoreCards= new ScoreCard[2];
		myScoreCards[0]= new ScoreCard();
		myScoreCards[1] = new ScoreCard();
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
	public void playGame(){
		System.out.println("Welcome to Yahtzee");
		playTurn();
	}
	public void playTurn()
	{
		rollAllDice();
		int rolls_left = 2;
		System.out.println("It is P"+ (currentPlayer+1)+ "'s turn");
		while (rolls_left>=0) {

			displayBoardAndDice();
			rolls_left--;
			if (rolls_left>0) {
				System.out.println("These are your dice, type 1 if you would like to reroll " +
						"some dice and type 2 if you would like to score your dice");
				int player_choice = myScanner.nextInt();
				if (player_choice == 1) {
					System.out.println("Which dice would you like to reroll, " +
							"please put all of the letters you would like to reroll with no commas or spaces");
					rollDice(myScanner.nextLine());

				}
				if (player_choice == 2) {
					boolean categoryPicked= false;
					while(!categoryPicked){
						System.out.println("Here is your scorecard: "+ myScoreCards[currentPlayer].toString());
						System.out.println("Which row would you like to fill, put a number 0-12");
						int category = myScanner.nextInt();
						if(!myScoreCards[currentPlayer].categoryIsEmpty(category)){
							System.out.println("You got "+ theBoard.getScoreForCategory(category)+ " points");
							myScoreCards[currentPlayer].setScoreForCategory(theBoard.getScoreForCategory(category),category);
							categoryPicked=true;
						} else if (myScoreCards[currentPlayer].categoryIsEmpty(category)) {
							System.out.println("sorry that row is already filled");
						}
					}

				}
			}
		}

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
