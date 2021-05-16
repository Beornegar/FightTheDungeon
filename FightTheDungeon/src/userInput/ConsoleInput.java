package userInput;

import java.util.Scanner;

import game.Difficulty;

public class ConsoleInput implements UserInput {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String INVALID_INPUT = "Invalid action";
	
	@Override
	public UserFightInputTypes getFightInput() {

		UserFightInputTypes userInput = null;

		String input = scanner.nextLine();
		while (null == userInput) {

			if (input.equals("1")) {
				userInput = UserFightInputTypes.FIGHT;
			} else if (input.equals("2")) {
				userInput = UserFightInputTypes.TAKE_HEALTH_POTION;
			} else if (input.equals("3")) {
				userInput = UserFightInputTypes.RUN;
			} else {
				System.out.println(INVALID_INPUT);
				input = scanner.nextLine();
			}

		}

		return userInput;
	}

	@Override
	public UserAfterFightInputTypes getAfterFightInput() {
		UserAfterFightInputTypes userInput = null;

		String input = scanner.nextLine();
		while (null == userInput) {

			if (input.equals("1")) {
				userInput = UserAfterFightInputTypes.NEXT_ROOM;
			} else if (input.equals("2")) {
				userInput = UserAfterFightInputTypes.EXIT_DUNGEON;
			} else {
				System.out.println(INVALID_INPUT);
				input = scanner.nextLine();
			}

		}

		return userInput;
	}

	@Override
	public Difficulty getGameDifficulty() {
		
		Difficulty userInput = null;

		String input = scanner.nextLine();
		while (null == userInput) {

			if (input.equals("1")) {
				userInput = Difficulty.EASY;
			} else if (input.equals("2")) {
				userInput = Difficulty.MEDIUM;
			} else if (input.equals("3")) {
				userInput = Difficulty.HARD;
			} else {
				System.out.println(INVALID_INPUT);
				input = scanner.nextLine();
			}

		}

		return userInput;
		
	}

}
