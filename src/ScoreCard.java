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
	
	
	// TODO: decide which private member variables ScoreCard should have and create them here.

	private int upperSectionTotal = -1;
	private int lowerSectionTotal = -1;
	private int grandTotal = -1;

	private int[] myScores;

	/**
	 * constructor - set up an empty scorecard.
     * Suggestion: start all scores as -1, since it is possible that the user
     * might choose to put a zero in a category as his/her move.
 	 */
	public ScoreCard()
	{
		//--------------------
		// TODO: insert your code here.

		int myAceCount = -1;
		int myTwosCount = -1;
		int myThreesCount = -1;
		int myFoursCount = -1;
		int myFivesCount = -1;
		int mySixesCount = -1;
		int upperSectionBonusTotal = 0;
		int [] upperSectionValues = new int[6];
		upperSectionValues[0] = myAceCount;
		upperSectionValues[1] = myTwosCount;
		upperSectionValues[2] = myThreesCount;
		upperSectionValues[3] = myFoursCount;
		upperSectionValues[4] = myFivesCount;
		upperSectionValues[5] = mySixesCount;

		for (int i = 0; i <upperSectionValues.length; i++)
		{
			if (upperSectionValues[i] >= 0)
			{
				upperSectionTotal = upperSectionTotal + upperSectionValues[i];
			}
		}

		if (upperSectionTotal >= 63)
		{
			upperSectionBonusTotal = 35;
		}


		int my3OfAKind = -1;
		int my4OfAKind = -1;
		int myFullHouse = -1;
		int mySMStraight = -1;
		int myLGStraight = -1;
		int myYahtzee = -1;
		int myChance = -1;
		int yahtzeeBonusTotal = 0;
		int numOfYahtzeeBonuses = -1;
		int [] lowerSectionValues = new int[7];
		lowerSectionValues[0] = my3OfAKind;
		lowerSectionValues[1] = my4OfAKind;
		lowerSectionValues[2] = myFullHouse;
		lowerSectionValues[3] = mySMStraight;
		lowerSectionValues[4] = myLGStraight;
		lowerSectionValues[5] = myYahtzee;
		lowerSectionValues[6] = myChance;

		for (int x = 0; x < lowerSectionValues.length; x++)
		{
			if (upperSectionValues[x] >= 0)
			{
				this.lowerSectionTotal = this.lowerSectionTotal + lowerSectionValues[x];
			}
		}



		this.lowerSectionTotal = myAceCount + myTwosCount + myThreesCount + myFoursCount + myFivesCount + mySixesCount;
		this.lowerSectionTotal

		
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
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
		return empty;
	}
	
	/**
	 * setScoreForCategory - put the given score into the given category
	 * @param score
	 * @param category - which category (number?) to put this score into
	 */
	public void setScoreForCategory(int score, int category)
	{
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
	}
	
	/**
	 * getScoreForCategory - returns the score currently listed in the given category
	 *  @param category - which category (number?) we want
	 *  @return the score stored in that category
	 */
	public int getScoreForCategory(int category)
	{
		int response = -1;
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
		return response;
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
		// TODO: insert your code here.
		
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
		// TODO: insert your code here.
		
		//--------------------
		return subtotal;		
	}
	/**
	 * determines the bonus found in the top section.
	 * @return 35, if top >= 63; zero otherwise.
	 */
	public int getTopBonus()
	{
		int bonus = 0;
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
		return bonus;
	}
	
	public int getTotal()
	{
		int total = 0;
		//--------------------
		// TODO: insert your code here.
		
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
		String result = "";
		//--------------------
		// TODO: insert your code here.
		
		//--------------------
		return result;
	}
	
}
