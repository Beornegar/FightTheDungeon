package enemies;

import game.Difficulty;

public class EnemyFactory {

	public static Enemy getRandomEnemy(Difficulty difficulty, int numberOfDefeatedEnemies) {
		
		float statsModifier = difficulty == Difficulty.EASY ? 1 : difficulty == Difficulty.MEDIUM ? 1.5f : 2f;
		statsModifier += numberOfDefeatedEnemies / 10;
		
		return getEnemy(EnemyTypes.randomEnemyType(), statsModifier);
	}
	
	public static Enemy getEnemy(EnemyTypes type, float modifier) {
		
		Enemy enemy = switch(type) {
			case ASSASSIN -> new Assassin(modifier);
			case SKELETON -> new Skeleton(modifier);
			case WARRIOR -> new Warrior(modifier);
			case ZOMBIE -> new Zombie(modifier);
		};
		
		return enemy;
	}

}
