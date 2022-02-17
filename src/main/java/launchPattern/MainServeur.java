package launchPattern;
import game.Battleship;
import game.Board;
import servPattern.ServeurTCP;

public class MainServeur {

	public static void main(String[] args) {
		Battleship mybattle = new Battleship(3);
		mybattle.openBattleship();
	}
}
