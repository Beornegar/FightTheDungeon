package enemies;

import java.util.List;
import java.util.Random;

public enum EnemyTypes {

	SKELETON, ZOMBIE, WARRIOR, ASSASSIN;

	private static final List<EnemyTypes> VALUES = List.of(values());
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static EnemyTypes randomEnemyType() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

}
