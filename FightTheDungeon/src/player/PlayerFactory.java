package player;

import java.util.Arrays;
import java.util.LinkedList;

import consumables.HealthPotion;
import game.Difficulty;

public class PlayerFactory {

	public static Player getPlayerBasedOnDifficulty(Difficulty difficulty) {

		return switch (difficulty) {
		case EASY -> new Player(150, 10, 40, 50, new LinkedList<HealthPotion>(
				Arrays.asList(new HealthPotion(), new HealthPotion(), new HealthPotion())));
		case MEDIUM -> new Player(125, 8, 35, 40, new LinkedList<HealthPotion>(
				Arrays.asList(new HealthPotion(), new HealthPotion(), new HealthPotion())));
		case HARD -> new Player(100, 5, 25, 30, new LinkedList<HealthPotion>(
				Arrays.asList(new HealthPotion(), new HealthPotion(), new HealthPotion())));
		};

	}

}
