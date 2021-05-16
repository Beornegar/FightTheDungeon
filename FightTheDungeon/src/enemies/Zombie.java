package enemies;

public class Zombie extends Enemy {

	public Zombie(float modifier) {
		name = "Zombie";

		maxHealth = (int) (30 * modifier);
		maxDamage = (int) (25 * modifier);

		health = getInitialHealth();
		armor = (int) (15 * modifier);
		speed = (int) (5 * modifier);
	}

}
