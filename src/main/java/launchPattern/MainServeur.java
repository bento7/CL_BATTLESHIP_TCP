package launchPattern;
import game.Board;
import servPattern.ServeurTCP;

public class MainServeur {

	public static void main(String[] args) {
		Board myboard = new Board(10);
		myboard.openBoard();
	}
}
