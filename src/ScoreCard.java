/**
 * The scorecard is a class that keeps track of how many points the player
 * has accumulated in each category, as well as subtotals, bonuses and totals.
 */
public class ScoreCard {
    // you might find this handy - strings for the category, all of the same length.
	// The "final" keyword means that this variable is a constant - you can't change 
	//     it while the program is running.
	private final String[] categories = {"ONES       ",
										 "TWOS       ",
										 "THREES     ",
										 "FOURS      ",
										 "FIVES      ",
										 "SIXES      ",
										 "3 OF A KIND",
										 "4 OF A KIND",
										 "FULL HOUSE ",
										 "SM STRAIGHT",
										 "LG STRAIGHT",
										 "CHANCE     ",
										 "YAHTZEE    "};
	/* these "public static final" variables are constants I think you might find handy, 
		since the numbers for the categories in the list above aren't really intuitive!
		In this class, you can refer to the variable directly, e.g. "categoryIsEmpty(TWOS)".
		In other classes, you'll need to put the name of the class first, as in 
		theScoreCard.getScoreForCategory(ScoreCard.YAHTZEE);
		See the ScoreCardTest for an example.
		TL;DNR: these are CODE NUMBERS for the various categories.
	*/
	public static final int ONES = 0;
	public static final int TWOS = 1;
	public static final int THREES = 2;
	public static final int FOURS = 3;
	public static final int FIVES = 4;
	public static final int SIXES = 5;
	public static final int THREE_OF_A_KIND = 6;
	public static final int FOUR_OF_A_KIND = 7;
	public static final int FULL_HOUSE = 8;
	public static final int SMALL_STRAIGHT = 9;
	public static final int LARGE_STRAIGHT = 10;
	public static final int CHANCE = 11;
	public static final int YAHTZEE = 12;
	
	
	// TODO: decide which private member variables ScoreCard should have and create them here. ******DONE*******

	private final int[] myScores;
	private boolean topBonus;


	/**
	 * constructor - set up an empty scorecard.
     * Suggestion: start all scores as -1, since it is possible that the user
     * might choose to put a zero in a category as his/her move.
 	 */
	public ScoreCard()
	{
		//--------------------
		// TODO: insert your code here. ******DONE*******

		myScores = new int[13];
		myScores[ONES] = -1; // settting the score for Ones
		myScores[TWOS] = -1; // setting the score for TWOS
		myScores[THREES] = -1; // setting the score for THREES
		myScores[FOURS] = -1; // setting the score for FOURS
		myScores[FIVES] = -1; // setting the score for FIVES
		myScores[SIXES] = -1; // setting the score for SIXES
		myScores[THREE_OF_A_KIND] = -1; // setting the score for THREE_OF_A_KIND
		myScores[FOUR_OF_A_KIND] = -1; // setting the score for FOUR_OF_A_KIND
		myScores[FULL_HOUSE] = -1; // setting the score for FULL_HOUSE
		myScores[SMALL_STRAIGHT] = -1; // setting the score for SMALL_STRAIGHT
		myScores[LARGE_STRAIGHT] = -1; // setting the score for LARGE_STRAIGHT
		myScores[CHANCE] = -1; // setting the score for CHANCE
		myScores[YAHTZEE] = -1; // setting the score for YAHTZEE


		topBonus = false;
//		yahtzeeBonus = false;
//		extraYahtzees = 0;


		
		//--------------------
	}
	
	/** 
	 * categoryIsEmpty - returns whether the user can choose this category.
	 * @param category - which category (number?) we want
	 * @return whether (true/false) this category can be chosen by the user to enter a number. 
	 */
	public boolean categoryIsEmpty(int category)
	{
		boolean empty = true;
		boolean filled = false;
		//--------------------
		// TODO: insert your code here. ******DONE*******

        if (myScores[category] < 0) {
            return empty;
        }
		else{
			return filled;
		}
	}
	
	/**
	 * setScoreForCategory - put the given score into the given category
	 * @param score
	 * @param category - which category (number?) to put this score into
	 */
	public void setScoreForCategory(int score, int category)
	{
		//--------------------
		// TODO: insert your code here. ******DONE*******

		myScores[category] = score;

		//--------------------
	}
	
	/**
	 * getScoreForCategory - returns the score currently listed in the given category
	 *  @param category - which category (number?) we want
	 *  @return the score stored in that category
	 */
	public int getScoreForCategory(int category)
	{
		//--------------------
		// TODO: insert your code here. ******DONE*******
		return myScores[category];


	}
	/**
	 * accessor for the subtotal of all the numbered fields (without the bonus).
	 * (Note: -1 counts as zero!)
	 * @return the subtotal of ones, twos, threes, fours, fives, and sixes. 
	 */
	public int getTopSubtotal()
	{
		int subtotal = 0;
		//--------------------
		// TODO: insert your code here. ******DONE*******

		for (int i = 0; i < myScores[THREE_OF_A_KIND]; i++){
			if (myScores[i] < 0){
				subtotal = subtotal;
			}
			else{
				subtotal = subtotal + myScores[i];
			}
		}
		
		//--------------------
		return subtotal;
	}
	/**
	 * accessor for the subtotal of all the poker-hand fields
	 * (Note: -1 counts as zero!)
	 * @return the subtotal of threeOfKind, fourOfKind, fullHouse, smallStr, lrgStr, chance, yahtzee
	 */
	public int getBottomSubtotal()
	{
		int subtotal = 0;
		//--------------------
		// TODO: insert your code here. ******DONE*******
		for (int i = 6; i < (myScores.length -1); i++){
			if (myScores[i] < 0){
				subtotal = subtotal;
			}
			else{
				subtotal = subtotal + myScores[i];
			}
		}

		//--------------------
		return subtotal;		
	}
	/**
	 * determines the bonus found in the top section.
	 * @return 35, if top >= 63; zero otherwise.
	 */
	public int getTopBonus()
	{
		int bonus = 35;
		int noBonus = 0;
		//--------------------
		// TODO: insert your code here. ******DONE*******

		if (this.getTopSubtotal() >= 63){
			topBonus = true;
			return bonus;
		}
		else{
			topBonus = false;
			return noBonus;
		}
		
		//--------------------
	}

//	/**
//	 * Checks to see if the extra Yahtzee points are able to start adding up/ you got two or more extra Yhatzees.  the bonus found by extra Yahtzees calculated at the end of the section.
//	 *
//	 * @return the total number of points when roll extra Yahtzee afetr the innitail Yhatzee.
//	 */
//	public boolean checkYahtzeeBonus()
//	{
//
//			return true;
//		}
//
//
//
//
//
//
//		//--------------------
//	}
	
	public int getTotal()
	{
		int total = 0;
		//--------------------
		// TODO: insert your code here. ******DONE*******
		for (int i = 0; i < (myScores.length -1); i++){
			if (myScores[i] < 0){
				total = total;
			}
			else{
				total = total + myScores[i];
			}
		}
		if (topBonus){
			total = total + 35;
		}
		
		//--------------------
		return total;
	}
	

	
	/**
	 * toString - returns a listing of the card, as it would appear in the
	 * game.
	 * @return a string containing the card to display.
	 * Suggested: Precede the categories with letters, so that the user can
	 * easily choose them:
	 * A ONES           3
	 * B TWOS           -
	 * C THREES         12
	 * D FOURS          -
	 * E FIVES          0
	 * etc.
	 */
	public String toString()
	{
		String result = " " + "\n";
		int currentTotal = 0;
		//--------------------
		// TODO: insert your code here.

		for (int x = 0; x < (myScores.length); x = x + 1)
		{
			if (myScores[x] < 0)
			{
				result = result + categories[x] + "\t" + "-" + "\n";
			}
			else{
				result = result + categories[x] + "\t" + myScores[x] + "\n";
				currentTotal = currentTotal + myScores[x];
			}
		}
		if (topBonus){
			currentTotal = currentTotal + 35;
		}
		result = result + "TOTAL      " + "\t" + currentTotal + "\n";



		
		//--------------------
		return result;
	}
	
}
