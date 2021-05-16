package userInput;

import game.Difficulty;

public interface UserInput {

	public UserFightInputTypes getFightInput();
	
	public UserAfterFightInputTypes getAfterFightInput();
	
	public Difficulty getGameDifficulty();
	
}
