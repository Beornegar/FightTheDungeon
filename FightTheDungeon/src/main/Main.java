package main;
import display.ConsoleDisplay;
import display.GameActions;
import game.Game;
import userInput.ConsoleInput;
import userInput.UserInput;

public class Main {

	public static void main(String[] args) {

		GameActions displayActions = new ConsoleDisplay();
		UserInput userInput = new ConsoleInput();

		Game game = new Game(displayActions, userInput);
		game.run();
		
	}

}
