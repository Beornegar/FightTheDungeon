package enemies;

public class Warrior extends Enemy {

	public Warrior(float modifier) {
		name = "Warrior";

		maxHealth = (int) (60 * modifier);
		maxDamage = (int) (30 * modifier);

		health = getInitialHealth();
		armor = (int) (10 * modifier);
		speed = (int) (20 * modifier);
	}

}
