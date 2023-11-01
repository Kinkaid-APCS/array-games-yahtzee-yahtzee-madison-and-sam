import java.util.InputMismatchException;
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
		theBoard = new Board();
		//--------------------
	}
	
	/**
	 * roll all the dice at once, as in the start of a new turn.
	 */
	public void rollAllDice()
	{
		// I've written this one for you. ;^)
		rollSelectedDice("ABCDE");
	}
	
	/**
	 * roll some dice, as indicated
	 *  - a string that indicates which dice to roll. For instance,
	 * "ADE" would mean to roll die A, die D and die E, without changing die B or 
	 * die C.
	 */
	public void rollSelectedDice(String stringToParse)
	{
		// I'm starting this one for you, since we haven't been splitting strings yet.
		for (int i=0; i<stringToParse.length(); i++) // loop one letter at a time....
		{
			String letter = stringToParse.substring(i, i+1);
			// so now "letter" is one of the letters in the string.
			// TODO: write code here to look at "letter" and based on it,
			//       decide whether to re-roll one of the dice.
			if(letter.equals("A")){
				rollDice("A");
			}
			if(letter.equals("B")){
				rollDice("B");
			}
			if(letter.equals("C")){
				rollDice("C");
			}
			if(letter.equals("D")){
				rollDice("D");
			}
			if(letter.equals("E")){
				rollDice("E");
			}


		}

	}
	public void rollDice(String die){
		if(die.equals("A")){
			theBoard.setDieAtIndex(0, (int)(Math.random()*6+1));
		}
		if(die.equals("B")){
			theBoard.setDieAtIndex(1, (int)(Math.random()*6+1));
		}
		if(die.equals("C")){
			theBoard.setDieAtIndex(2, (int)(Math.random()*6+1));
		}
		if(die.equals("D")){
			theBoard.setDieAtIndex(3, (int)(Math.random()*6+1));
		}
		if(die.equals("E")){
			theBoard.setDieAtIndex(4, (int)(Math.random()*6+1));
		}
		theBoard.updateFrequencyList();
	}

	public int askForNumber()
	{
		int x = -1;
		boolean goodAnswer = false;
		while (!goodAnswer)
		{
			try
			{
				x = myScanner.nextInt();
				goodAnswer = true;
			}
			catch (InputMismatchException imExp)
			{
				System.out.println("Sorry, that is not a number, please try agin.");
				myScanner.nextLine();
			}

		}
		myScanner.nextLine();
		return x;
	}


	
	/**
	 * playGame - the main game loop for the Referee.
	 */
	public void playGame(){
		System.out.println("Welcome to Yahtzee");
		System.out.println("Here are some rules and explinations:" +"\n"+ " - You are only allowed to re-roll a dice turn 2 times" +"\n"+ " - The goal is to get the most amount of points" );
		while (turnCounter<26){
			playTurn();
			turnCounter++;
			if (currentPlayer==0){
				currentPlayer=1;
			} else if (currentPlayer==1){
				currentPlayer=0;
			}
		}
		int player1Score = myScoreCards[0].getTotal();
		int player2Score= myScoreCards[1].getTotal();
		System.out.println("That was the end of the game!");
		System.out.println("Player 1 had a score of "+ player1Score );
		System.out.println("Player 2 had a score of "+ player2Score );
		if (player1Score>player2Score){
			System.out.println("Player 1 wins!!!");
		}
		if (player2Score>player1Score){
			System.out.println("Player 2 wins!!!");
		}
		if (player1Score== player2Score){
			System.out.println(("it's a tie"));
		}




	}
	public void playTurn()
	{ 
		rollAllDice();
		int rolls_left = 2;
		System.out.println("It is Player "+ (currentPlayer+1)+ "'s turn");
		while (rolls_left>=0) {

			displayBoardAndDice();
			System.out.println("You have "+rolls_left+ " rolls left");

			if (rolls_left>0) {
				System.out.println("These are your dice, type 1 if you would like to reroll " +
						"some dice and type 2 if you would like to score your dice");
				int player_choice = askForNumber();
				//System.out.println(player_choice);
				if (player_choice == 1) {
					System.out.println("Which dice would you like to reroll, " +
							"please put all of the letters you would like to reroll with no commas or spaces");
					String myLetters = myScanner.nextLine();
					rollSelectedDice(myLetters);
					rolls_left--;

				}
				if (player_choice == 2) {
					playerScore();
					rolls_left=-1;
				}
			}
			if(rolls_left==0){
				System.out.println("That was your last roll");
				playerScore();
				rolls_left=-1;
			}
		}

		//--------------------
	}
	public void playerScore(){
		boolean categoryPicked= false;
		while(!categoryPicked){
			System.out.println("Here are your dice: ");
			displayBoardAndDice();
			System.out.println("Here is your scorecard: "+ myScoreCards[currentPlayer].toString());
			System.out.println("Which row would you like to fill, put a number 0-12");
			int category = myScanner.nextInt();
			if(myScoreCards[currentPlayer].categoryIsEmpty(category)){
				System.out.println("You got "+ theBoard.getScoreForCategory(category)+ " points");
				myScoreCards[currentPlayer].setScoreForCategory(theBoard.getScoreForCategory(category),category);
				categoryPicked=true;
			} else if (!myScoreCards[currentPlayer].categoryIsEmpty(category)) {
				System.out.println("sorry that row is already filled");
			}
		}
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
		System.out.println("+---+ +---+ +---+ +---+ +---+\n" +"| "+theBoard.getDieAtIndex(0)+ " | | " + theBoard.getDieAtIndex(1)+ " | | " + theBoard.getDieAtIndex(2)+ " | | " + theBoard.getDieAtIndex(3)+ " | | " + theBoard.getDieAtIndex(4)+ " |\n+---+ +---+ +---+ +---+ +---+");
		System.out.println("  A     B     C     D     E  ");
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
