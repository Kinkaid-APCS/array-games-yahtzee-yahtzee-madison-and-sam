
public class YahtzeeRunner {
	// Sam was here
	// Madison was here


	public static void main(String[] args) {
		Board myBoard = new Board();
		boolean testingMode = true;
		if (testingMode)
		{
			System.out.println("Start tests");
			// enter test code here.
			myBoard.debugSetDice(4,4,3,3,3);
			myBoard.updateFrequencyList();
			System.out.println(myBoard.getScoreForCategory(3));
			System.out.println("End tests");
		}
		else
		{
			Referee ref = new Referee();
			System.out.println("Start game");
			ref.playGame();
			System.out.println("End game");
		}
	}

}
