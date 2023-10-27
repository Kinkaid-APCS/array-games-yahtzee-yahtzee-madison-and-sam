
public class YahtzeeRunner {
	// Sam was here
	// Madison was here


	public static void main(String[] args) {
		Board myBoard = new Board();
		Referee myRef = new Referee();
		boolean testingMode = true;
		if (testingMode)
		{
			System.out.println("Start tests");
			// enter test code here.
			myBoard.debugSetDice(6,6,6,6,6);
			myBoard.updateFrequencyList();
			System.out.println(myBoard.getScoreForCategory(12));
			System.out.println("End tests");
			myRef.displayBoardAndDice();

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
