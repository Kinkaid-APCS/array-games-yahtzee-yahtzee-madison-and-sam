/**
 *  This class represents the dice on the board. It allows the user to
 *  reroll certain dice, and it calculates the score for a given category.
 *  It keeps two lists - one list of the five dice, and 
 *  one that keeps track of how many of each die value are showing.
 *  In the statistics biz, this is called a "frequency count."
 *  For instance, if the dice are {1, 1, 4, 1, 4} then the second array 
 *  would have 3 in the slot for (1) and 2 in the slot for (4). The easiest
 *  way to do this might be to have a seven-element array, and ignore index
 *  0. (I'll put in a -1 so I remember it doesn't count.) This would then look 
 *  like {-1, 3, 0, 0, 2, 0, 0}. - such a secondary array will make it MUCH 
 *  easier to find things like four of a kind, a bunch of 3's, or a full house.
 */
public class Board {

	// TODO: decide which private member variables Board needs and declare them here. 
	//          HINT: See the note above!
	private int[] frequencyList;
	private int[] myDice;


	
	/**
	 * constructor - set up initial values for the board.
	 */
	// TODO: write the Board's constructor
	Board(){
		frequencyList = new int[7];
		myDice = new int[5];
	}
	
	/**
	 * toString - creates a string depicting the dice on the board.
	 * @return a string depicting the dice.
	 * I suggest that you also put letters to label which die is which, for example:
	 * +---+---+---+---+---+
	 * | A | B | C | D | E |
	 * +---+---+---+---+---+
	 * | 1 | 1 | 4 | 1 | 4 |
	 * +---+---+---+---+---+
	 */
	// TODO: write the Board's toString method
	
	/**
	 * rollSelectedDice - takes a string and goes letter by letter; if a
	 * letter is in the range A-E, it randomizes the corresponding die.
	 * e.g., if the string is "ABE," then you would roll dice 0, 1, and 4.
	 * To roll all the dice, send it "ABCDE."
	 * I suggest you call updateFrequencyList at the end of this method.
	 * 
	 * @param - a string to parse. (e.g., "CE")
	 * no return value - only internal variables are changed.
	 */
	
	/**
	 * recalculates the frequency list - how many 1s are showing on the dice? 
	 *    How many 2s are showing? 3s? 4s? 5s? 6s?
	 * postcondition: the frequency list now reflects the current state of the dice.
	 * No return value - only internal variables are changed.
	 */
	public void updateFrequencyList()
	{
		// ---------------------------
		// TODO: write your code here.
		for(int i=0; i< myDice.length; i++){
			frequencyList[myDice[i]] ++;
		}
		// ---------------------------
	}
	
	
	/**
	 * getScoreForCategory - considers the current set of dice and calculates
	 * what score would be awarded if the player picks the given category.
	 * Although some simple categories can be handled here, I'd suggest you write a
	 * sub-method for each of the complicated ones (or write separate methods for every one of them) to
	 * perform this calculation, rather than a single, 100+ line method! 
	 * @param - category. This is an integer. However, rather than putting code numbers 
	 *   in your code, it will be more readable if you use well-named constants.
	 *   I would refer you to the public final variables in the ScoreCard class (e.g., ScoreCard.ONES) - it
	 *   will be easier to read than the code numbers, themselves. (See the example below.)
	 * @return how many points should be awarded, based on the dice and the
	 *   category selected.
	 *   For example: 
	 *   Consider the dice as {1,1,4,1,4}; then 
	 *    •this would correspond to the frequencies list: {0, 3, 0, 0, 2, 0}  
	 *    •getScoreForCategory(ScoreCard.ONES) would return 3.
	 *    •getScoreForCategory(ScoreCard.TWOS) would return 0.
	 *    •getScoreForCategory(ScoreCard.FOURS) would return 8.
	 *    •getScoreForCategory(ScoreCard.THREE_OF_A_KIND) would return 11.
	 *    •getScoreForCategory(ScoreCard.FULL_HOUSE) would return 25.
	 *    •getScoreForCategory(ScoreCard.LARGE_STRAIGHT) would return 0.
	 */
	// TODO: Write Board's getScoreForCategory method.
	// polite suggestion... break this into smaller methods for the various categories. Some of these methods, like the
	//    ones at the top of the card might work for more than one category. Others, like for full house, might be more
	//    specialized....
	public int getScoreForCategory(int category){
		if(category <=5 && category>=0){
			return(getScoreForUppers(category));
		}
		if(category== 6 || category==7){
			return(getScoreForXofKind(category));
		}
		if(category== 8){
			return(getScoreForFullHouse());
		}
		if(category== 9 || category==10){
			return (getScoreForStraights(category));
		}
		if(category== 12){
			return(getScoreForYahtzee());
		}
		if(category== 11) {
			return (getScoreForChance());
		}
		return -1;

	}
	public int getScoreForUppers(int category){
		System.out.println(frequencyList[category+1]);
		return((category+1)*frequencyList[category+1]);
	}
	public int getScoreForStraights(int category){

		if (category==9){

			for( int i = 1; i<= 3;i++){
				boolean smStraight=true;
				for (int j=0; j<=3;j++){
					if (frequencyList[i+j]==0){
						smStraight=false;
						break;
					}
				}
				if (smStraight){
					return(30);
				}
			}
			return(0);
		}
		if (category==10){
			for( int i = 1; i<= 2;i++){
				boolean lgStraight=true;
				for (int j=0; j<=4;j++){
					if (frequencyList[i+j]==0){
						lgStraight=false;
						break;
					}

				}
				if (lgStraight){
					return(40);
				}
			}
			return(0);
		}
		return(-1);

	}
	public int getScoreForYahtzee(){
		for(int frequency: frequencyList){
			if (frequency==5){
				return(50);
			}
		}
		return(0);
	}
	public int getScoreForChance(){
		int total = 0;
		for(int die : myDice){
			total+=die;
		}
		return(total);
	}
	public int getScoreForFullHouse(){
		boolean twoOfKind = false;
		boolean threeOfKind= false;
		for(int frequency: frequencyList){
			if(frequency == 2){
				twoOfKind = true;
			}
			if (frequency==3){
				threeOfKind=true;
			}
		}
		if(twoOfKind&&threeOfKind){
			return(25);
		}
		return (0);
	}
	public int getScoreForXofKind(int category){
		if(category==6) {
			for (int i = 1; i < frequencyList.length; i++) {
				if (frequencyList[i]>=3){
					return(3*i);
				}
			}
		}
		if(category==7) {
			for (int i = 1; i < frequencyList.length; i++) {
				if (frequencyList[i]>=4){
					return(4*i);
				}
			}
		}
		return(0);
	}

	/**
	 * gets the list of die frequencies calculated in the updateFrequencies() method.
	 * @return the list of frequencies.
	 */
	public int[] getFrequencies()
	{
		return frequencyList;
	}

	//----------------------------------- Debugging methods
	// I think you'll find the following methods handy to test how your game scores dice combinations without
	//    having to play the game and wait for the random number generator to give you the hand you're interested in.
	// These next two methods should NEVER be called during normal game play.

	/**
	 * sets the 5 dice to specific values - this should be used for debugging purposes only.
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 */
	public void debugSetDice(int a, int b, int c, int d, int e)
	{
		// ---------------------------
		// TODO: write your code here.
		myDice[0] = a;
		myDice[1] = b;
		myDice[2] = c;
		myDice[3] = d;
		myDice[4] = e;



		// ---------------------------		
	}
	
	public int[] debugGetDice()
	{

		return myDice;
	}
	public int getDieAtIndex(int index){

		return myDice[index];
	}
	public void setDieAtIndex(int index, int new_value){

		myDice[index] = new_value;
	}
}

